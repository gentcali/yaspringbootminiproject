package com.gent.miniproject.commonbackendservice.Controller;

import com.gent.miniproject.commonbackendservice.Model.Customer;
import com.gent.miniproject.commonbackendservice.Model.CustomerExtended;
import com.gent.miniproject.commonbackendservice.Model.PriceConversionRequest;
import com.gent.miniproject.commonbackendservice.Model.Products;
import com.gent.miniproject.commonbackendservice.Model.Recommendation;
import com.gent.miniproject.commonbackendservice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8088")
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    public ProductRepository productRepository;

    @GetMapping("/products")
    public List<Products> getProdukterAlla(){
        return productRepository.findAll();
    }

/*
    @GetMapping("/produkterhalf")
    public List<Products> getProdukterHalf(){
        return productRepository.findHalf();
    }
*/
    @GetMapping("/product/{id}")
    public Products getProdukter(@PathVariable int id, @RequestParam(required = false) String curr){
    	
    	Products ret = productRepository.findById(id);
    	if(curr != null ) {
    		convertPrice(ret, curr);
    	}
    	return ret;
    }

    @PostMapping("/product")
    public void addProdukter(@RequestBody Products products) {
        productRepository.save(products);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProdukter(@PathVariable String id) {
        productRepository.deleteById(id);
    }

    //Måste göra PUT

    @PutMapping("/product/{ProductID}")
/*
    public String update(@RequestBody Products products, @PathVariable int ProductID) {
        return produktRepository.update(products)+" Product(s) updated successfully";
   }

*/
    public ResponseEntity<String> updateProduktin(@PathVariable("ProductID") int ProductID, @RequestBody Products products) {
        Products actualProducts = productRepository.findById(ProductID);

        if (actualProducts != null) {
            actualProducts.setProductID(ProductID);
            actualProducts.setProductName(products.getProductName());
            actualProducts.setUnitsInStock(products.getUnitsInStock());
            actualProducts.setUnitPrice(products.getUnitPrice());
            actualProducts.setDiscontinued(products.isDiscontinued());

            productRepository.update(actualProducts);
            return new ResponseEntity<>("Product was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find Product with id=" + ProductID, HttpStatus.NOT_FOUND);
        }
    }
    
    public Products convertPrice(Products products, String targetCurrency){
    	PriceConversionRequest req = new PriceConversionRequest(products.getUnitPrice(), targetCurrency);
    	
        WebClient client = WebClient.create("http://foreign-currency:8080/api/v1");
        var recommendations =
                client.post()
                        .uri("/price/")
                        .bodyValue(req)
                        .retrieve()
                        .bodyToMono(Double.class)
                        .block();
        CustomerExtended customerExtended = new CustomerExtended();
        products.setUnitPrice(recommendations);
        return products;
    }


}
