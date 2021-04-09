package com.naukma.supermarket.dao.interf;

import com.naukma.supermarket.model.Category;

import java.util.List;

public interface CategoryDAO extends CRUDDAO<Category, Integer> {

    List<Category> categoriesSortedByName();

}
