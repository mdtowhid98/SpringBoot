package com.towhid.practicepharmacy.service;

import com.towhid.practicepharmacy.entity.Category;
import com.towhid.practicepharmacy.entity.Product;
import com.towhid.practicepharmacy.repository.CategoryRepository;
import com.towhid.practicepharmacy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Value("src/main/resources/static/images")
    private String uploadDir;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public void saveProduct(Product product, MultipartFile imageFile) throws IOException {

        Category category = categoryRepository.findById(product.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category with this id not found"));

        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFileName = saveImage(imageFile, product);
            product.setPhoto(imageFileName);
        }

        productRepository.save(product);
    }


    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }

    public Product findProductById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product With This Id Not Found"));
    }

    @Transactional
    public void updateProduct(int id, Product updateProduct, MultipartFile imageFile) throws IOException {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product With This Id Not Found"));

        existingProduct.setName(updateProduct.getName());
        existingProduct.setPhoto(updateProduct.getPhoto());
        existingProduct.setStock(updateProduct.getStock());
        existingProduct.setQuantity(updateProduct.getQuantity());


        Category category = categoryRepository.findById(updateProduct.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category with this id not found"));
        existingProduct.setCategory(category);

        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFilename = saveImage(imageFile, existingProduct);
            existingProduct.setPhoto(imageFilename);
        }
        productRepository.save(existingProduct);

    }

    public List<Product>findProductByCategoryName(String categoryName){
        return productRepository.finndProductByCategoryName(categoryName);
    }

    public String saveImage(MultipartFile file, Product p) throws IOException {
        Path uploadPath = Paths.get(uploadDir + "/product");

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String filename = p.getName() + "_" + UUID.randomUUID().toString();
        Path filePath = uploadPath.resolve(filename);

        Files.copy(file.getInputStream(), filePath);


        return filename;
    }


}
