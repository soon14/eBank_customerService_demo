package cn.com.zybank.pe.ebank.customer_service.customer;

import cn.com.zybank.pe.ebank.customer_service.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

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
}
