package com.gent.miniproject.recommendationservice.Controller;

import com.gent.miniproject.recommendationservice.Model.Recommendation;
import com.gent.miniproject.recommendationservice.Repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RecommendationController {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @GetMapping("/recommendations")
    public List<Recommendation> getRecommendations(){
        return recommendationRepository.findAll();
    }

    @PostMapping("/recommendation")
    public void addRecommendation(@RequestBody Recommendation recommendation){
        recommendationRepository.save(recommendation);
    }

    @GetMapping("/recommendations/{productid}")
    public List<Recommendation> getRecommendationProductid(@PathVariable long productid) {
        var kommentar = recommendationRepository.findByproductid(productid);
        return kommentar;
    }


    @Transactional
    @DeleteMapping("/recommendation/{productid}")
    public void deleteByCustomedid(@PathVariable long productid) {
        recommendationRepository.deleteByProductid(productid);
    }


    //Extra
    @GetMapping("/recommendations/customer/{customerid}")
    public List<Recommendation> getRecommendationCustomerid(@PathVariable String customerid){
        var kommentar = recommendationRepository.findBycustomerid(customerid);
        return kommentar;
    }
    @GetMapping("/recommendations/rating/{rating}")
    public List<Recommendation> getKommentarBetyg(@PathVariable int rating) {
        var kommentar = recommendationRepository.findByRating(rating);
        return kommentar;
    }




}
