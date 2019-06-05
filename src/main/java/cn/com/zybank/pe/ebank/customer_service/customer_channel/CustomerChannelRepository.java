package cn.com.zybank.pe.ebank.customer_service.customer_channel;

import cn.com.zybank.pe.ebank.customer_service.customer_channel.model.CustomerChannel;
import cn.com.zybank.pe.ebank.customer_service.customer_channel.model.CustomerChannelPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface CustomerChannelRepository extends CrudRepository<CustomerChannel, CustomerChannelPK> {

//    @Query("SELECT cc from CustomerChannel cc JOIN cc.singedFunctions where cc.customerChannelPK.customerId= :customerId")
    List<CustomerChannel> findById_customerId(long customerId);
}
