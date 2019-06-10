package cn.com.ebank.customer_service.customer.model;

import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Customer {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    private String customerNumber;

    @Embedded
    private EbankInfo ebankInfo;

    @Embedded
    private ContactsInfo contactsInfo;



    public Customer(String customerNumber) {
        this.customerNumber = customerNumber;
    }





}
