package cn.com.zybank.pe.ebank.customer_service.operator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OperatorRepository extends JpaRepository<Operator,Long> {
    List<Operator> findByCustomerId(Long customerId);

}
