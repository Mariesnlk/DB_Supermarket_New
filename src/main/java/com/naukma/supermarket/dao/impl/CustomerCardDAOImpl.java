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

            //
            String query = "INSERT INTO db_supermarket.product(product_name) VALUES(?)";

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

            //
            String query = "SELECT * FROM db_supermarket.product WHERE id_product = ?";
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
        return customer;
    }

    @Override
    public List<CustomerCard> findAll() {
        List<CustomerCard> customerList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            //
            String query = "SELECT * FROM db_supermarket.product";
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

            //
            String query =
                    "UPDATE db_supermarket.product SET product_name  = '" + //newProductName +
                            "' WHERE id_product = ?";

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

            //
            String query = "DELETE FROM db_supermarket.product WHERE id_product = ?";

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
}

