package cn.com.zybank.pe.ebank.customer_service.customer;

import cn.com.zybank.pe.ebank.customer_service.customer.model.Customer;
import cn.com.zybank.pe.ebank.customer_service.customer.model.CustomerCoreInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomerService {
    @Autowired
    CoreSystemAdapter adapter;

    @Autowired
    CustomerRepository repository;

    public CustomerCoreInfo findCoreInfoByCertificationNumber(String certificationNumber) {
        Optional<CustomerCoreInfo> coreInfo = adapter.getCustomerByCertificationNumber(certificationNumber);
        return coreInfo.orElse(new CustomerCoreInfo());
    }

    public Customer register(Customer customer) {
        return repository.save(customer);
    }

    public Customer findByCustmerNumber(String customerNumber) {
        return repository.findByCustomerNumber(customerNumber).orElse(new Customer());
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
