package com.naukma.supermarket.dao.impl;

import com.naukma.supermarket.dao.interf.CategoryDAO;
import com.naukma.supermarket.database.DBHelper;
import com.naukma.supermarket.model.Category;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {

    private static final Logger LOG = Logger.getLogger(CategoryDAOImpl.class);

    @Override
    public void create(Category category) {
        DBHelper dbHelper = new DBHelper();
        Connection connection = dbHelper.getConnection();

        PreparedStatement ps = null;

        try {
            String categoryName = category.getCategory_name();

            String query = "INSERT INTO db_supermarket.category(category_name) VALUES(?)";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, categoryName);

            ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in CategoryDaoImpl", e);
                    //System.out.println(e);
                }
            }
        }
    }

    @Override
    public Category findById(Integer id) {

        Category category = null;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            String query = "SELECT * FROM db_supermarket.category WHERE category_number = ?";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, String.valueOf(id));

            rs = ps.executeQuery();

            while (rs.next()) {

                String categoryName = rs.getString("category_name");

                category = new Category(id, categoryName);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in CategoryDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return category;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM db_supermarket.category";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            rs = ps.executeQuery();

            while (rs.next()) {
                Integer idCategory = rs.getInt("category_number");
                String categoryName = rs.getString("category_name");

                Category category = new Category(idCategory, categoryName);
                categoryList.add(category);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in CategoryDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return categoryList;
    }

    @Override
    public void update(Category category) {
        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {

            Integer newIdCategory = category.getCategory_number();
            String newCategoryName = category.getCategory_name();
            ;

            String query =
                    "UPDATE db_supermarket.category SET category_name  = '" + newCategoryName +
                            "' WHERE category_number = ?";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setInt(1, newIdCategory);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in CategoryDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean delete(Category category) {

        boolean result = false;
        int changedRowsNumber = 0;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {
            Integer id = category.getCategory_number();

            String query = "DELETE FROM db_supermarket.category WHERE category_number = ?";
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
                    LOG.error("SQLException occurred in CategoryDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public List<Category> categoriesSortedByName() {
        List<Category> categoryList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM db_supermarket.category ORDER BY category_name";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            rs = ps.executeQuery();

            while (rs.next()) {
                Integer idCategory = rs.getInt("category_number");
                String categoryName = rs.getString("category_name");

                Category category = new Category(idCategory, categoryName);
                categoryList.add(category);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in CategoryDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return categoryList;
    }
}
