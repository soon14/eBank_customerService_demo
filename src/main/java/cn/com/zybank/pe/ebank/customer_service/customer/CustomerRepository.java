package cn.com.zybank.pe.ebank.customer_service.customer;

import cn.com.zybank.pe.ebank.customer_service.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Optional<Customer> findByCustomerNumber(String customerNumber);

    void deleteByCustomerNumber(String customerNumber);
}
