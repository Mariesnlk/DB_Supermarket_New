package com.naukma.supermarket.service.interf;

import com.naukma.supermarket.model.Employee;

import java.util.List;

public interface EmployeeService  extends CRUDService<Employee, String> {

    Employee getRegisteredEmployee(String login, String password);

    List<Employee> listCashiersBySurname();

    Employee getEmployeeBySurname(String surname);

}

