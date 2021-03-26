package com.naukma.supermarket.dao.impl;

import com.naukma.supermarket.dao.interf.ProductDAO;
import com.naukma.supermarket.database.DBHelper;
import com.naukma.supermarket.model.Product;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// new
public class ProductDAOImpl implements ProductDAO {

    private static final Logger LOG = Logger.getLogger(ProductDAOImpl.class);

    @Override
    public void create(Product product) {
        DBHelper dbHelper = new DBHelper();
        Connection connection = dbHelper.getConnection();

        PreparedStatement ps = null;

        try {
            Integer idProduct = product.getId_product();
            Integer categoryNum = product.getCategory_number();
            String productName = product.getProduct_name();
            String characterstcs = product.getCharacteristics();

            String query = "INSERT INTO db_supermarket.product(product_name) VALUES(?)";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setInt(1, idProduct);
            ps.setInt(2, categoryNum);
            ps.setString(3, productName);
            ps.setString(4, characterstcs);

            ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in ProductDaoImpl", e);
                    //System.out.println(e);
                }
            }
        }
    }

    @Override
    public Product findById(Integer idProduct) {

        Product product = null;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            String query = "SELECT * FROM db_supermarket.product WHERE id_product = ?";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setInt(1, idProduct);

            rs = ps.executeQuery();

            while (rs.next()) {

                Integer categoryNum = rs.getInt("category_number");
                String productName = rs.getString("product_name");
                String characterstcs = rs.getString("characteristics");

                product = new Product(idProduct, categoryNum, productName, characterstcs);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in ProductDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM db_supermarket.product";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            rs = ps.executeQuery();

            while (rs.next()) {
                Integer idProduct = rs.getInt("id_product");
                Integer categoryNum = rs.getInt("category_number");
                String productName = rs.getString("product_name");
                String characterstcs = rs.getString("characteristics");

                Product product = new Product(idProduct, categoryNum, productName, characterstcs);
                productList.add(product);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in ProductDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return productList;
    }

    @Override
    public void update(Product product) {
        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {

            Integer newIdProduct = product.getId_product();
            Integer newCategoryNum = product.getCategory_number();
            String newProductName = product.getProduct_name();
            String newCharacterstcs = product.getCharacteristics();

            String query =
                    "UPDATE db_supermarket.product SET product_name  = '" + newProductName +
                            "' WHERE id_product = ?";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setInt(1, newIdProduct);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in ProductDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean delete(Product product) {

        boolean result = false;
        int changedRowsNumber = 0;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {
            Integer id = product.getId_product();

            String query = "DELETE FROM db_supermarket.product WHERE id_product = ?";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setInt(1, id);

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
                    LOG.error("SQLException occurred in ProductDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return result;
    }
}

