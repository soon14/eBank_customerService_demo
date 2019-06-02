package cn.com.zybank.pe.ebank.customer_service.operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;

    @Override
    public Operator save(Operator operator) {
        return operatorRepository.save(operator);
    }


}
