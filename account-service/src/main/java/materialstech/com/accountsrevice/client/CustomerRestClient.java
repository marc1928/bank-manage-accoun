package materialstech.com.accountsrevice.client;

import feign.Client;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import materialstech.com.accountsrevice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/api/customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    @GetMapping("/api/customers")
    List<Customer> allCustomers();

    // circuit Breaker
    default Customer getDefaultCustomer(Long id, Exception exception){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("Unknown");
        customer.setLastName("Customer");
        customer.setEmail("Unknown");
        return customer;
    }

    default List<Customer> getDefaultCustomers(Exception exception){
        return List.of();
    }

}
