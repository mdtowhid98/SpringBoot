package com.towhid.practicepharmacy.service;

import com.towhid.practicepharmacy.entity.Product;
import com.towhid.practicepharmacy.entity.Sales;
import com.towhid.practicepharmacy.entity.SalesProduct;
import com.towhid.practicepharmacy.repository.CategoryRepository;
import com.towhid.practicepharmacy.repository.ProductRepository;
import com.towhid.practicepharmacy.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalesService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SalesRepository salesRepository;


    public List<Sales> getAllSales() {

        return salesRepository.findAll();
    }

//    public void saveSales(Sales s) {
//        Product product = productRepository.findById(s.getProduct().getId())
//                .orElseThrow(
//                        () -> new RuntimeException("Product not found " + s.getProduct().getId())
//                );
//        s.setProduct(product);
//        salesRepository.save(s);
//    }

    public Sales saveSales(Sales sales) {
        // List to hold SalesProduct entities
        List<SalesProduct> salesProducts = new ArrayList<>();

        // Iterate over each product in the sale
        for (SalesProduct soldProduct : sales.getSalesProducts()) {
            // Retrieve the product from the database
            Product product = productRepository.findById(soldProduct.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found with ID " + soldProduct.getProduct().getId()));

            // Update the product's stock
            int newStock = product.getStock() - soldProduct.getQuantity();
            if (newStock < 0) {
                throw new RuntimeException("Not enough stock for product " + product.getName());
            }
            product.setStock(newStock);

            // Save the updated product
            productRepository.save(product);

            // Add the sold product to the salesProducts list
            salesProducts.add(soldProduct);
        }

        // Set the updated list of SalesProduct in the Sales entity
        sales.setSalesProducts(salesProducts);

        // Save the sale
        return salesRepository.save(sales);
    }


    public void deleteSalesById(int id) {
        salesRepository.deleteById(id);
    }


}
