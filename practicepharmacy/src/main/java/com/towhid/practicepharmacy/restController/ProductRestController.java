package com.towhid.practicepharmacy.restController;

import com.towhid.practicepharmacy.entity.Product;
import com.towhid.practicepharmacy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class ProductRestController {

    @Autowired
    private ProductService productService;


    @PostMapping("/save")
    public ResponseEntity<String> saveProduct(
            @RequestPart(value = "product") Product product,
            @RequestParam(value = "image", required = true) MultipartFile file
    ) throws IOException {
        productService.saveProduct(product, file);

        return new ResponseEntity<>("Product added succesfully with image", HttpStatus.OK);

    }


    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/h/searchproduct")
    public ResponseEntity<List<Product>>findProductByCategoryName(@RequestParam(value ="categoryName" )String categoryName){
        List<Product> products=productService.findProductByCategoryName(categoryName);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product>findProductById(@PathVariable int id){
        try {
            Product product=productService.findProductById(id);
            return ResponseEntity.ok(product);
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



}
