package com.tantai.dacnpm.controller;

import com.tantai.dacnpm.dto.ProductDto;
import com.tantai.dacnpm.dto.ResponseObject;
import com.tantai.dacnpm.service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {
@Autowired
   private ProductService productService;
@PostMapping("/add")
   ResponseEntity<ResponseObject> addProduct(@RequestBody ProductDto productDto){
   try{
      System.out.println("xxxx");
      ProductDto dto = productService.add(productDto);
      return ResponseEntity.status(HttpStatus.OK).body(
              new ResponseObject("ok","Add product success!",dto));
   }catch (Exception e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
              new ResponseObject("failed","Failed",""));
   }


}
}
