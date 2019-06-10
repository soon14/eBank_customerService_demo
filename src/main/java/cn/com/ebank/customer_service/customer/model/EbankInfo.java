package cn.com.ebank.customer_service.customer.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class EbankInfo {
    private String industry;
    private String corporationType;//企业性质
}
