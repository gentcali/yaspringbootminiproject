package com.gent.miniproject.customersupportservice.Controller;

import com.gent.miniproject.customersupportservice.Model.Customersupport;
import com.gent.miniproject.customersupportservice.Repository.CustomersupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomersupportController {

    @Autowired
    private CustomersupportRepository customerSupportRepository;

    @GetMapping("/tasks")
    public List<Customersupport> getCustomersupport(){
       return customerSupportRepository.findAll();
    }

    @PostMapping("/task")
    public void addCustomersupport(@RequestBody Customersupport customerSupport){
        customerSupportRepository.save(customerSupport);
    }

    @PutMapping("/task")
    public void updateCustomersupport(@RequestBody Customersupport customerSupport) {
        Customersupport actualtask = customerSupportRepository.getById(customerSupport.getCustomersupportid());
        actualtask.setCustomerid(customerSupport.getCustomerid());
        actualtask.setComment(customerSupport.getComment());
        actualtask.setPriority(customerSupport.getPriority());
        actualtask.setStatus(customerSupport.getStatus());
        customerSupportRepository.save(actualtask);
    }

    @Transactional
    @DeleteMapping("/tasks/{customerid}")
    public void deleteByKundid(@PathVariable long customerid) {
        customerSupportRepository.deleteByCustomerid(customerid);
    }



    @GetMapping("/tasks/{customerid}")
    public List<Customersupport> getKundsupportkund(@PathVariable long customerid){
        var kundsupport = customerSupportRepository.findByCustomerid(customerid);
        return kundsupport;
    }


}
