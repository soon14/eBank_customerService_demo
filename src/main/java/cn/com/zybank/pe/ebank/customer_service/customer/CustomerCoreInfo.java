package cn.com.zybank.pe.ebank.customer_service.customer;

import lombok.Data;

@Data
public class CustomerCoreInfo {
    private String customerNumber;
    private String certificationNumber;
    private String chineseName;
    private String EnglishName;
    private String address;
    private String zipcode;
    private String phoneNumber;
    private String legalPersonName;
    private String legalPersonCertificationtype;
    private String legalPersonId;
}
