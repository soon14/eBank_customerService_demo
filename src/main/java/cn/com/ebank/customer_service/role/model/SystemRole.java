package cn.com.ebank.customer_service.role.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor(force = true)
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class SystemRole {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    private  String roleName;

    private OperateType OperateType;

    @Column(nullable = false)
    private Long channelId;

    @ElementCollection
    private Set<Long> functionSet;


    public void setOperateType(OperateType operateType) {
        this.OperateType = operateType;
    }
}
