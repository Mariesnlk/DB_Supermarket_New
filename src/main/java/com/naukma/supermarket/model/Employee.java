package com.naukma.supermarket.model;

import java.util.Date;

public class Employee {

    private String id_employee;
    private String empl_surname;
    private String empl_name;
    private String empl_patronymic;
    private String role;
    private double salary;
    private Date date_of_birth;
    private Date date_of_start;
    private String phone_number;
    private String city;
    private String street;
    private String zip_code;

    public Employee() { }

    public Employee(String empl_surname, String empl_name, String empl_patronymic, String role, double salary,
                    Date date_of_birth, Date date_of_start, String phone_number, String city, String street, String zip_code) {
        this.empl_surname = empl_surname;
        this.empl_name = empl_name;
        this.empl_patronymic = empl_patronymic;
        this.role = role;
        this.salary = salary;
        this.date_of_birth = date_of_birth;
        this.date_of_start = date_of_start;
        this.phone_number = phone_number;
        this.city = city;
        this.street = street;
        this.zip_code = zip_code;
    }

    public Employee(String id_employee, String empl_surname, String empl_name, String empl_patronymic, String role, double salary,
                    Date date_of_birth, Date date_of_start, String phone_number, String city, String street, String zip_code) {
        this.id_employee = id_employee;
        this.empl_surname = empl_surname;
        this.empl_name = empl_name;
        this.empl_patronymic = empl_patronymic;
        this.role = role;
        this.salary = salary;
        this.date_of_birth = date_of_birth;
        this.date_of_start = date_of_start;
        this.phone_number = phone_number;
        this.city = city;
        this.street = street;
        this.zip_code = zip_code;
    }

    public String getId_employee() {
        return id_employee;
    }

    public void setId_employee(String id_employee) {
        this.id_employee = id_employee;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Date getDate_of_start() {
        return date_of_start;
    }

    public void setDate_of_start(Date date_of_start) {
        this.date_of_start = date_of_start;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id_employee='" + id_employee + '\'' +
                ", empl_surname='" + empl_surname + '\'' +
                ", empl_name='" + empl_name + '\'' +
                ", empl_patronymic='" + empl_patronymic + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                ", date_of_birth=" + date_of_birth +
                ", date_of_start=" + date_of_start +
                ", phone_number='" + phone_number + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zip_code='" + zip_code + '\'' +
                '}';
    }
}
