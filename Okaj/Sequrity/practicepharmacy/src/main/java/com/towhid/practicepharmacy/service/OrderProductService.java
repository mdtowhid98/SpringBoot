package com.towhid.practicepharmacy.service;

import com.towhid.practicepharmacy.entity.*;
import com.towhid.practicepharmacy.repository.CustomerRepository;
import com.towhid.practicepharmacy.repository.OrderProductRepository;
import com.towhid.practicepharmacy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductService {


    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<OrderProduct> getAllOrder() {

        return orderProductRepository.findAll();
    }

    public OrderProduct saveOrder(OrderProduct orderProduct) {

        Product product = productRepository.findById(orderProduct.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product with this id not found."));
        orderProduct.setProduct(product);

        // Check if supplier exists
        Customer customer = customerRepository.findById(orderProduct.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer with this id not found."));
        orderProduct.setCustomer(customer);


        return orderProductRepository.save(orderProduct);
    }


}
