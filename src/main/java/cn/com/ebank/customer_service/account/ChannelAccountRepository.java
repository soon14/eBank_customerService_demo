package cn.com.ebank.customer_service.account;

import cn.com.ebank.customer_service.account.model.ChannelAccount;
import cn.com.ebank.customer_service.account.model.CustomerChannelAccountId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ChannelAccountRepository extends CrudRepository<ChannelAccount, CustomerChannelAccountId> {
    List<ChannelAccount> findById_accountNumber(String accountNumber);
}
