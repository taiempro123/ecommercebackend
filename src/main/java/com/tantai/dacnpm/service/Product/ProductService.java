package com.tantai.dacnpm.service.Product;

import com.tantai.dacnpm.dto.ProductDto;
import com.tantai.dacnpm.entity.User;

import java.util.List;

public interface ProductService{
    ProductDto add(ProductDto productDto);
    List<ProductDto> getAll();

}
