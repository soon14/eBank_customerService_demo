package cn.com.zybank.pe.ebank.customer_service.customer_channel.model;

import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@RequiredArgsConstructor
public class Customer_Channel {

    @Id
    private final Long customerId;
    @Id
    private final Long channelId;

    private long  limitOfYearAmount;
    private long  limitOfDayAmount;
    private long  limitOfDayNumber;




}
