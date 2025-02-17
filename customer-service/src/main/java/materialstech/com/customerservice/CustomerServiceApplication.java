package materialstech.com.customerservice;

import materialstech.com.customerservice.entities.Customer;
import materialstech.com.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            List<Customer> customerList = List.of(
                    Customer.builder()
                            .firstName("Marc")
                            .lastName("Bassi")
                            .email("bilickbassi@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("Francky")
                            .lastName("Tchoungue")
                            .email("tch@gmail.com")
                            .build()
            );
            customerRepository.saveAll(customerList);


        };
    }
}
