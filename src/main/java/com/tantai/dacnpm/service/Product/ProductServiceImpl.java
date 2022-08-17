package com.tantai.dacnpm.service.Product;

import com.tantai.dacnpm.dto.ProductDto;
import com.tantai.dacnpm.repo.ProductRepository;
import com.tantai.dacnpm.utils.ProductConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductConverter productConverter;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductDto add(ProductDto productDto) {
        return productConverter.convertToDto(productRepository.save(productConverter.convertToEntity(productDto)));
    }

    @Override
    public List<ProductDto> getAll() {
        return null;
    }
}
