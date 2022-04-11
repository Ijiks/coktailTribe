package com.example.ed.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double quantity;
    private Double price;
    private String name;
    private String description;

    @ManyToOne
    private subCategories subCategory;



    public Details(Long id, Double quantity, Double price, String name, String description) {
        super();
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public Details() {
        super();
    }
    public Details(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Details{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", subCategory=" + subCategory +
                '}';
    }
}
