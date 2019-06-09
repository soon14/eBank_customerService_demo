package cn.com.zybank.pe.ebank.customer_service.customer.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class ContactsInfo {
    private String name;
    private String certificationType;
    private String idNumber;
    private String verifyResult;
    private String phone;
}
