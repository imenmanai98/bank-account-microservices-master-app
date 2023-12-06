package imen.tn.accountservice.web;

import imen.tn.accountservice.clients.CustomerRestClient;
import imen.tn.accountservice.entities.BankAccount;
import imen.tn.accountservice.model.Customer;
import imen.tn.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private  CustomerRestClient customerRestClient;

    public AccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }


    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        List<BankAccount> bankAccounts =bankAccountRepository.findAll();
        bankAccounts.forEach(s->{
            s.setCustomer(customerRestClient.findCustomerById(s.getCustomerId()));
        });
        return bankAccounts;

    }
    @GetMapping("/accounts/{id}")
    public  BankAccount bankAccountById(@PathVariable  String id){

        BankAccount bankAccount=  bankAccountRepository.findById(id).get();
        Customer customer =customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
