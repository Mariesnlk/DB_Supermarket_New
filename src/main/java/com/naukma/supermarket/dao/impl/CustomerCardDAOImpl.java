package com.naukma.supermarket.dao.impl;

import com.naukma.supermarket.dao.interf.CustomerCardDAO;
import com.naukma.supermarket.database.DBHelper;
import com.naukma.supermarket.model.CustomerCard;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerCardDAOImpl implements CustomerCardDAO {

    private static final Logger LOG = Logger.getLogger(CustomerCardDAOImpl.class);

    @Override
    public void create(CustomerCard customer) {
        DBHelper dbHelper = new DBHelper();
        Connection connection = dbHelper.getConnection();

        PreparedStatement ps = null;

        try {

            String cardNumber = customer.getCard_number();
            String custSurname = customer.getCust_surname();
            String custName = customer.getCust_name();
            String custPatronymic = customer.getCust_patronymic();
            String phoneNumber = customer.getPhone_number();
            String city = customer.getCity();
            String street = customer.getStreet();
            String zipCode = customer.getZip_code();
            Integer percent = customer.getPercent();

            String query = "INSERT INTO db_supermarket.customer_card(card_number, cust_surname, cust_name, cust_patronymic," +
                    "phone_number, city, street, zip_code, percent) VALUES(?,?,?,?,?,?,?,?,?)";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, cardNumber);
            ps.setString(2, custSurname);
            ps.setString(3, custName);
            ps.setString(4, custPatronymic);
            ps.setString(5, phoneNumber);
            ps.setString(6, city);
            ps.setString(7, street);
            ps.setString(8, zipCode);
            ps.setInt(9, percent);

            ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in CustomerCardDaoImpl", e);
                    //System.out.println(e);
                }
            }
        }
    }

    @Override
    public CustomerCard findById(String cardNumber) {

        CustomerCard customer = null;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            String query = "SELECT * FROM db_supermarket.customer_card WHERE card_number = ?";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, cardNumber);

            rs = ps.executeQuery();

            while (rs.next()) {

                String custSurname = rs.getString("cust_surname");
                String custName = rs.getString("cust_name");
                String custPatronymic = rs.getString("cust_patronymic");
                String phoneNumber = rs.getString("phone_number");
                String city = rs.getString("city");
                String street = rs.getString("street");
                String zipCode = rs.getString("zip_code");
                Integer percent = rs.getInt("percent");

                customer = new CustomerCard(cardNumber, custSurname, custName, custPatronymic,
                        phoneNumber, city, street, zipCode, percent);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in CustomerCardDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return
                customer;
    }

    @Override
    public List<CustomerCard> findAll() {
        List<CustomerCard> customerList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM db_supermarket.customer_card";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            rs = ps.executeQuery();

            while (rs.next()) {

                String cardNumber = rs.getString("card_number");
                String custSurname = rs.getString("cust_surname");
                String custName = rs.getString("cust_name");
                String custPatronymic = rs.getString("cust_patronymic");
                String phoneNumber = rs.getString("phone_number");
                String city = rs.getString("city");
                String street = rs.getString("street");
                String zipCode = rs.getString("zip_code");
                Integer percent = rs.getInt("percent");

                CustomerCard customer = new CustomerCard(cardNumber, custSurname, custName,
                        custPatronymic, phoneNumber, city, street, zipCode, percent);
                customerList.add(customer);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in CustomerCardDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return customerList;
    }

    @Override
    public void update(CustomerCard customer) {
        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {

            String newCardNumber = customer.getCard_number();
            String newCustSurname = customer.getCust_surname();
            String newCustName = customer.getCust_name();
            String newCustPatronymic = customer.getCust_patronymic();
            String newPhoneNumber = customer.getPhone_number();
            String newCity = customer.getCity();
            String newStreet = customer.getStreet();
            String newZipCode = customer.getZip_code();
            Integer newPercent = customer.getPercent();

            String query =
                    "UPDATE db_supermarket.customer_card SET cust_surname  = '" + newCustSurname + "', cust_name = '" + newCustName +
                            "', " + "cust_patronymic = '" + newCustPatronymic + "', " + "phone_number = '" + newPhoneNumber +
                            "', " + "city = '" + newCity + "', " + "street = '" + newStreet + "', " + "zip_code = '" + newZipCode +
                            "', " + "percent = '" + newPercent + "' WHERE card_number = ?";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, newCardNumber);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in CustomerCardDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean delete(CustomerCard customer) {

        boolean result = false;
        int changedRowsNumber = 0;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {
            String cardNumber = customer.getCard_number();

            String query = "DELETE FROM db_supermarket.customer_card WHERE card_number = ?";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, cardNumber);

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
                    LOG.error("SQLException occurred in CustomerCardDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public List<CustomerCard> customerWithPercent(Integer percent) {
        List<CustomerCard> customerList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = " SELECT * FROM db_supermarket.customer_card WHERE percent = ?";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, String.valueOf(percent));

            rs = ps.executeQuery();

            while (rs.next()) {

                String cardNumber = rs.getString("card_number");
                String custSurname = rs.getString("cust_surname");
                String custName = rs.getString("cust_name");
                String custPatronymic = rs.getString("cust_patronymic");
                String phoneNumber = rs.getString("phone_number");
                String city = rs.getString("city");
                String street = rs.getString("street");
                String zipCode = rs.getString("zip_code");

                CustomerCard customer = new CustomerCard(cardNumber, custSurname, custName,
                        custPatronymic, phoneNumber, city, street, zipCode, percent);
                customerList.add(customer);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in CustomerCardDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return customerList;
    }

    @Override
    public List<CustomerCard> customerWithCashierCheck(String idEmployee) {
        List<CustomerCard> customerList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT * \n" +
                    "FROM  db_supermarket.customer_card \n" +
                    "WHERE card_number IN ( SELECT card_number \n" +
                    "   FROM db_supermarket.check \n" +
                    "   WHERE id_employee  IN ( SELECT id_employee\n" +
                    "       FROM db_supermarket.employee \n" +
                    "       WHERE role = 'cashier' AND  id_employee = ?))\n";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, idEmployee);

            rs = ps.executeQuery();

            while (rs.next()) {

                String cardNumber = rs.getString("card_number");
                String custSurname = rs.getString("cust_surname");
                String custName = rs.getString("cust_name");
                String custPatronymic = rs.getString("cust_patronymic");
                String phoneNumber = rs.getString("phone_number");
                String city = rs.getString("city");
                String street = rs.getString("street");
                String zipCode = rs.getString("zip_code");
                Integer percent = rs.getInt("percent");

                CustomerCard customer = new CustomerCard(cardNumber, custSurname, custName,
                        custPatronymic, phoneNumber, city, street, zipCode, percent);
                customerList.add(customer);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in CustomerCardDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return customerList;
    }

    @Override
    public List<CustomerCard> listAllCustomers() {
        List<CustomerCard> customerList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT cust_surname, cust_name, cust_patronymic, " +
                    "phone_number, city, street, zip_code " +
                    "FROM db_supermarket.customer_card ";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            rs = ps.executeQuery();

            while (rs.next()) {

                String custSurname = rs.getString("cust_surname");
                String custName = rs.getString("cust_name");
                String custPatronymic = rs.getString("cust_patronymic");
                String phoneNumber = rs.getString("phone_number");
                String city = rs.getString("city");
                String street = rs.getString("street");
                String zipCode = rs.getString("zip_code");

                CustomerCard customer = new CustomerCard(custSurname, custName,
                        custPatronymic, phoneNumber, city, street, zipCode);
                customerList.add(customer);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in CustomerCardDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return customerList;
    }

    @Override
    public CustomerCard customerWithSurname(String surname) {
        CustomerCard customer = null;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            String query = "SELECT * FROM db_supermarket.customer_card WHERE cust_surname = ?";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, surname);

            rs = ps.executeQuery();

            while (rs.next()) {

                String cardNumber = rs.getString("card_number");
                String custName = rs.getString("cust_name");
                String custPatronymic = rs.getString("cust_patronymic");
                String phoneNumber = rs.getString("phone_number");
                String city = rs.getString("city");
                String street = rs.getString("street");
                String zipCode = rs.getString("zip_code");
                Integer percent = rs.getInt("percent");

                customer = new CustomerCard(cardNumber, surname, custName, custPatronymic,
                        phoneNumber, city, street, zipCode, percent);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in CustomerCardDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return customer;
    }
}