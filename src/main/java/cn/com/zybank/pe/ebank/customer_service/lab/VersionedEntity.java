package cn.com.zybank.pe.ebank.customer_service.lab;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
@RequiredArgsConstructor
@Data
public class VersionedEntity {

    @Id
    @GeneratedValue
    private  Long id;


    private  String name;

    @Version
    private long version;

    public VersionedEntity(String name) {
        this.name = name;
    }
}
