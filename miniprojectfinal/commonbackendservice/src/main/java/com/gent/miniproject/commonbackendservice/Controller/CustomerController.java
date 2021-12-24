package com.gent.miniproject.commonbackendservice.Controller;

import com.gent.miniproject.commonbackendservice.Model.*;
import com.gent.miniproject.commonbackendservice.Repository.CustomerRepository;
import com.gent.miniproject.commonbackendservice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public ProductRepository productRepository;


    @GetMapping("/customers")
    public List<Customer> getKunderfulla(){
        return customerRepository.findAll();
    }

    /*
    @GetMapping("/kunderhalf")
    public List<Customer> getKunder(){
        return customerRepository.findHalf();
    }
*/


    @GetMapping("/customer/{id}")
    public Customer getKunder(@PathVariable int id){
        return customerRepository.findById(id);
    }

    @PostMapping("/customer")
    public void addKunder(@RequestBody Customer customer) {
        customerRepository.save(customer);
}

    @DeleteMapping("/customer/{id}")
    public void deleteKunder(@PathVariable String id) {
        customerRepository.deleteById(id);
    }


    @PutMapping("/customer")
    public void update(@RequestBody Customer customer) {
    }

    //Reactibe WebFlux

    @GetMapping("/recommendation/{ProductID}")
    public CustomerExtended getKommentar(@PathVariable int ProductID){
        Customer customer = customerRepository.findById(ProductID);

        WebClient client = WebClient.create("http://recommendation-service:8080/api/v1");
        var recommendations =
                client.get()
                        .uri("/recommendations/" + ProductID)
                        .retrieve()
                        .bodyToMono(new ParameterizedTypeReference<List<Recommendation>>(){})
                        .block();
        CustomerExtended customerExtended = new CustomerExtended();
        customerExtended.setRecommendations(recommendations);
        return customerExtended;
    }


    @GetMapping("/customersupport/{CustommerID}")
    public Customersupport getCustomersupport(@PathVariable int CustommerID){
        Products products = productRepository.findById(CustommerID);

        WebClient client = WebClient.create("http://customer-support-service:8080/api/v1");
        var varkundsupport =
                client.get()
                        .uri("/tasks/" + CustommerID)
                        .retrieve()
                        .bodyToMono(new ParameterizedTypeReference<List<Customersupport>>(){})
                        .block();
        Customersupport customersupport = new Customersupport();
        customersupport.setCustomersupport(varkundsupport);
        return customersupport;
    }



}
