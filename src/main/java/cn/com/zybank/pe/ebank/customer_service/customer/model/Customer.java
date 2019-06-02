package cn.com.zybank.pe.ebank.customer_service.customer.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Data
@EqualsAndHashCode(of = "customerNumber")
public class Customer {
    @Id
    @Setter(AccessLevel.NONE)
    private final String customerNumber;

    @Transient
    private CustomerBasicInformationFromCore customerBasicInformationFromCore;

    @Embedded
    private EBankBaseInfo eBankBaseInfo;

    @Embedded
    private CorporationContacts corporationContacts;

}
