package cn.com.zybank.pe.ebank.customer_service.account;

import cn.com.zybank.pe.ebank.customer_service.customer_channel.model.CustomerChannelPK;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Account {
    @Id
    private final Long id;
    private double onceLimit;
    private double dayAmmount;
    private OperateType operateType;


    private CustomerChannelPK customerChannelId;

}
