package com.towhid.practicepharmacy.service;

import com.towhid.practicepharmacy.entity.Customer;
import com.towhid.practicepharmacy.entity.Order;
import com.towhid.practicepharmacy.entity.Product;
import com.towhid.practicepharmacy.repository.CustomerRepository;
import com.towhid.practicepharmacy.repository.OrderRepository;
import com.towhid.practicepharmacy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository OrderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;

//    @Autowired
//    private SupplierRepository supplierRepository;


    public List<Order> getAllSalesOrder() {

        return orderRepository.findAll();
    }

    public void saveOrder(Order salesOrder) {
        // Check if customer exists
        Customer customer = customerRepository.findById(salesOrder.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + salesOrder.getCustomer().getId()));
        salesOrder.setCustomer(customer);

        // Check if supplier exists
//        Supplier supplier = supplierRepository.findById(salesOrder.getSupplier().getId())
//                .orElseThrow(() -> new RuntimeException("Supplier not found with ID: " + salesOrder.getSupplier().getId()));
//        salesOrder.setSupplier(supplier);

        // Iterate over products and verify them
        List<Product> attachedProducts = new ArrayList<>();
        for (Product soldProduct : salesOrder.getProducts()) {
            // Fetch each product from the repository (attach the product to the persistence context)
            Product product = productRepository.findById(soldProduct.getId())
                    .orElseThrow(() -> new RuntimeException("Product not found with ID: " + soldProduct.getId()));

            // Handle stock validation or any other processing logic
            // For example, checking if the quantity ordered exceeds available stock
            if (soldProduct.getStock() > product.getStock()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }

            // Update the stock by subtracting the sold quantity
            product.setStock(product.getStock() - soldProduct.getStock());

            // Add the attached product to the list
            attachedProducts.add(product);
        }

        // Set the attached products list to the sales order
        salesOrder.setProducts(attachedProducts);

        // Save the sales order (now the products are attached to the persistence context)
        orderRepository.save(salesOrder);
    }

}
