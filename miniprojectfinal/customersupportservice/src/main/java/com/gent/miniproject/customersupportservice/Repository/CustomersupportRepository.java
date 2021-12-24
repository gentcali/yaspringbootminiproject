package com.gent.miniproject.customersupportservice.Repository;

import com.gent.miniproject.customersupportservice.Model.Customersupport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomersupportRepository extends JpaRepository<Customersupport, Long> {


    public List<Customersupport> findByCustomerid(long customerid);

    @Modifying
    @Query("delete from Customersupport b where b.customerid=:customerid")
    void deleteByCustomerid(@Param("customerid") long customerid);



}




