package com.gent.miniproject.commonbackendservice.Model;

import java.util.List;

public class Customersupport {

    private long productid;
    private long customerid;
    private String comment;
    private List<Customersupport> customersupport;


    public Customersupport() {
    }

    public Customersupport(long productid, long customerid, String commnent, List<Customersupport> customersupport) {
        this.productid = productid;
        this.customerid = customerid;
        this.comment = comment;
        this.customersupport = customersupport;
    }


    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Customersupport> getCustomersupport() {
        return customersupport;
    }

    public void setCustomersupport(List<Customersupport> customersupport) {
        this.customersupport = customersupport;
    }
}
