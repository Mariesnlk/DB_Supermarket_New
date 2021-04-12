package com.naukma.supermarket.model;

public class ProductSellingCheck {

    private String product_name;
    private Integer product_number;
    private Double selling_price;
    private String check_number;
    private String id_employee;

    public ProductSellingCheck() {
    }

    public ProductSellingCheck(String product_name, Integer product_number, Double selling_price) {
        this.product_name = product_name;
        this.product_number = product_number;
        this.selling_price = selling_price;
    }

    public ProductSellingCheck(String product_name, Double selling_price) {
        this.product_name = product_name;
        this.selling_price = selling_price;
    }

    public ProductSellingCheck(String product_name, Integer product_number, Double selling_price,
                               String check_number) {
        this.product_name = product_name;
        this.product_number = product_number;
        this.selling_price = selling_price;
        this.check_number = check_number;
    }

    public ProductSellingCheck(String product_name, Integer product_number, Double selling_price,
                               String check_number, String id_employee) {
        this.product_name = product_name;
        this.product_number = product_number;
        this.selling_price = selling_price;
        this.check_number = check_number;
        this.id_employee = id_employee;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getProduct_number() {
        return product_number;
    }

    public void setProduct_number(Integer product_number) {
        this.product_number = product_number;
    }

    public Double getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(Double selling_price) {
        this.selling_price = selling_price;
    }

    public String getCheck_number() {
        return check_number;
    }

    public void setCheck_number(String check_number) {
        this.check_number = check_number;
    }

    public String getId_employee() {
        return id_employee;
    }

    public void setId_employee(String id_employee) {
        this.id_employee = id_employee;
    }

    @Override
    public String toString() {
        return "ProductSellingCheck{" +
                "product_name='" + product_name + '\'' +
                ", product_number=" + product_number +
                ", selling_price=" + selling_price +
                ", check_number='" + check_number + '\'' +
                ", id_employee='" + id_employee + '\'' +
                '}';
    }
}
