package cn.com.ebank.customer_service.lab;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionedEntityRepository extends JpaRepository<VersionedEntity,Long> {

    VersionedEntity findByName(String name);
}
