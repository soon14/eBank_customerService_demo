package cn.com.zybank.pe.ebank.customer_service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public Account mount(Account account) {
        return repository.save(account);
    }

    public Account findById(Long account_id) throws AccountNotFoundException {
        return repository.findById(account_id).orElseThrow(AccountNotFoundException::new);
    }
}
