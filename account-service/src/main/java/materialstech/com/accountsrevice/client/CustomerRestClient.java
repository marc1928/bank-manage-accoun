package materialstech.com.accountsrevice.client;

import materialstech.com.accountsrevice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface CustomerRestClient {

    @FeignClient(name = "CUSTOMER-SERVICE")
    public interface CustomerClient {
        @GetMapping("/api/customers/{id}")
        Customer findCustomerById(PathVariable Long id);
        @GetMapping("/api/customers")
        List<Customer> allCustomers();
    }

}
