package com.naukma.supermarket.dao.interf;

import com.naukma.supermarket.model.Employee;

import java.util.List;

public interface EmployeeDAO extends CRUDDAO<Employee, String>{

    Employee getEmployeeBySurname(String surname);

    // Скласти список працівників, що займають посаду касира, відсортованих за прізвищем
    List<Employee> listCashiersBySurname();

    // За прізвищем працівника знайти його телефон та адресу
    Employee findEmployeeInfoBySurname(String surname);

}
