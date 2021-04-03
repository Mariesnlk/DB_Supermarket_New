package com.naukma.supermarket.dao.interf;

import com.naukma.supermarket.model.Employee;

public interface EmployeeDAO extends CRUDDAO<Employee, String>{

    Employee getEmployeeBySurname(String surname);

}
