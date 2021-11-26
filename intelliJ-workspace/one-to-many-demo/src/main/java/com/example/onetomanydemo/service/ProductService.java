package com.example.onetomanydemo.service;

import com.example.onetomanydemo.entities.Category;
import com.example.onetomanydemo.entities.Product;
import com.example.onetomanydemo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public void createDb() {
        Category c1 = new Category();
        c1.setName("Fruits");

        Category c2 = new Category();
        c2.setName("Meat");

        Product p1 = new Product("Apple", 2000, 100);
        Product p2 = new Product("Orange", 1500, 100);

        Product p3 = new Product("Chicken", 150000, 100);
        Product p4 = new Product("Fish", 10000, 100);

        c1.addProducts(p1);
        c1.addProducts(p2);

        c2.addProducts(p3);
        c2.addProducts(p4);

//        c1.getProducts().add(p1);
//        c1.getProducts().add(p2);
//
//        c2.getProducts().add(p3);
//        c2.getProducts().add(p4);

        categoryRepository.save(c1);
        categoryRepository.save(c2);
    }

    @Transactional
    public void insertNewProductByCategoryName(String categoryName) {
        Category category = categoryRepository.fetchByName(categoryName);

        Product product = new Product("Grape", 45000, 50);
        category.addProducts(product);
        categoryRepository.save(category);
    }

    @Transactional
    public void deleteLastProduct() {
        Category category = categoryRepository.fetchByName("Fruits");
        List<Product> products = category.getProducts();
        category.removeProduct(products.get(products.size() -  1));
    }

    @Transactional
    public void deleteFirstProduct() {
        Category category = categoryRepository.fetchByName("Meat");
        List<Product> products = category.getProducts();
        category.removeProduct(products.get(0));
    }
}
