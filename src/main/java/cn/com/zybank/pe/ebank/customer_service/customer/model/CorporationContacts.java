package cn.com.zybank.pe.ebank.customer_service.customer.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@RequiredArgsConstructor
@Getter
public class CorporationContacts {
    private final String name;
    private final String identificationType;
    private final String identificationNumber;
    private final String idVerifyResult;
    private final String phoneNumber;
}
