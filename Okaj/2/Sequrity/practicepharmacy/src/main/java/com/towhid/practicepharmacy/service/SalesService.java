package com.towhid.practicepharmacy.service;

import com.towhid.practicepharmacy.entity.Branch;
import com.towhid.practicepharmacy.entity.Product;
import com.towhid.practicepharmacy.entity.Sales;
import com.towhid.practicepharmacy.entity.SalesDetails;
import com.towhid.practicepharmacy.repository.*;
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

    @Autowired
    private BranchRepository branchRepository;


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

        // Get the selected branch for the sale
        Branch branch = branchRepository.findById(sales.getBranch().getId())
                .orElseThrow(() -> new RuntimeException("Branch with this ID not found."));
        sales.setBranch(branch);

        for (Product soldProduct : savedSales.getProduct()) {
            // Fetch the product from the database for the selected branch
            Product product = productRepository.findProductByNameAndBranch(soldProduct.getName(), branch.getBranchName())
                    .stream().findFirst()
                    .orElseThrow(() -> new RuntimeException("Product " + soldProduct.getName() + " not found in branch " + branch.getBranchName()));

            // Update stock for the product in the selected branch
            int newStock = product.getStock() - soldProduct.getQuantity();
            if (newStock < 0) {
                throw new RuntimeException("Not enough stock for product " + product.getName() + " in branch " + branch.getBranchName());
            }
            product.setStock(newStock);
            productRepository.save(product);

            // Create SalesDetails for each product sold
            SalesDetails salesDetails = new SalesDetails();
            salesDetails.setSale(savedSales);
            salesDetails.setProduct(product);
            salesDetails.setQuantity(soldProduct.getQuantity());
            salesDetails.setUnitPrice(product.getUnitprice());
            salesDetails.setDiscount(sales.getDiscount());

            // Calculate total price after discount
            float discount = sales.getDiscount();
            float unitPrice = product.getUnitprice();
            int quantity = soldProduct.getQuantity();
            float totalPrice = quantity * unitPrice * (1 - discount / 100);
            salesDetails.setTotalPrice(totalPrice);

            // Save the sales details
            salesDetailsRepository.save(salesDetails);
        }

        return savedSales;
    }






    public void deleteSalesById(int id) {

        salesRepository.deleteById(id);
    }


}
