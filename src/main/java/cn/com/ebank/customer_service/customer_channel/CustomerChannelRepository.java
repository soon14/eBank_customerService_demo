package cn.com.ebank.customer_service.customer_channel;

import cn.com.ebank.customer_service.customer_channel.model.CustomerChannel;
import cn.com.ebank.customer_service.customer_channel.model.CustomerChannelPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerChannelRepository extends CrudRepository<CustomerChannel, CustomerChannelPK> {

//    todo: n+1 次查询
    @Query("SELECT cc from CustomerChannel cc  where cc.id.customerId= :customerId")
    List<CustomerChannel> findById_customerId(long customerId);
}
