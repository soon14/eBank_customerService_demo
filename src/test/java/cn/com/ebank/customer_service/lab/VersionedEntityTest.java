package cn.com.ebank.customer_service.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class VersionedEntityTest {
    @Autowired
    private VersionedEntityRepository repository;

    @BeforeEach
    void setUp() {
        VersionedEntity alex = new VersionedEntity("Alex");
        repository.save(alex);
    }

    @Test
    @DisplayName("保存方法应该也可以更新一个已经存在的实体")
    void save_should_can_update_an_exist_entity() {
        long initCount = repository.count();

        VersionedEntity alexSon = new VersionedEntity("Alex son");
        alexSon.setId(repository.findByName("Alex").getId());

        VersionedEntity shouldSaved = repository.save(alexSon);

        assertThat(initCount).isEqualTo(repository.count());
        assertThat(shouldSaved).isNotNull();

        assertThat(repository.findByName("Alex")).isNull();

    }

    @Test
    @DisplayName("不能更新一个版本已经变更过的实体")
    void testVersion() {
        VersionedEntity testSaved = repository.save(new VersionedEntity("lab"));

        VersionedEntity testClone = clone(testSaved);

        updateAndWriteToDB(testSaved);

        shouldThrowExceptionWhenSaveClone(testClone);
    }

    private void shouldThrowExceptionWhenSaveClone(VersionedEntity testClone) {
        assertThrows(Exception.class,()->repository.save(testClone));
    }

    private void updateAndWriteToDB(VersionedEntity testSaved) {
        testSaved.setName("lab name update");
        repository.flush();
    }

    private VersionedEntity clone(VersionedEntity testSaved) {
        VersionedEntity testClone = new VersionedEntity("testClone");
        testClone.setId(testSaved.getId());
        return testClone;
    }
}