package com.tantai.dacnpm.service.category;


import com.tantai.dacnpm.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category add(Category category);
    Optional<Category> getAll();
    Optional<Category> getByCategoryName(String categoryName);
}
