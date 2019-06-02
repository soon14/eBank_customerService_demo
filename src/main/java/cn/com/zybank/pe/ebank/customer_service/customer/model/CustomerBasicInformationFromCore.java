package cn.com.zybank.pe.ebank.customer_service.customer.model;

import lombok.Data;

@Data
public class CustomerBasicInformationFromCore {
    private String customerNumber;
    private String certificationNumber;
    private String corporationNameInChinese;
    private String corporationNameInEnglish;
    private String address;
    private String zipCode;
    private String phoneNumber;
    private String legalPersonName;
    private String certificationTypeOfLegalPerson;
    private String idNumberOfLegalPerson;
}
