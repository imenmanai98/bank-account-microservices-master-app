package imen.tn.accountservice;

import imen.tn.accountservice.clients.CustomerRestClient;
import imen.tn.accountservice.entities.BankAccount;
import imen.tn.accountservice.enums.AccountType;
import imen.tn.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        return  args -> {
            customerRestClient.allCustomers().forEach(c->{
                BankAccount bankAccount1 = BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .currency("MAD")
                        .solde(98000)
                        .createAt(LocalDate.now())
                        .type(AccountType.SAVING_ACCOUNT)
                        .customerId(c.getId())
                        .build();
                bankAccountRepository.save(bankAccount1);

                BankAccount bankAccount21 = BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .currency("EUR")
                        .solde(Math.random()*8000)
                        .createAt(LocalDate.now())
                        .type(AccountType.CURRENT_ACCOUNT)
                        .customerId(c.getId())
                        .build();
                bankAccountRepository.save(bankAccount21);

            });



        };
    }
}
