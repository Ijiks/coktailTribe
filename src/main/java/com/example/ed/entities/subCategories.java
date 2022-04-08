package com.example.ed.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class subCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double quantity;
    private String abv;
    private Double basePrice;
    @ManyToOne
    private Categories category;

    public subCategories(Long id, String name, String description) {
        super( );
        this.id = id;
        this.name = name;
        this.description=description;
    }

    public subCategories(Long id) {
        this.id = id;
    }

    public subCategories() {
        super( );
    }


    @Override
    public String toString() {
        return "subCategories{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}
