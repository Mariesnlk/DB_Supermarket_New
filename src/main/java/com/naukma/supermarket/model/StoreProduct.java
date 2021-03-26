package com.naukma.supermarket.model;

public class StoreProduct {

    String UPC;
    String UPC_prom;
    Integer id_product;
    Double selling_price;
    Integer products_number;
    Boolean promotional_product;

    public StoreProduct() { }

    public StoreProduct(String UPC_prom, Integer id_product, Double selling_price, Integer products_number, Boolean promotional_product) {
        this.UPC_prom = UPC_prom;
        this.id_product = id_product;
        this.selling_price = selling_price;
        this.products_number = products_number;
        this.promotional_product = promotional_product;
    }

    public StoreProduct(String UPC, String UPC_prom, Integer id_product, Double selling_price, Integer products_number, Boolean promotional_product) {
        this.UPC = UPC;
        this.UPC_prom = UPC_prom;
        this.id_product = id_product;
        this.selling_price = selling_price;
        this.products_number = products_number;
        this.promotional_product = promotional_product;
    }

    public String getUPC() { return UPC; }

    public void setUPC(String UPC) { this.UPC = UPC; }

    public String getUPC_prom() { return UPC_prom; }

    public void setUPC_prom(String UPC_prom) { this.UPC_prom = UPC_prom; }

    public Integer getId_product() { return id_product; }

    public void setId_product(Integer id_product) { this.id_product = id_product; }

    public Double getSelling_price() { return selling_price; }

    public void setSelling_price(Double selling_price) { this.selling_price = selling_price; }

    public Integer getProducts_number() { return products_number; }

    public void setProducts_number(Integer products_number) { this.products_number = products_number; }

    public Boolean getPromotional_product() { return promotional_product; }

    public void setPromotional_product(Boolean promotional_product) { this.promotional_product = promotional_product; }

    @Override
    public String toString() {
        return "StoreProduct{" +
                "UPC='" + UPC + '\'' +
                ", UPC_prom='" + UPC_prom + '\'' +
                ", id_product=" + id_product +
                ", selling_price=" + selling_price +
                ", products_number=" + products_number +
                ", promotional_product=" + promotional_product +
                '}';
    }
}
