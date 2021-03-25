package com.naukma.supermarket.service.impl;

import com.naukma.supermarket.dao.impl.CategoryDAOImpl;
import com.naukma.supermarket.dao.interf.CategoryDAO;
import com.naukma.supermarket.model.Category;
import com.naukma.supermarket.service.interf.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Override
    public void create(Category category) {
        CategoryDAO categoryDAO = new CategoryDAOImpl();
        categoryDAO.create(category);

    }

    @Override
    public Category findById(Integer id) {
        CategoryDAO categoryDAO = new CategoryDAOImpl();
        Category category = categoryDAO.findById(id);
        return category;
    }

    @Override
    public List<Category> findAll() {
        CategoryDAO categoryDAO = new CategoryDAOImpl();
        List<Category> categories = categoryDAO.findAll();
        return categories;
    }

    @Override
    public void update(Category category) {
        CategoryDAO categoryDAO = new CategoryDAOImpl();
        categoryDAO.update(category);

    }

    @Override
    public boolean delete(Category category) {
        CategoryDAO categoryDAO = new CategoryDAOImpl();
        boolean result = categoryDAO.delete(category);
        //System.out.println("Delete user: " + result);
        return result;
    }
}
