package com.naukma.supermarket;


import com.naukma.supermarket.dao.impl.*;
import com.naukma.supermarket.dao.interf.*;
import com.naukma.supermarket.model.*;

import java.util.List;
import java.sql.Date;

public class Main {

    public static void main(String[] args) {

//        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//        Employee employee = new Employee("AB1", "Синельник", "Марія", "Сергіївна", "manager", 25000.0, null, null,
//               "066-440-48-06", "Київ", "вулиця", "02002" );
//        employeeDAO.create(employee);

//        CategoryDAO categoryDAO = new CategoryDAOImpl();
//        List<Category> allCategories = categoryDAO.findAll();
//        System.out.println("categories: " + allCategories);
//
//        CheckDAO customerCardDAO = new CheckDAOImpl();
//        Check customerCard = new Check("3", "fghjk", "DFGHGFDF",
//                new Date(2020-10-15), 22.0, 10.0);
//        customerCardDAO.create(customerCard);

//        StoreProductDAO storeProductDAO = new StoreProductDAOImpl();
//        StoreProduct storeProduct = new StoreProduct("1", "1", 1, 29.99, 50, false);
//        storeProductDAO.update(storeProduct);

//        CheckDAO checkDAO = new CheckDAOImpl();
//        Check check = new Check("1", "1", "1",  new Date(2020-10-15),
//                33.4, 0.2);
//        checkDAO.update(check);

        // ----

        // За UPC-товару знайти ціну продажу товару, кількість наявних одиниць товару
        StoreProductDAO storeProductDAO = new StoreProductDAOImpl();
        StoreProduct storeProduct = storeProductDAO.findSomethingByUpc("1");
        System.out.println("UPC 1 " + storeProduct);

        // Список усіх постійних клієнтів, що мають карту клієнта з певним відсотком
        CustomerCardDAO customerCardDAO = new CustomerCardDAOImpl();
        List<CustomerCard> customerCardList = customerCardDAO.customerWithPercent(10);
        System.out.println("find by percent " + customerCardList);

        // Вивести усю інформацію про покупця з певним прізвищем, що має карту клієнта
        CustomerCard customerCardList2 = customerCardDAO.customerWithSurname("Danish");
        System.out.println("customerWithSurname " + customerCardList2);

        // Скласти список усіх товарів, відсортований за назвою
        ProductDAO productDAO = new ProductDAOImpl();
        List<Product> productsList = productDAO.allProductsSortedByName();
        System.out.println("allProductsSortedByName: " + productsList);


    }
}
