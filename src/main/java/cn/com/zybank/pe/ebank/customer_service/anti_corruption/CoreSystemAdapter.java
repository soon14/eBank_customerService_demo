package cn.com.zybank.pe.ebank.customer_service.anti_corruption;


import cn.com.zybank.pe.ebank.customer_service.customer.model.CustomerBasicInformationFromCore;

public interface CoreSystemAdapter {
    CustomerBasicInformationFromCore getCustomerByCustomerNumber(String customerNumber);
    CustomerBasicInformationFromCore getCustomerByCertificationNumber(String certificationNumber);
    CustomerBasicInformationFromCore getCustomerByIdNumberOfLegalPerson(String idNumberOfLegalPerson);

    String[] getAccountsOfCustomerByCustomerNumber(String customerNumber);
}
