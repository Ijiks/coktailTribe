package com.example.ed.repositories;

import com.example.ed.entities.Details;
import com.example.ed.entities.subCategories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailsRepository extends JpaRepository<Details, Long> {
    Details findByName(String name);

    List<Details> findBySubCategory(subCategories categories);
}
