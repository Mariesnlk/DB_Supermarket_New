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

public class ProductDAOImpl implements ProductDAO {

    private static final Logger LOG = Logger.getLogger(ProductDAOImpl.class);

    @Override
    public void create(Product product) {
        DBHelper dbHelper = new DBHelper();
        Connection connection = dbHelper.getConnection();

        PreparedStatement ps = null;

        try {
//            Integer idProduct = product.getId_product();
            Integer categoryNum = product.getCategory_number();
            String productName = product.getProduct_name();
            String characterstcs = product.getCharacteristics();

            String query = "INSERT INTO db_supermarket.product(category_number, product_name, characteristics) VALUES(?, ?, ?)";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

//            ps.setInt(1, idProduct);
            ps.setInt(1, categoryNum);
            ps.setString(2, productName);
            ps.setString(3, characterstcs);

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
                    "UPDATE db_supermarket.product SET category_number  = '" + newCategoryNum + "', product_name = '" +
                            newProductName + "', " + "characteristics = '" + newCharacterstcs +
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

    @Override
    public List<Product> allProductsSortedByName() {

        List<Product> productsList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM db_supermarket.product ORDER BY product_name";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            rs = ps.executeQuery();

            while (rs.next()) {

                Integer idProduct = rs.getInt("id_product");
                Integer categoryNum = rs.getInt("category_number");
                String productName = rs.getString("product_name");
                String characterstcs = rs.getString("characteristics");

                Product product = new Product(idProduct, categoryNum, productName, characterstcs);
                productsList.add(product);
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
        return productsList;
    }

    @Override
    public List<Product> productByCategory(String nameCategory) {
        List<Product> productList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM db_supermarket.product prod JOIN db_supermarket.category categ  ON " +
                    " prod.category_number = categ.category_number  WHERE categ.category_name = ?";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, String.valueOf(nameCategory));

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
    public List<Product> productByCategoryOrdered(String nameCategory) {
        List<Product> productList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM db_supermarket.product WHERE category_number IN " +
                    "(SELECT  category_number  FROM  db_supermarket.category WHERE category_name = ?) " +
                    "ORDER BY product_name";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, String.valueOf(nameCategory));

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
    public List<Product> promProductsSortedByQuantity() {
        List<Product> productList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT product_name " +
                    "FROM db_supermarket.product P " +
                    "INNER JOIN db_supermarket.store_product ST " +
                    "ON P.id_product=ST.id_product " +
                    "WHERE promotional_product = 1 " +
                    "ORDER BY products_number";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            rs = ps.executeQuery();

            while (rs.next()) {
                String productName = rs.getString("product_name");

                Product product = new Product(productName);
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
    public List<Product> nonPromProductsSortedByQuantity() {
        List<Product> productList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT product_name " +
                    "FROM db_supermarket.product P " +
                    "INNER JOIN db_supermarket.store_product ST " +
                    "ON P.id_product=ST.id_product " +
                    "WHERE promotional_product = 0 " +
                    "ORDER BY products_number";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            rs = ps.executeQuery();

            while (rs.next()) {
                String productName = rs.getString("product_name");

                Product product = new Product(productName);
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
    public List<Product> promProductsSortedByName() {
        List<Product> productList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT product_name FROM db_supermarket.product " +
                    "WHERE id_product IN (SELECT id_product " +
                    "FROM db_supermarket.store_product " +
                    "WHERE promotional_product = 1) " +
                    "ORDER BY product_name";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            rs = ps.executeQuery();

            while (rs.next()) {
                String productName = rs.getString("product_name");

                Product product = new Product(productName);
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
    public List<Product> nonPromProductsSortedByName() {
        List<Product> productList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT product_name FROM db_supermarket.product " +
                    "WHERE id_product IN (SELECT id_product " +
                    "FROM db_supermarket.store_product " +
                    "WHERE promotional_product = 0) " +
                    "ORDER BY product_name";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            rs = ps.executeQuery();

            while (rs.next()) {
                String productName = rs.getString("product_name");

                Product product = new Product(productName);
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
    public List<Product> allProductsInCheckByCheckNum(String checkNumber) {
        List<Product> productList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT product_name " +
                    "FROM db_supermarket.product " +
                    "WHERE id_product IN (SELECT id_product " +
                    "FROM db_supermarket.store_product " +
                    "WHERE UPC IN (SELECT UPC " +
                    "  FROM db_supermarket.sale " +
                    "  WHERE check_number IN (SELECT check_number " +
                    "         FROM db_supermarket.check " +
                    "         WHERE check_number = ?)))";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, String.valueOf(checkNumber));

            rs = ps.executeQuery();

            while (rs.next()) {
                String productName = rs.getString("product_name");

                Product product = new Product(productName);
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
}

