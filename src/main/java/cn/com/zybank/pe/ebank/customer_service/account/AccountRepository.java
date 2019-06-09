package cn.com.zybank.pe.ebank.customer_service.account;

import cn.com.zybank.pe.ebank.customer_service.account.model.Account;
import cn.com.zybank.pe.ebank.customer_service.customer_channel.model.CustomerChannelPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AccountRepository extends CrudRepository<Account,Long> {
    List<Account> findByCustomerChannelId(CustomerChannelPK customerChannelId);
}
