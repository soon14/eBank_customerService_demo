package cn.com.zybank.pe.ebank.customer_service.anti_corruption;

import cn.com.zybank.pe.ebank.customer_service.customer.CoreSystemAdapter;
import cn.com.zybank.pe.ebank.customer_service.customer.model.CustomerCoreInfo;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CoreSystemAdapterImpl implements CoreSystemAdapter {

    @Override
    public Optional<CustomerCoreInfo> getCustomerByCustomerNumber(String customerNumber) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerCoreInfo> getCustomerByCertificationNumber(String certificationNumber) {
        return Optional.empty();
    }


    @Override
    public String[] getAccountsOfCustomerByCustomerNumber(String customerNumber) {
        return new String[0];
    }

    @Override
    public Optional<CustomerCoreInfo> getCustomerByAccount(String accountNumber) {
        return Optional.empty();
    }
}
