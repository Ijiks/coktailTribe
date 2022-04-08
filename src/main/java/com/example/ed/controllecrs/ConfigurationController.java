package com.example.ed.controllecrs;

import com.example.ed.entities.Categories;
import com.example.ed.entities.Details;
import com.example.ed.entities.subCategories;
import com.example.ed.serviceImplementations.ConfigurationServiceImplementation;
import com.example.ed.services.ConfigurationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("configuration")
public class ConfigurationController {
    private ConfigurationService configurationService;

    public ConfigurationController(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }
   //creating category
    @GetMapping("/allCategories")
    public ResponseEntity<List<Categories>> getAllCategories(){
       List<Categories> categories=configurationService.getAllCategories();

       return new ResponseEntity<>(categories, HttpStatus.OK);
   }
    @GetMapping("/findCategoryById")
    public ResponseEntity<Categories> getCategoryById(Long id){
        Categories categories=configurationService.getCategoryById(id);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping("/findCategoryByName")
    public ResponseEntity<Categories> getCategoryByName(String name){
        Categories categories=configurationService.getCategoryByName(name);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @PostMapping("/createCategory")
    public ResponseEntity<Categories> createCategory(@RequestBody Categories Category){
        Categories categories=configurationService.createCategory(Category);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    //creating subcategory
    @GetMapping("/allSubCategories")
    public ResponseEntity<List<subCategories>> getAllSubCategories(){
        List<subCategories> categories=configurationService.getAllSubCategories();

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping("/allSubCategoriesByCategoryId")
    public ResponseEntity<List<subCategories>> getAllSubCategoriesByCategoryId(Long id){
        List<subCategories> categories=configurationService.getSubCategoriesByCategoryId(id);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping("/findSubCategoryById")
    public ResponseEntity<subCategories> getSubCategoryById(Long id){
        subCategories categories=configurationService.getSubCategoryById(id);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping("/findSubCategoryByName")
    public ResponseEntity<subCategories> getSubCategoryByName(String name){
        subCategories categories=configurationService.getSubCategoryByName(name);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @PostMapping("/createSubCategory")
    public ResponseEntity<subCategories> createSubCategory(@RequestBody subCategories subCategory){
        subCategories categories=configurationService.createSubCategory(subCategory);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    //creating Details
    @GetMapping("/allDetails")
    public ResponseEntity<List<Details>> getAllDetails(){
        List<Details> categories=configurationService.getAllDetails();

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping("/allDetailsBySubCategoryId")
    public ResponseEntity<List<Details>> getAllDetailsBySubCategoryId(Long id){
        List<Details> categories=configurationService.getDetailsBySubCategoryId(id);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping("/findDetailsById")
    public ResponseEntity<Details> getDetailsById(Long id){
        Details details=configurationService.getDetailsById(id);

        return new ResponseEntity<>(details, HttpStatus.OK);
    }
    @GetMapping("/findDetailsByName")
    public ResponseEntity<Details> getDetailsByName(String name){
        Details details=configurationService.getDetailsByName(name);

        return new ResponseEntity<>(details, HttpStatus.OK);
    }
    @PostMapping("/createDetails")
    public ResponseEntity<Details> createDetails(@RequestBody Details details){
        Details details_=configurationService.createDetails(details);

        return new ResponseEntity<>(details_, HttpStatus.OK);
    }
}
