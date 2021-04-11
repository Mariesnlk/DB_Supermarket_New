package com.naukma.supermarket.model;

public class Product {

    private Integer id_product;
    private Integer category_number;
    private String product_name;
    private String characteristics;

    public Product() { }

    public Product(String product_name) {
        this.product_name = product_name;
    }

    public Product(Integer category_number, String product_name, String characteristics) {
        this.category_number = category_number;
        this.product_name = product_name;
        this.characteristics = characteristics;
    }

    public Product(Integer id_product, Integer category_number, String product_name, String characteristics) {
        this.id_product = id_product;
        this.category_number = category_number;
        this.product_name = product_name;
        this.characteristics = characteristics;
    }

    public Integer getId_product() { return id_product; }

    public void setId_product(Integer id_product) { this.id_product = id_product; }

    public Integer getCategory_number() { return category_number; }

    public void setCategory_number(Integer category_number) { this.category_number = category_number; }

    public String getProduct_name() { return product_name; }

    public void setProduct_name(String product_name) { this.product_name = product_name; }

    public String getCharacteristics() { return characteristics; }

    public void setCharacteristics(String characteristics) { this.characteristics = characteristics; }

    @Override
    public String toString() {
        return "Product{" +
                "id_product=" + id_product +
                ", category_number=" + category_number +
                ", product_name='" + product_name + '\'' +
                ", characteristics='" + characteristics + '\'' +
                '}';
    }
}
