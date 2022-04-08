package com.example.ed.models;


import com.example.ed.entities.Products;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderModel {
    private List<Products> products;
}
