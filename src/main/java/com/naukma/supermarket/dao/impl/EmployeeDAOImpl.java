package com.naukma.supermarket.dao.impl;

import com.naukma.supermarket.dao.interf.EmployeeDAO;
import com.naukma.supermarket.database.DBHelper;
import com.naukma.supermarket.model.Employee;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private static final Logger LOG = Logger.getLogger(EmployeeDAOImpl.class);

    @Override
    public void create(Employee employee) {
        DBHelper dbHelper = new DBHelper();
        Connection connection = dbHelper.getConnection();

        PreparedStatement ps = null;

        try {
            String idEmployee = employee.getId_employee();
            String surname = employee.getEmpl_surname();
            String name = employee.getEmpl_name();
            String patronymic = employee.getEmpl_patronymic();
            String role = employee.getRole();
            double salary = employee.getSalary();
            Date dateOfBirth = (Date) employee.getDate_of_birth();
            Date dateOfStart = (Date) employee.getDate_of_start();
            String phoneNumber = employee.getPhone_number();
            String city = employee.getCity();
            String street = employee.getStreet();
            String zipCode = employee.getZip_code();

            String query = "INSERT INTO db_supermarket.employee(id_employee, empl_surname, empl_name, empl_patronymic," +
                    " role,salary, date_of_birth, date_of_start, phone_number, city, street, zip_code) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, idEmployee);
            ps.setString(2, surname);
            ps.setString(3, name);
            ps.setString(4, patronymic);
            ps.setString(5, role);
            ps.setDouble(6, salary);
            ps.setDate(7, dateOfBirth);
            ps.setDate(8, dateOfStart);
            ps.setString(9, phoneNumber);
            ps.setString(10, city);
            ps.setString(11, street);
            ps.setString(12, zipCode);

            ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in OrderDaoImpl", e);
                    //System.out.println(e);
                }
            }
        }
    }

    @Override
    public Employee findById(String idEmployee) {

        Employee employee = null;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            String query = "SELECT * FROM employee WHERE id_employee = ?";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, String.valueOf(idEmployee));

            rs = ps.executeQuery();

            while (rs.next()) {

                String surname = rs.getString("empl_surname");
                String name = rs.getString("empl_name");
                String patronymic = rs.getString("empl_patronymic");
                String role = rs.getString("role");
                double salary = rs.getDouble("salary");
                Date dateBirth = rs.getDate("date_of_birth");
                Date dateStart = rs.getDate("date_of_start");
                String phoneNumber = rs.getString("phone_number");
                String city = rs.getString("city");
                String street = rs.getString("street");
                String zipCode = rs.getString("zip_code");

                employee = new Employee(idEmployee, surname, name, patronymic, role, salary, dateBirth, dateStart,
                        phoneNumber, city, street, zipCode);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in OrderDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM employee";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            rs = ps.executeQuery();

            while (rs.next()) {
                String idEmployee = rs.getString("id_employee");
                String surname = rs.getString("empl_surname");
                String name = rs.getString("empl_name");
                String patronymic = rs.getString("empl_patronymic");
                String role = rs.getString("role");
                double salary = rs.getDouble("salary");
                Date dateBirth = rs.getDate("date_of_birth");
                Date dateStart = rs.getDate("date_of_start");
                String phoneNumber = rs.getString("phone_number");
                String city = rs.getString("city");
                String street = rs.getString("street");
                String zipCode = rs.getString("zip_code");

                Employee employee = new Employee(idEmployee, surname, name, patronymic, role, salary, dateBirth,
                        dateStart, phoneNumber, city, street, zipCode);
                employeeList.add(employee);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in OrderDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return employeeList;
    }

    @Override
    public void update(Employee employee) {
        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {

            String newIdEmployee = employee.getId_employee();
            String newSurname = employee.getEmpl_surname();
            String newName = employee.getEmpl_name();
            String newPatronymic = employee.getEmpl_patronymic();
            String newRole = employee.getRole();
            double newSalary = employee.getSalary();
            Date newDateOfBirth = (Date) employee.getDate_of_birth();
            Date newDateOfStart = (Date) employee.getDate_of_start();
            String newPhoneNumber = employee.getPhone_number();
            String newCity = employee.getCity();
            String newStreet = employee.getStreet();
            String newZipCode = employee.getZip_code();

            String query =
                    "UPDATE employee SET empl_surname  = '" + newSurname + "', empl_name = '" + newName + "', " +
                            "empl_patronymic = '" + newPatronymic + "', " + "role = '" + newRole +
                            "'," + "salary = '" + newSalary + "', " + "date_of_birth = '" + newDateOfBirth +
                            "'," + "date_of_start = '" + newDateOfStart + "', " + "phone_number = '" + newPhoneNumber +
                            "'," + "city = '" + newCity + "', " + "street = '" + newStreet +
                            "'," + "zip_code = '" + newZipCode +
                            "' WHERE id_employee = ?";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, newIdEmployee);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in OrderDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean delete(Employee employee) {

        boolean result = false;
        int changedRowsNumber = 0;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {
            String idEmployee = employee.getId_employee();

            String query = "DELETE FROM employee WHERE id_employee = ?";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, idEmployee);

            //System.out.println(ps);
            changedRowsNumber = ps.executeUpdate();
            System.out.println("changedRowsNumber=" + changedRowsNumber);
            if (changedRowsNumber > 0) {
                result = true;
            }

        } catch (Exception e) {
            System.out.println(e);
            result = false;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in OrderDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return result;
    }
}
