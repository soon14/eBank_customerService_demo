package cn.com.ebank.customer_service.customer;

import cn.com.ebank.customer_service.customer.model.Customer;
import cn.com.ebank.customer_service.customer.model.CustomerCoreInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class CustomerServiceTest {

    public static final String CERTIFICATION_NUMBER = "10086";
    public static final String CUSTOMER_NUMBER = "100861";


    @Autowired
    CustomerService service;
    @MockBean
    CoreSystemAdapter adapter;




    @Test
    @DisplayName("从核心查找客户信息，输入组织机构代码，返回客户信息")
    void findCustomerFromCore_when_found() {
        when(adapter.getCustomerByCertificationNumber(CERTIFICATION_NUMBER)).thenReturn(Optional.of(stubCoreInfo()));

        CustomerCoreInfo coreInfo = service.findCoreInfoByCertificationNumber(CERTIFICATION_NUMBER);

        assertThat(coreInfo).isEqualTo(stubCoreInfo());

    }

    @Test
    @DisplayName("从核心查找客户信息，输入组织机构代码，没找到返回空的客户信息")
    void findCustomerFromCore_when_notFound() {
        CustomerCoreInfo coreInfo = service.findCoreInfoByCertificationNumber(CERTIFICATION_NUMBER);

        assertThat(coreInfo).isEqualTo(new CustomerCoreInfo());
    }



    @Test
    @DisplayName("客户在中台注册，验证生成了主键")
    void registerCustomer() {
        Customer customer = new Customer();
        assertNull(customer.getId());
        Customer register = service.register(customer);
        assertNotNull(register.getId());
    }


    @Test
    @DisplayName("通过客户号在中台找客户，找到返回")
    void find_Customer_In_EBank() {
        Customer customer = new Customer(CUSTOMER_NUMBER);
        customer.setCustomerNumber(CUSTOMER_NUMBER);
        Customer register = service.register(customer);

        Customer byCustmerNumber = service.findByCustmerNumber(CUSTOMER_NUMBER);

        assertThat(byCustmerNumber.getId()).isEqualTo(register.getId());
    }

    @Test
    @DisplayName("通过客户号在中台找客户，找不到返回空客户")
    void find_Customer_In_EBank_when_notFound() {
        Customer byCustmerNumber = service.findByCustmerNumber(CUSTOMER_NUMBER);
        service.deleteById(byCustmerNumber.getId());

        Customer fount = service.findByCustmerNumber(CUSTOMER_NUMBER);

        assertThat(fount).isEqualTo(new Customer());
    }


    private CustomerCoreInfo stubCoreInfo() {
        CustomerCoreInfo coreInfo = new CustomerCoreInfo();
        coreInfo.setCustomerNumber(CUSTOMER_NUMBER);
        coreInfo.setCertificationNumber(CERTIFICATION_NUMBER);
        coreInfo.setChineseName("中国航天");
        coreInfo.setEnglishName("china space");
        coreInfo.setAddress("知春里");
        coreInfo.setZipcode("10086");
        coreInfo.setLegalPersonName("NAME");
        coreInfo.setLegalPersonCertificationtype("身份证");
        coreInfo.setLegalPersonId("11001100110000");
        return coreInfo;
    }
}