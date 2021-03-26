package com.naukma.supermarket.model;

import java.util.Date;

public class Check {

    String check_number;
    String id_employee;
    String card_number;
    Date print_date;
    Double sum_total;
    Double vat;

    public Check() { }

    public Check(String id_employee, String card_number, Date print_date, Double sum_total, Double vat) {
        this.id_employee = id_employee;
        this.card_number = card_number;
        this.print_date = print_date;
        this.sum_total = sum_total;
        this.vat = vat;
    }

    public Check(String check_number, String id_employee, String card_number, Date print_date, Double sum_total, Double vat) {
        this.check_number = check_number;
        this.id_employee = id_employee;
        this.card_number = card_number;
        this.print_date = print_date;
        this.sum_total = sum_total;
        this.vat = vat;
    }

    public String getCheck_number() { return check_number; }

    public void setCheck_number(String check_number) { this.check_number = check_number; }

    public String getId_employee() { return id_employee; }

    public void setId_employee(String id_employee) { this.id_employee = id_employee; }

    public String getCard_number() { return card_number; }

    public void setCard_number(String card_number) { this.card_number = card_number; }

    public Date getPrint_date() { return print_date; }

    public void setPrint_date(Date print_date) { this.print_date = print_date; }

    public Double getSum_total() { return sum_total; }

    public void setSum_total(Double sum_total) { this.sum_total = sum_total; }

    public Double getVat() { return vat; }

    public void setVat(Double vat) { this.vat = vat; }

    @Override
    public String toString() {
        return "Check{" +
                "check_number='" + check_number + '\'' +
                ", id_employee='" + id_employee + '\'' +
                ", card_number='" + card_number + '\'' +
                ", print_date=" + print_date +
                ", sum_total=" + sum_total +
                ", vat=" + vat +
                '}';
    }
}
