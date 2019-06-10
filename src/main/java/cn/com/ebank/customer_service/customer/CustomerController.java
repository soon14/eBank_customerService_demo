package cn.com.ebank.customer_service.customer;

import cn.com.ebank.customer_service.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @PostMapping("/findByCustomerNumber")
    public Customer findByCustoemrNumber(@RequestParam("customerNumber") String customerNumber){
        Customer byCustmerNumber = service.findByCustmerNumber(customerNumber);
        return byCustmerNumber;
    }


    @PostMapping
    public Customer register(@RequestBody Customer customer) {
        return service.register(customer);
    }
}
