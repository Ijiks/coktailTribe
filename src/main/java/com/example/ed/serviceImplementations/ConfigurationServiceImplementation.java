package com.example.ed.serviceImplementations;

import com.example.ed.entities.Categories;
import com.example.ed.entities.Configurations;
import com.example.ed.entities.Details;
import com.example.ed.entities.subCategories;
import com.example.ed.repositories.CategoryRepository;
import com.example.ed.repositories.ConfigRepo;
import com.example.ed.repositories.DetailsRepository;
import com.example.ed.repositories.subCategoryRepository;
import com.example.ed.services.ConfigurationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfigurationServiceImplementation implements ConfigurationService {
     private final CategoryRepository category;
     private final subCategoryRepository subCategory;
     private final DetailsRepository details;
     private final ConfigRepo configRepo;

    public ConfigurationServiceImplementation(CategoryRepository category, subCategoryRepository subCategory, DetailsRepository details, ConfigRepo configRepo) {
        this.category = category;
        this.subCategory = subCategory;
        this.details = details;
        this.configRepo = configRepo;
    }
    //configurations
   public Configurations createConfig(Configurations config){
        return configRepo.save(config);
   }
   public List<Configurations> getAllConfigs(){
        return configRepo.findAll();
   }
   public Configurations getConfigByName(String configName){
        return configRepo.findByConfigurationName(configName);
   }
    //single saving of data
    public Categories createCategory(Categories categories){
        return category.save(categories);
    }
    public subCategories createSubCategory(subCategories subCategories){
        return subCategory.save(subCategories);
    }
    public Details createDetails(Details detail_s){
        return details.save(detail_s);
    }
   //getting data
    public List<Categories> getAllCategories(){
        return category.findAll();
    }
    public Categories getCategoryById(Long id){
        Optional<Categories> category_=category.findById(id);
        Categories workingCategory = null;
        if (category_.isPresent()){
            workingCategory=category_.get();
        }
        return workingCategory;
    }
    public Categories getCategoryByName(String name){
        return category.findByCategoryName(name);
    }
    public List<subCategories> getAllSubCategories(){
        return subCategory.findAll();
    }
    public subCategories getSubCategoryById(Long id){
        Optional<subCategories> subCategory_=subCategory.findById(id);
        subCategories workingSubCategory_ = null;
        if (subCategory_.isPresent()){
            workingSubCategory_=subCategory_.get();
        }
        return workingSubCategory_;
    }
    public subCategories getSubCategoryByName(String name){
        return subCategory.findByName(name);
    }
    public List<subCategories> getSubCategoriesByCategoryId(Long id){
        Categories categories=this.getCategoryById(id);
        return subCategory.findByCategory(categories);
    }
    public List<Details> getAllDetails(){
        return details.findAll();
    }
    public Details getDetailsById(Long id){
        Optional<Details> details_=details.findById(id);
        Details workingDetails=new Details();
        if (details_.isPresent()){
            workingDetails=details_.get();
        }
        return workingDetails;
    }
    public Details getDetailsByName(String name){
        return details.findByName(name);
    }
    public List<Details> getDetailsBySubCategoryId(Long id){
        subCategories categories=this.getSubCategoryById(id);
        return details.findBySubCategory(categories);
    }
    //data bulk saving
    public void createCategoryList(List<Categories> categories){
             category.saveAll(categories);
    }
    public void createSubCategoryList(List<subCategories> subCategories){
        subCategory.saveAll(subCategories);

    }
    public void createSubDetailsList(List<Details> detailsList){
        details.saveAll(detailsList);
    }


}
