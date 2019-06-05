package cn.com.zybank.pe.ebank.customer_service.customer;


import java.util.Optional;

public interface CoreSystemAdapter {
    
    Optional<CustomerCoreInfo> getCustomerByCustomerNumber(String customerNumber);
    Optional<CustomerCoreInfo> getCustomerByCertificationNumber(String certificationNumber);

    String[] getAccountsOfCustomerByCustomerNumber(String customerNumber);

    Optional<CustomerCoreInfo> getCustomerByAccount(String accountNumber);
}
