package com.tantai.dacnpm.service.category;

import com.tantai.dacnpm.entity.Category;
import com.tantai.dacnpm.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private  CategoryRepository categoryRepository;


    @Override
    public Category add(Category category) {
        return null;
    }

    @Override
    public Optional<Category> getAll() {
        return Optional.empty();
    }

    @Override
    public Optional<Category> getByCategoryName(String categoryName) {
        return Optional.empty();
    }
}
