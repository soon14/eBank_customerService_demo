package cn.com.zybank.pe.ebank.customer_service.customer_channel.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
public class CustomerChannelPK implements Serializable {
    private final Long customerId;
    private final Long channelId;


}
