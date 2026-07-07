package com.example.recipeapp.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "categories")
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;

    @Column(unique = true, nullable = false)
    private String strCategory;
    
    @Column(length = 1000)
    private String strCategoryDescription;
    
    private String strCategoryThumb;

    // No-arg constructor
    public Category() {
    }

    // Parameterized constructor
    public Category(Long idCategory, String strCategory, String strCategoryDescription, String strCategoryThumb) {
        this.idCategory = idCategory;
        this.strCategory = strCategory;
        this.strCategoryDescription = strCategoryDescription;
        this.strCategoryThumb = strCategoryThumb;
    }

    // Getters
    public Long getIdCategory() {
        return idCategory;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public String getStrCategoryDescription() {
        return strCategoryDescription;
    }

    public String getStrCategoryThumb() {
        return strCategoryThumb;
    }

    // Setters
    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public void setStrCategoryDescription(String strCategoryDescription) {
        this.strCategoryDescription = strCategoryDescription;
    }

    public void setStrCategoryThumb(String strCategoryThumb) {
        this.strCategoryThumb = strCategoryThumb;
    }

    // toString method
    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", strCategory='" + strCategory + '\'' +
                ", strCategoryDescription='" + strCategoryDescription + '\'' +
                ", strCategoryThumb='" + strCategoryThumb + '\'' +
                '}';
    }
}
