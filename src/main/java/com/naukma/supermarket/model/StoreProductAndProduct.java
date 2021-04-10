package com.naukma.supermarket.model;

public class StoreProductAndProduct {

    private Double selling_price;
    private Integer products_number;
    private String product_name;
    private String characteristics;

    public StoreProductAndProduct() {}

    public StoreProductAndProduct(Double selling_price, Integer products_number, String product_name, String characteristics) {
        this.selling_price = selling_price;
        this.products_number = products_number;
        this.product_name = product_name;
        this.characteristics = characteristics;
    }

    public Double getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(Double selling_price) {
        this.selling_price = selling_price;
    }

    public Integer getProducts_number() {
        return products_number;
    }

    public void setProducts_number(Integer products_number) {
        this.products_number = products_number;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    @Override
    public String toString() {
        return "StoreProductAndStore{" +
                "selling_price=" + selling_price +
                ", products_number=" + products_number +
                ", product_name='" + product_name + '\'' +
                ", characteristics='" + characteristics + '\'' +
                '}';
    }
}
