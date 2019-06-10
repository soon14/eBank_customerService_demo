package cn.com.zybank.pe.ebank.customer_service.account.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@RequiredArgsConstructor
public class CustomerChannelAccountId implements Serializable {
    private final Long customerId;
    private final Long channelId;
    private final String accountNumber;
}
