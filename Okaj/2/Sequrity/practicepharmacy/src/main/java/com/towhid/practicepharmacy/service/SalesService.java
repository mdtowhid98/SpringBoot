package com.towhid.practicepharmacy.service;

import com.towhid.practicepharmacy.entity.Product;
import com.towhid.practicepharmacy.entity.Sales;
import com.towhid.practicepharmacy.entity.SalesDetails;
import com.towhid.practicepharmacy.repository.CategoryRepository;
import com.towhid.practicepharmacy.repository.ProductRepository;
import com.towhid.practicepharmacy.repository.SalesDetailsRepository;
import com.towhid.practicepharmacy.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private SalesDetailsRepository salesDetailsRepository;


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
        // Save the sale first to get the generated ID
        Sales savedSales = salesRepository.save(sales);

        for (Product soldProduct : savedSales.getProduct()) {
            Product product = productRepository.findById(soldProduct.getId())
                    .orElseThrow(() -> new RuntimeException("Product not found with ID " + soldProduct.getId()));

            int newStock = product.getStock() - soldProduct.getQuantity();
            if (newStock < 0) {
                throw new RuntimeException("Not enough stock for product " + product.getName());
            }
            product.setStock(newStock);
            productRepository.save(product);

            // Create SalesDetails for each product
            SalesDetails salesDetails = new SalesDetails();
            salesDetails.setSale(savedSales);
            salesDetails.setProduct(product);
            salesDetails.setQuantity(soldProduct.getQuantity());
            salesDetails.setUnitPrice(product.getUnitprice());
            salesDetails.setDiscount(sales.getDiscount());
            // Apply discount (if any) to calculate total price
            float discount = sales.getDiscount();  // Discount from Product
            float unitPrice = product.getUnitprice();
            int quantity = soldProduct.getQuantity();

            // Calculate total price after discount
            float totalPrice = quantity * unitPrice * (1 - discount / 100);
            salesDetails.setTotalPrice(totalPrice);

            // Optional: if you want to store the discount per sale
            salesDetails.setDiscount(discount);  // Set discount if needed

            // Save the sales details
            salesDetailsRepository.save(salesDetails);
        }
        return savedSales;
    }






    public void deleteSalesById(int id) {
        salesRepository.deleteById(id);
    }


}
