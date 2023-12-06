package imen.tn.customerservice;

import imen.tn.customerservice.config.GlobalConfig;
import imen.tn.customerservice.entities.Customer;
import imen.tn.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
//Il va être lancé au démarrage bean
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            Customer customer1 = Customer.builder()
                    .firstName("imen")
                    .lastName("manai")
                    .email("imen.manai@esprit.tn")
                    .build();
            customerRepository.save(customer1);
            Customer customer2 = Customer.builder()
                    .firstName("seif allah")
                    .lastName("jallali")
                    .email("seifallah.jallali@esprit.tn")
                    .build();
            customerRepository.save(customer2);
        };
    }
}
