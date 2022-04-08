package com.example.ed.models;

import com.example.ed.entities.Details;
import com.example.ed.entities.subCategories;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductModel {
    private String name;
    private String productDescription;
    private Double proposedRetailPrice;
    private List<subCategories> content;
}
