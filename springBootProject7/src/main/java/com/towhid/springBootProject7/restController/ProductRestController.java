package com.towhid.springBootProject7.restController;

import com.towhid.springBootProject7.entity.Products;
import com.towhid.springBootProject7.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

   @Autowired
   private ProductService productService;
   @GetMapping("/")
   public List<Products>getAlldep(){
       return productService.getAllDep();
   }
   @PostMapping("/save")
   public void saveDep(@RequestBody Products d){
       productService.saveDep(d);
   }
   @DeleteMapping("/delete/{id}")
   public void deleteDep(@PathVariable int id){
       productService.deletedepById(id);
   }

   @PutMapping("/update/{id}")
   public void updateDep(@RequestBody Products d){

       productService.saveDep(d);
   }


}
