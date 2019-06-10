package cn.com.zybank.pe.ebank.customer_service.account.model;

import cn.com.zybank.pe.ebank.customer_service.customer_channel.model.CustomerChannelPK;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class ChannelAccount {
    @EmbeddedId
    private final CustomerChannelAccountId id;

    @Column(nullable = false)
    private double onceLimit;
    private double dayAmmount;
    private PermitType permitType;




}
