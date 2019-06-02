package cn.com.zybank.pe.ebank.customer_service.operator;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@RequiredArgsConstructor
public class Operator{

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Getter
    @Setter
    @NonNull
    private  String name;

    @Getter
    @Setter
    @NotNull
    private Long organizationId;

    @Getter
    @Setter
    @ElementCollection
    private Set<Long> rolesId;

}
