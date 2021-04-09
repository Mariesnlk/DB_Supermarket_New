package com.naukma.supermarket.dao.interf;

import com.naukma.supermarket.model.Employee;

import java.util.List;

public interface EmployeeDAO extends CRUDDAO<Employee, String>{

    List<Employee> listCashiersBySurname();

    Employee getEmployeeInfoBySurname(String surname);

}
