package cn.com.zybank.pe.ebank.customer_service.customer;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class EBankInfo {
    private String industry;
    private String corporationType;//企业性质
}
