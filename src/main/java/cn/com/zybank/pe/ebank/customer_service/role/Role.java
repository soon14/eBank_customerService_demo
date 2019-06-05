package cn.com.zybank.pe.ebank.customer_service.role;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@EqualsAndHashCode(of = "id")
@ToString
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    private final RoleType type;
    private Long customer;

    public void setCustomer(Long customerId) {
        this.customer=customerId;
    }
}
