package imen.tn.customerservice.repository;

import imen.tn.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
//générer les web services automatiqument : un web service générique
//@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
