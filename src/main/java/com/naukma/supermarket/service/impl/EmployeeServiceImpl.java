package com.naukma.supermarket.service.impl;

import com.naukma.supermarket.dao.impl.EmployeeDAOImpl;
import com.naukma.supermarket.dao.interf.EmployeeDAO;
import com.naukma.supermarket.model.Employee;
import com.naukma.supermarket.service.interf.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void create(Employee employee) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.create(employee);
    }

    @Override
    public Employee findById(String id) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee = employeeDAO.findById(id);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        List<Employee> allEmployees = employeeDAO.findAll();
        return allEmployees;
    }

    @Override
    public void update(Employee employee) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.update(employee);

    }

    @Override
    public boolean delete(Employee employee) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        boolean result = employeeDAO.delete(employee);
        //System.out.println("Delete employee: " + result);
        return result;
    }

    @Override
    public Employee getRegisteredEmployee(String employeeSurname, String employeeName) {
        Employee registeredEmployee = null;

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        List<Employee> allEmployeesList = employeeDAO.findAll();

        for (Employee employee : allEmployeesList) {
            if (employee.getEmpl_surname().equals(employeeSurname) && employee.getEmpl_name().equals(employeeName)) {
                registeredEmployee = employee;
                break;
            }
        }
        return registeredEmployee;
    }

    @Override
    public Employee getEmployeeBySurname(String surname) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee = employeeDAO.getEmployeeBySurname(surname);
        return employee;
    }

    @Override
    public List<Employee> listCashiersBySurname() {
        return null;
    }
}
