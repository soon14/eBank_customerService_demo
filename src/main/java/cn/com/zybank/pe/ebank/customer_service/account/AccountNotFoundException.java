package cn.com.zybank.pe.ebank.customer_service.account;

import lombok.Data;

@Data
public class AccountNotFoundException extends Exception {
    private Long accountId;
}
