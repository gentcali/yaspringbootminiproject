package com.gent.miniproject.commonbackendservice.Repository;


import com.gent.miniproject.commonbackendservice.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository implements QRepository<Customer> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> findAll(){
        var result = jdbcTemplate.query("select * from customers", BeanPropertyRowMapper.newInstance(Customer.class));
        return result;
    }

    @Override
    public List<Customer> findHalf() {
        var result = jdbcTemplate.query("select customerID, City from customers", BeanPropertyRowMapper.newInstance(Customer.class));
        return result;
    }


    @Override
    public int save(Customer customer) {
        var result = jdbcTemplate.update("insert into customers(CustomerID, CompanyName) values(?,?)",
                new Object[]{customer.getCustomerID(), customer.getCompanyName()});
        return result;
    }

    @Override
    public int update(Customer customer) {
        return 0;
    }



    @Override
    public int deleteById(String id) {
        var result = jdbcTemplate.update("delete from customers where CustomerID=?", id);
        return result;
    }


    @Override
    public Customer findById(int id) {
        var result = jdbcTemplate.query("select * from customers where CustomerID = ?",
                BeanPropertyRowMapper.newInstance(Customer.class), id);
        return result != null && result.size()>0 ? result.get(0) : new Customer();
    }

}
