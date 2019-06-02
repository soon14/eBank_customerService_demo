package cn.com.zybank.pe.ebank.customer_service.customer;

import cn.com.zybank.pe.ebank.customer_service.anti_corruption.CoreSystemAdapter;
import cn.com.zybank.pe.ebank.customer_service.customer.model.Customer;
import cn.com.zybank.pe.ebank.customer_service.customer.model.CustomerBasicInformationFromCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CoreSystemAdapter coreSystemAdapter;

    public Customer loadCustomerByCertificationNumber(String certificationNumber){
        CustomerBasicInformationFromCore basicInformation = coreSystemAdapter.getCustomerByCertificationNumber(certificationNumber);
        return getChannelCustomer(basicInformation);
    }

    public Customer loadCustomerByCustomerNumber(String customerNumber){
        CustomerBasicInformationFromCore customerBasicInformationFromCore = coreSystemAdapter.getCustomerByCustomerNumber(customerNumber);
        return getChannelCustomer(customerBasicInformationFromCore);
    }

    private Customer getChannelCustomer(CustomerBasicInformationFromCore basicInformation) {
        Optional<Customer> channelCustomer = customerRepository.findById(basicInformation.getCustomerNumber());
        Customer customer = channelCustomer.orElse(new Customer(basicInformation.getCustomerNumber()));
        customer.setCustomerBasicInformationFromCore(basicInformation);
        return customer;
    }
}
