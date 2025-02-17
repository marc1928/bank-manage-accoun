package materialstech.com.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import materialstech.com.customerservice.entities.Customer;
// import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// @RepositoryRestResource // start automatically web service to manage the customer (post, get etc..)
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
