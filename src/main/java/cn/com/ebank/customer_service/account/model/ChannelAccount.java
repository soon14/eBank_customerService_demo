package cn.com.ebank.customer_service.account.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


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
