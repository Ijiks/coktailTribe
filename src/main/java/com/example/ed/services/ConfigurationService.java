package com.example.ed.services;

import com.example.ed.entities.Categories;
import com.example.ed.entities.Configurations;
import com.example.ed.entities.Details;
import com.example.ed.entities.subCategories;

import java.util.List;

public interface ConfigurationService {
    List<Categories> getAllCategories();

    Categories getCategoryById(Long id);

    Categories getCategoryByName(String name);

    Categories createCategory(Categories category);

    List<subCategories> getAllSubCategories();

    subCategories getSubCategoryById(Long id);

    subCategories getSubCategoryByName(String name);

    subCategories createSubCategory(subCategories subCategory);

    List<Details> getAllDetails();

    Details getDetailsById(Long id);

    Details getDetailsByName(String name);

    Details createDetails(Details details);

    List<Details> getDetailsBySubCategoryId(Long id);

    List<subCategories> getSubCategoriesByCategoryId(Long id);

    List<Configurations> getAllConfigs();

    Configurations createConfig(Configurations configuration_);

    Configurations getConfigByName(String transport_rate);

    void createSubDetailsList(List<Details> details_);
}
