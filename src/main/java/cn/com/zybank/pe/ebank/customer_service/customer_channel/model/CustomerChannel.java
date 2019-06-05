package cn.com.zybank.pe.ebank.customer_service.customer_channel.model;

import lombok.*;
import org.springframework.util.SerializationUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class CustomerChannel implements Serializable {

    @EmbeddedId
    private final CustomerChannelPK id;

    //todo： 考虑与系统限额的约束关系
    @Setter
    private long yearAmountLimit;
    @Setter
    private long dayAmountLimit;
    @Setter
    private long dayNumberLimit;

    //todo: 关注渠道功能变化的事件
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "customer_channel_function",joinColumns = {@JoinColumn(name="customer_id"),@JoinColumn(name = "channel_id")})
    @Setter
    private Set<Long>  singedFunctions = new HashSet<>();

// todo:   测试 beanUtil 是否可行
    public Set<Long> getSingedFunctions() {

        return (Set<Long>) SerializationUtils.deserialize(SerializationUtils.serialize(singedFunctions));
    }
}
