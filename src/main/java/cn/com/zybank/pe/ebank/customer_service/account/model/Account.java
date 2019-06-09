package cn.com.zybank.pe.ebank.customer_service.account.model;

import cn.com.zybank.pe.ebank.customer_service.customer_channel.model.CustomerChannelPK;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Account {
    @Id
    @GeneratedValue
    private final Long id;
    @Column(nullable = false)
    private String accountNumber;
    private double onceLimit;
    private double dayAmmount;
    private PermitType permitType;


    private CustomerChannelPK customerChannelId;

}
