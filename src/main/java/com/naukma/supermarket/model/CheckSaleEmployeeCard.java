package com.naukma.supermarket.model;

import java.util.Date;

public class CheckSaleEmployeeCard {

    private Integer product_number;
    private Double selling_price;
    private String check_number;
    private Date print_date;
    private Double vat;
    private String empl_surname;
    private String empl_name;
    private String empl_patronymic;

    public CheckSaleEmployeeCard(Integer product_number, Double selling_price, String check_number, Date print_date,
                                 Double vat, String empl_surname, String empl_name, String empl_patronymic) {
        this.product_number = product_number;
        this.selling_price = selling_price;
        this.check_number = check_number;
        this.print_date = print_date;
        this.vat = vat;
        this.empl_surname = empl_surname;
        this.empl_name = empl_name;
        this.empl_patronymic = empl_patronymic;
    }

    public CheckSaleEmployeeCard(Double selling_price, String check_number, Date print_date,
                                 Double vat, String empl_surname, String empl_name, String empl_patronymic) {
        this.selling_price = selling_price;
        this.check_number = check_number;
        this.print_date = print_date;
        this.vat = vat;
        this.empl_surname = empl_surname;
        this.empl_name = empl_name;
        this.empl_patronymic = empl_patronymic;
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

    public Date getPrint_date() {
        return print_date;
    }

    public void setPrint_date(Date print_date) {
        this.print_date = print_date;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public String getEmpl_surname() {
        return empl_surname;
    }

    public void setEmpl_surname(String empl_surname) {
        this.empl_surname = empl_surname;
    }

    public String getEmpl_name() {
        return empl_name;
    }

    public void setEmpl_name(String empl_name) {
        this.empl_name = empl_name;
    }

    public String getEmpl_patronymic() {
        return empl_patronymic;
    }

    public void setEmpl_patronymic(String empl_patronymic) {
        this.empl_patronymic = empl_patronymic;
    }

    @Override
    public String toString() {
        return "CheckSaleEmployeeCard{" +
                "product_number=" + product_number +
                ", selling_price=" + selling_price +
                ", check_number='" + check_number + '\'' +
                ", print_date=" + print_date +
                ", vat=" + vat +
                ", empl_surname='" + empl_surname + '\'' +
                ", empl_name='" + empl_name + '\'' +
                ", empl_patronymic='" + empl_patronymic + '\'' +
                '}';
    }
}
