package cn.com.zybank.pe.ebank.customer_service.customer;

import cn.com.zybank.pe.ebank.customer_service.anti_corruption.CoreSystemAdapter;
import cn.com.zybank.pe.ebank.customer_service.customer.model.Customer;
import cn.com.zybank.pe.ebank.customer_service.customer.model.CustomerBasicInformationFromCore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
class CustomerServiceTest {


    public static final String CUSTOMER_NUMBER = "110";
    @MockBean
    CoreSystemAdapter coreSystemAdapter;

    @Autowired
    CustomerService customerService;


    @Test
    void should() {
        CustomerBasicInformationFromCore customerBasicInformationFromCore = make();

        when(coreSystemAdapter.getCustomerByCustomerNumber(CUSTOMER_NUMBER)).thenReturn(customerBasicInformationFromCore);
        Customer customer = customerService.loadCustomerByCustomerNumber(CUSTOMER_NUMBER);
        assertThat(customer.getCustomerBasicInformationFromCore()).isSameAs(customerBasicInformationFromCore);

        



    }

    private CustomerBasicInformationFromCore make() {
        CustomerBasicInformationFromCore customerBasicInformationFromCore = new CustomerBasicInformationFromCore();
        customerBasicInformationFromCore.setAddress("河南");
        customerBasicInformationFromCore.setCertificationNumber("1000");
        customerBasicInformationFromCore.setCertificationTypeOfLegalPerson("不知道");
        customerBasicInformationFromCore.setCorporationNameInChinese("双汇");
        customerBasicInformationFromCore.setCorporationNameInEnglish("shuanhui");
        customerBasicInformationFromCore.setIdNumberOfLegalPerson("2000");
        customerBasicInformationFromCore.setCustomerNumber(CUSTOMER_NUMBER);
        customerBasicInformationFromCore.setLegalPersonName("张三丰");
        customerBasicInformationFromCore.setPhoneNumber("139000010001");
        customerBasicInformationFromCore.setZipCode("10089");
        return customerBasicInformationFromCore;
    }
}