package cn.com.zybank.pe.ebank.customer_service.anti_corruption;

import cn.com.zybank.pe.ebank.customer_service.customer.model.CustomerBasicInformationFromCore;
import org.springframework.stereotype.Component;

@Component
public class CoreSystemAdapterImpl implements CoreSystemAdapter {
    @Override
    public CustomerBasicInformationFromCore getCustomerByCustomerNumber(String customerNumber) {
        return null;
    }

    @Override
    public CustomerBasicInformationFromCore getCustomerByCertificationNumber(String certificationNumber) {
        return null;
    }

    @Override
    public CustomerBasicInformationFromCore getCustomerByIdNumberOfLegalPerson(String idNumberOfLegalPerson) {
        return null;
    }

    @Override
    public String[] getAccountsOfCustomerByCustomerNumber(String customerNumber) {
        return new String[0];
    }
}
