package com.naukma.supermarket.model;

public class Category {

    private Integer category_number;
    private String category_name;

    public Category() {
    }

    public Category(String category_name) {
        this.category_name = category_name;
    }

    public Category(Integer category_number, String category_name) {
        this.category_name = category_name;
        this.category_name = category_name;
    }


    public Integer getCategory_number() {
        return category_number;
    }

    public void setCategory_number(Integer category_number) {
        this.category_number = category_number;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_number=" + category_number +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
