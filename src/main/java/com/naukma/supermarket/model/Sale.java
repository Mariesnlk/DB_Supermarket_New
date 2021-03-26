package com.naukma.supermarket.model;

public class Sale {

    String UPC;
    String check_number;

    Integer product_number;
    Double selling_price;

    public Sale() { }

    public Sale(Integer product_number, Double selling_price) {
        this.product_number = product_number;
        this.selling_price = selling_price;
    }

    public Sale(String UPC, String check_number, Integer product_number, Double selling_price) {
        this.UPC = UPC;
        this.check_number = check_number;
        this.product_number = product_number;
        this.selling_price = selling_price;
    }

    public String getUPC() { return UPC; }

    public void setUPC(String UPC) { this.UPC = UPC; }

    public String getCheck_number() { return check_number; }

    public void setCheck_number(String check_number) { this.check_number = check_number; }

    public Integer getProduct_number() { return product_number; }

    public void setProduct_number(Integer product_number) { this.product_number = product_number; }

    public Double getSelling_price() { return selling_price; }

    public void setSelling_price(Double selling_price) { this.selling_price = selling_price; }

    @Override
    public String toString() {
        return "Sale{" +
                "UPC='" + UPC + '\'' +
                ", check_number='" + check_number + '\'' +
                ", product_number=" + product_number +
                ", selling_price=" + selling_price +
                '}';
    }
}
