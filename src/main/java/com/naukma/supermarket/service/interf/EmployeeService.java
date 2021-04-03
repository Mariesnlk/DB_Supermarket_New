package com.naukma.supermarket.service.interf;

import com.naukma.supermarket.model.Employee;

import java.util.List;

public interface EmployeeService  extends CRUDService<Employee, String> {

    Employee getRegisteredEmployee(String employeeSurname, String employeeName);

    List<Employee> listCashiersBySurname();

    Employee findEmployeeInfoBySurname(String surname);

}

