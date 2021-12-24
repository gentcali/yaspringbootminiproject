package com.gent.miniproject.commonbackendservice.Repository;


import com.gent.miniproject.commonbackendservice.Model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements QRepository<Products> {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Products> findAll() {
        var result = jdbcTemplate.query("select * from products", BeanPropertyRowMapper.newInstance(Products.class));
        return result;
    }

    @Override
    public List<Products> findHalf() {
        var result = jdbcTemplate.query("select productID, productName, unitPrice from products", BeanPropertyRowMapper.newInstance(Products.class));
        return result;
    }

    @Override
    public int save(Products products) {
        var result = jdbcTemplate.update("insert into products(ProductID, ProductName, UnitsInStock, UnitPrice, Discontinued) values(?,?,?,?,?)",
                new Object[]{products.getProductID(), products.getProductName(), products.getUnitsInStock(), products.getUnitPrice(), products.isDiscontinued()});
        return result;
    }

    @Override
    public int deleteById(String id) {
        var result = jdbcTemplate.update("delete from products where ProductID=?", id);
        return result;
    }



    @Override
    public int update(Products products) {
        return jdbcTemplate.update("UPDATE products SET productName = ?, unitsInStock = ?, unitPrice = ?, discontinued = ? WHERE ProductID = ?",
                new Object[] {products.getProductName(), products.getUnitsInStock(), products.getUnitPrice(), products.isDiscontinued(), products.getProductID()});
    }



    @Override
    public Products findById(int id) {
        var result = jdbcTemplate.query("select * from products where ProductID = ?",
                BeanPropertyRowMapper.newInstance(Products.class), id);
        return result != null && result.size()>0 ? result.get(0) : new Products();
    }


}
