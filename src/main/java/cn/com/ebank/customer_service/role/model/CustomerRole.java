package cn.com.ebank.customer_service.role.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Getter
public class CustomerRole extends SystemRole {
    private final Long customerId;
}
