package com.naukma.supermarket.service.interf;

import com.naukma.supermarket.model.Employee;

public interface EmployeeService  extends CRUDService<Employee, String> {

    Employee getRegisteredEmployee(String employeeSurname, String employeeName);

}

