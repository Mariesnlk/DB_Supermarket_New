package com.naukma.supermarket;


import com.naukma.supermarket.dao.impl.CategoryDAOImpl;
import com.naukma.supermarket.dao.impl.CheckDAOImpl;
import com.naukma.supermarket.dao.impl.CustomerCardDAOImpl;
import com.naukma.supermarket.dao.impl.EmployeeDAOImpl;
import com.naukma.supermarket.dao.interf.CategoryDAO;
import com.naukma.supermarket.dao.interf.CheckDAO;
import com.naukma.supermarket.dao.interf.CustomerCardDAO;
import com.naukma.supermarket.dao.interf.EmployeeDAO;
import com.naukma.supermarket.model.Category;
import com.naukma.supermarket.model.Check;
import com.naukma.supermarket.model.CustomerCard;
import com.naukma.supermarket.model.Employee;

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

        CheckDAO customerCardDAO = new CheckDAOImpl();
        Check customerCard = new Check("3", "fghjk", "DFGHGFDF",
                new Date(2020-10-15), 22.0, 10.0);
        customerCardDAO.create(customerCard);


    }
}
