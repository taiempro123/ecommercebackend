package com.tantai.dacnpm.utils;

import com.tantai.dacnpm.dto.ProductDto;
import com.tantai.dacnpm.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductConverter {
    @Autowired
    private ModelMapper modelMapper;
    public Product convertToEntity(ProductDto dto){
        return modelMapper.map(dto,Product.class);
    }
    public ProductDto convertToDto(Product entity){
        return modelMapper.map(entity,ProductDto.class);
    }
}
