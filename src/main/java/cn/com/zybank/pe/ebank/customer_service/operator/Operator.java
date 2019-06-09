package cn.com.zybank.pe.ebank.customer_service.operator;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
public class Operator{

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Column(nullable = false)
    private  String name;

    @NotNull
    @Column(nullable = false)
    private Long customerId;

    @ElementCollection
    private Set<Long> rolesId;

}
