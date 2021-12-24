package com.gent.miniproject.recommendationservice.Repository;

import com.gent.miniproject.recommendationservice.Model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

    List<Recommendation> findAll();
    public List<Recommendation> findByproductid(long productid);
    public List<Recommendation> findByRating(int rating);
    public List<Recommendation> findBycustomerid(String customerid);


    @Modifying
    @Query("delete from Recommendation b where b.productid=:productid")
    void deleteByProductid(@Param("productid") long productid);



}
