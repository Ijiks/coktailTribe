package com.example.ed.repositories;

import com.example.ed.entities.Categories;
import com.example.ed.entities.subCategories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface subCategoryRepository extends JpaRepository<subCategories,Long> {
    subCategories findByName(String name);

    List<subCategories> findByCategory(Categories categories);
}
