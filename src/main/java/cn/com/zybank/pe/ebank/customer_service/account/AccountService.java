package cn.com.zybank.pe.ebank.customer_service.account;

import cn.com.zybank.pe.ebank.customer_service.account.model.Account;
import cn.com.zybank.pe.ebank.customer_service.customer_channel.model.CustomerChannelPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public Account mount(Account account) {
        return repository.save(account);
    }

    public void unmount(Long account_id) {
        repository.deleteById(account_id);
    }

    @Transactional(readOnly = true)
    public Account findById(Long account_id) {
        return repository.findById(account_id).orElse(new Account());
    }

    public List<Account> findByCustomerChannel(CustomerChannelPK customerChannelId) {
        return repository.findByCustomerChannelId(customerChannelId);
    }
}
