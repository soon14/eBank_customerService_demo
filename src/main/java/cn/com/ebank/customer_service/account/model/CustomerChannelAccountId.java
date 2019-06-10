package cn.com.ebank.customer_service.account.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class CustomerChannelAccountId implements Serializable {
    private final Long customerId;
    private final Long channelId;
    private final String accountNumber;
}
