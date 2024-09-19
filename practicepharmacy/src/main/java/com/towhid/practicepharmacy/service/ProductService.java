package com.towhid.practicepharmacy.service;

import com.towhid.practicepharmacy.entity.Category;
import com.towhid.practicepharmacy.entity.Product;
import com.towhid.practicepharmacy.repository.CategoryRepository;
import com.towhid.practicepharmacy.repository.ProductRepository;
import com.towhid.practicepharmacy.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
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

//    public void saveProduct(Product product, MultipartFile imageFile) throws IOException {
//
//        Category category = categoryRepository.findById(product.getCategory().getId())
//                .orElseThrow(() -> new RuntimeException("Category with this id not found"));
//
//        if (imageFile != null && !imageFile.isEmpty()) {
//            String imageFileName = saveImage(imageFile, product);
//            product.setPhoto(imageFileName);
//        }
//
//        productRepository.save(product);
//    }


    public ApiResponse saveProduct(Product product, MultipartFile imageFile) throws IOException {
        ApiResponse apiResponse = new ApiResponse();
        try {
            // Validate product data
            if (product.getName() == null || product.getCategory() == null) {
                throw new RuntimeException("Product name and category are required");
            }

            // Check if category exists
            Category category = categoryRepository.findById(product.getCategory().getId())
                    .orElseThrow(() -> new RuntimeException("Category with this id not found"));
            product.setCategory(category);

            // Check if a product with the same name already exists
            List<Product> existingProducts = productRepository.findProductByName(product.getName());
            if (!existingProducts.isEmpty()) {
                // Assuming there is only one product with the same name
                Product existingProduct = existingProducts.get(0);

                // Update the stock by adding the new stock to the existing stock
                int updatedStock = existingProduct.getStock() + product.getStock();
                existingProduct.setStock(updatedStock);

                // Update other product details if needed (e.g., price, category)
                existingProduct.setUnitprice(product.getUnitprice());

                // Handle image file (update photo if new image is provided)
                if (imageFile != null && !imageFile.isEmpty()) {
                    String imageFileName = saveImage(imageFile, existingProduct);
                    existingProduct.setPhoto(imageFileName);
                }

                // Save the updated product
                productRepository.save(existingProduct);

                apiResponse.setSuccessful(true);
                apiResponse.setMessage("Product already exists. Stock updated.");
            } else {
                // Handle image file for new product
                if (imageFile != null && !imageFile.isEmpty()) {
                    String imageFileName = saveImage(imageFile, product);
                    product.setPhoto(imageFileName);
                }

                // Save the new product
                productRepository.save(product);
                apiResponse.setSuccessful(true);
                apiResponse.setMessage("Product saved successfully");
            }
        } catch (Exception e) {
            apiResponse.setMessage(e.getMessage());
            apiResponse.setSuccessful(false);
        }
        return apiResponse;
    }



    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }

    public Product findProductById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product With This Id Not Found"));
    }

//    @Transactional
//    public void updateProduct(int id, Product updateProduct, MultipartFile imageFile) throws IOException {
//        Product existingProduct = productRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Product With This Id Not Found"));
//
//        existingProduct.setName(updateProduct.getName());
//        existingProduct.setPhoto(updateProduct.getPhoto());
//        existingProduct.setStock(updateProduct.getStock());
//        existingProduct.setQuantity(updateProduct.getQuantity());
//
//
//        Category category = categoryRepository.findById(updateProduct.getCategory().getId())
//                .orElseThrow(() -> new RuntimeException("Category with this id not found"));
//        existingProduct.setCategory(category);
//
//        if (imageFile != null && !imageFile.isEmpty()) {
//            String imageFilename = saveImage(imageFile, existingProduct);
//            existingProduct.setPhoto(imageFilename);
//        }
//        productRepository.save(existingProduct);
//
//    }

    public List<Product>findProductByCategoryName(String categoryName){
        return productRepository.finndProductByCategoryName(categoryName);
    }

    public List<Product>findProductByName(String productName){
        return productRepository.findProductByName(productName);
    }

    public Product updateProduct(Product product, int id, MultipartFile file) throws IOException {
        Product existingProduct = this.productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Not Found"));

        // Update product details
        existingProduct.setName(product.getName());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setUnitprice(product.getUnitprice());
        existingProduct.setQuantity(product.getQuantity());

        // Update the stock: Add the incoming stock to the existing stock
        int updatedStock = existingProduct.getStock() + product.getStock(); // Assuming you're adding stock
        existingProduct.setStock(updatedStock);

        // If a new image file is provided, save it
        if (file != null && !file.isEmpty()) {
            String imageFileName = this.saveImage(file, existingProduct);
            existingProduct.setPhoto(imageFileName);
        }

        // Save the updated product
        return this.productRepository.save(existingProduct);
    }





    public String saveImage(MultipartFile file, Product product) throws IOException {
        Path uploadPath = Paths.get(uploadDir + "/product");

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Sanitize file name
        String filename = product.getName().replaceAll("[^a-zA-Z0-9.-]", "_") + "_" + UUID.randomUUID().toString();
        Path filePath = uploadPath.resolve(filename);

        Files.copy(file.getInputStream(), filePath);

        return filename;
    }

//    @Transactional
//    public void updateProductStock(String name, int newStock) {
//        List<Product> products = productRepository.findProductByName(name);
//
//        if (products.isEmpty()) {
//            throw new RuntimeException("Product with name " + name + " not found");
//        } else if (products.size() == 1) {
//            Product product = products.get(0);
//            product.setStock(product.getStock() + newStock);
//            productRepository.save(product);
//        } else {
//            // Handle multiple products with the same name (display warning or prompt user for selection)
//            // Implement logic based on your specific requirements
//        }
//    }

//    public Product updateProducts(int productId, Product updatedProduct) {
//        return productRepository.findById(productId)
//                .map(product -> {
//                    // Update product details (except stock)
//                    product.setName(updatedProduct.getName());
//                    product.setUnitprice(updatedProduct.getUnitprice());
//                    product.setCategory(updatedProduct.getCategory());
//
//                    // Update stock: Add new stock to existing stock
//                    int updatedStock = product.getStock() + updatedProduct.getStock(); // Assuming you're adding stock
//                    product.setStock(updatedStock);
//
//                    // Save the updated product
//                    return productRepository.save(product);
//                })
//                .orElseThrow(() -> new RuntimeException("Product not found with id " + productId));
//    }


}
