package cn.com.ebank.customer_service.account;

import cn.com.ebank.customer_service.account.model.ChannelAccount;
import cn.com.ebank.customer_service.account.model.CustomerChannelAccountId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ChannelAccountService {

    @Autowired
    private ChannelAccountRepository repository;

    public ChannelAccount mount(Long customerId, Long channelId, String  accountNumber) {
        ChannelAccount channelAccount = new ChannelAccount(new CustomerChannelAccountId(customerId, channelId, accountNumber));
        return  repository.save(channelAccount);
    }

    public List<ChannelAccount> findByAccountNumber(String accountNumber) {
        return repository.findById_accountNumber(accountNumber);
    }

    public void unmount(CustomerChannelAccountId id) {
        repository.deleteById(id);
    }
}
