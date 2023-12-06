package imen.tn.customerservice.web;

import imen.tn.customerservice.entities.Customer;
import imen.tn.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class CustomerRestController {
    //Pour injection des dependance
   // @Autowired
    private CustomerRepository customerRepository;
// meilleur pratique pour l'injection des dépendance : on crée le constructeur
    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")

    public List<Customer>  customerList(){
        return customerRepository.findAll();
    }
    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable Long id){
        return  customerRepository.findById(id).get();
    }
}
