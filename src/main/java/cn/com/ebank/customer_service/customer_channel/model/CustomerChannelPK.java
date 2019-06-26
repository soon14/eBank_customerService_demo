package cn.com.ebank.customer_service.customer_channel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
public class CustomerChannelPK implements Serializable {
    @Column(name = "CUSTOMER_ID")
    private final Long customerId;
    @Column(name = "CHANNEL_ID")
    private final Long channelId;

}
