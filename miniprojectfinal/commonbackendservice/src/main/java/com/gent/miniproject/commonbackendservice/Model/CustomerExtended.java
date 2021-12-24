package com.gent.miniproject.commonbackendservice.Model;

import java.util.List;

public class CustomerExtended {

    private long id;
    private long customerid;
    private List<Recommendation> recommendations;

    public CustomerExtended() {
    }

    public CustomerExtended(long id, long customerid, List<Recommendation> recommendations) {
        this.id = id;
        this.customerid = customerid;
        this.recommendations = recommendations;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }

    public List<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }
}
