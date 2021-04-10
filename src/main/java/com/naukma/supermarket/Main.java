package com.naukma.supermarket;

import com.naukma.supermarket.dao.impl.*;
import com.naukma.supermarket.dao.interf.*;
import com.naukma.supermarket.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.sql.Date;

public class Main {

    public static void main(String[] args) {

        // Скласти список усіх категорій, відсортованих за назвою
//        CategoryDAO categoryDAO = new CategoryDAOImpl();
//        List<Category> categoryList = categoryDAO.
//        System.out.println("allProductsSortedByName: " + categoryList);

        // Скласти список працівників, що займають посаду касира, відсортованих за прізвищем
//        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//        List<Employee> employeeList = employeeDAO.
//        System.out.println("allProductsSortedByName: " + employeeList);

        // За прізвищем працівника знайти його телефон та адресу
//        Employee employee = employeeDAO.
//        System.out.println("customerWithSurname " + employee);

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

        //За номером касира вивести інформацію про всіх покупців, яким він друкував чеки
        List<CustomerCard> MyCustomerCardList = customerCardDAO.customerWithCashierCheck("2");
        System.out.println("За номером касира вивести інформацію про всіх покупців, яким він друкував чеки " + MyCustomerCardList);

        //За прізвищем працівника знайти його телефон та адресу
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee = employeeDAO.getEmployeeInfoBySurname("Synelnyk");
        System.out.println("За прізвищем працівника знайти його телефон та адресу " + employee);

        //not work
        CheckDAO checkDAO = new CheckDAOImpl();
        System.out.println(1);
        java.util.Date dateFirst=null;
        java.util.Date dateSecond=null;

        try {
            dateFirst = parseDate("2021-03-02", "yyyy-MM-dd");
            dateSecond = parseDate("2021-03-09", "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Check check = checkDAO.totalSumOfChecks("2", new Date(dateFirst.getTime()), new Date(dateSecond.getTime()));
        System.out.println("Загальна сума проданих товарів з чеків, видрукуваних певним касиром за певний період часу " + check);



//        Check check1 = checkDAO.totalSumOfChecksAllEmployees(new Date(2021 - 3 - 2), new Date(2021 - 3 - 9));
//        System.out.println(2);
//        System.out.println("Загальна сума проданих товарів з чеків, видрукуваних усіма касиром за певний період часу " + check1);
//        System.out.println(3);

//        //Скласти список всіх товарів, що належать певній категорії
//        List<Product> product = productDAO.productByCategory("fruits");
//        System.out.println("Скласти список всіх товарів, що належать певній категорії " + product);
//
//        //Скласти список товарів, що належать певній категорії, відсортованих за назвою
//        List<Product> productOrdered = productDAO.productByCategoryOrdered("fruits");
//        System.out.println("Скласти список товарів, що належать певній категорії, відсортованих за назвою " + productOrdered);



    }


    //для парсинга даты
    private static java.util.Date parseDate(String date, String format) throws ParseException
    {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.parse(date);
    }
}
