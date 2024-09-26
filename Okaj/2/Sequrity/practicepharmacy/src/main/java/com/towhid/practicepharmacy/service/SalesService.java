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

//    public Sales saveSales(Sales sales) {
//        // Iterate over each product in the sale
//        for (Product soldProduct : sales.getProduct()) {
//            // Retrieve the product from the database
//            Product product = productRepository.findById(soldProduct.getId())
//                    .orElseThrow(() -> new RuntimeException("Product not found with ID " + soldProduct.getId()));
//
//            // Update the product's stock
//            int newStock = product.getStock() - soldProduct.getQuantity();
//            if (newStock < 0) {
//                throw new RuntimeException("Not enough stock for product " + product.getName());
//            }
//            product.setStock(newStock);
//
//            // Save the updated product
//            productRepository.save(product);
//        }
//
//        // Save the sale
//        return salesRepository.save(sales);
//    }


    public Sales saveSales(Sales sales) {
        // First, save the sale to the database so it gets a generated ID
        Sales savedSales = salesRepository.save(sales);

        // Iterate over each product in the sale
        for (Product soldProduct : savedSales.getProduct()) {
            // Retrieve the product from the database
            Product product = productRepository.findById(soldProduct.getId())
                    .orElseThrow(() -> new RuntimeException("Product not found with ID " + soldProduct.getId()));

            // Update the product's stock
            int newStock = product.getStock() - soldProduct.getQuantity();
            if (newStock < 0) {
                throw new RuntimeException("Not enough stock for product " + product.getName());
            }
            product.setStock(newStock);

            // Save the updated product
            productRepository.save(product);

            // Create a new SalesDetails entry for this product in the sale
            SalesDetails salesDetails = new SalesDetails();
            salesDetails.setSale(savedSales); // Set the saved Sales entity reference
            salesDetails.setProduct(product); // Set the product reference
            salesDetails.setQuantity(soldProduct.getQuantity()); // Set the quantity sold
            salesDetails.setUnitPrice(product.getUnitprice()); // Assuming the price is set in the product
            salesDetails.setTotalPrice(soldProduct.getQuantity() * product.getUnitprice()); // Total price

            // Save the SalesDetails entry to the database
            salesDetailsRepository.save(salesDetails);
        }

        // Return the saved sale
        return savedSales;
    }





    public void deleteSalesById(int id) {
        salesRepository.deleteById(id);
    }


}
