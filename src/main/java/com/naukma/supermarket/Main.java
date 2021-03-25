package com.naukma.supermarket;


import com.naukma.supermarket.dao.impl.CategoryDAOImpl;
import com.naukma.supermarket.dao.impl.EmployeeDAOImpl;
import com.naukma.supermarket.dao.interf.CategoryDAO;
import com.naukma.supermarket.dao.interf.EmployeeDAO;
import com.naukma.supermarket.model.Category;
import com.naukma.supermarket.model.Employee;

import java.util.List;

public class Main {

    public static void main(String[] args) {

//        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//        Employee employee = new Employee("AB1", "Синельник", "Марія", "Сергіївна", "manager", 25000.0, null, null,
//               "066-440-48-06", "Київ", "вулиця", "02002" );
//        employeeDAO.create(employee);

        CategoryDAO categoryDAO = new CategoryDAOImpl();
//        Category category = new Category("fruits");
//        categoryDAO.create(category);

        List<Category> allCategories = categoryDAO.findAll();
        System.out.println("categories: " + allCategories);

//        UserDAO employeeDAO = new UserDAOImpl();
//        List<User> allUsers = employeeDAO.findAll();
//        System.out.println("users" + allUsers);


    }
}
