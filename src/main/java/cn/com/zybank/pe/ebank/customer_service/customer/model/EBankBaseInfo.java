package cn.com.zybank.pe.ebank.customer_service.customer.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@RequiredArgsConstructor
public class EBankBaseInfo {
    private final String industry;
    private final String corporationCharacter;
}
