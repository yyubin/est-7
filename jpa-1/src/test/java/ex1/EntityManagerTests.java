package ex1;

import domain.ex1.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import util.TestUtil;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static util.TestUtil.*;

@Slf4j
public class EntityManagerTests {

    static EntityManagerFactory emf;
    EntityManager em;

    @BeforeAll
    static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("hibernate-exp-1");
    }

    @AfterAll
    static void tearDownClass() {
        emf.close();
    }

    @BeforeEach
    void setUp() {
        em = emf.createEntityManager();
    }

    @AfterEach
    void tearDown() {
        em.close();
    }

    @Test
    @DisplayName("EntityManagerFactoryTest")
    void entity_manager_factory_test() throws Exception {
        Map<String, Object> properties = emf.getProperties();
        String url = properties.get("jakarta.persistence.jdbc.url").toString();
        String driver = properties.get("jakarta.persistence.jdbc.driver").toString();
        log.info("url = {}", url);
        log.info("driver = {}", driver);

        assertThat(url).isEqualTo("jdbc:mysql://localhost:3307/hibernate-test");
        assertThat(driver).isEqualTo("com.mysql.jdbc.Driver");
    }

    @Test
    @DisplayName("EntityMangerSaveTest")
    void entity_manager_save_test() throws Exception {
        Member newMember = genMember(genMemNum());
        executeCommit(em, () -> em.persist(newMember));
    }

    @Test
    @DisplayName("EntityManagerSelectTest")
    void entity_manager_select_test() throws Exception {
       Member newMember = genMember(genMemNum());
       executeCommit(em, () -> {
           em.persist(newMember);
           Member findMember = em.find(Member.class, newMember.getId());
           assertThat(findMember).isEqualTo(newMember);
           log.info("newMember = {}", newMember);
           log.info("findMember = {}", findMember);
           log.info("=========");
//           2024-11-22 11:44:49 [Test worker] INFO  ex1.EntityManagerTests - newMember = domain.ex1.Member@77998ea7
//           2024-11-22 11:44:49 [Test worker] INFO  ex1.EntityManagerTests - findMember = domain.ex1.Member@77998ea7

       });
       executeCommit(em, () -> {
           log.info("refresh");
           Member findMember = em.find(Member.class, newMember.getId());
           assertThat(findMember.getName()).isEqualTo(newMember.getName());
           findMember.setName("admin");
           log.info("=========");
       });
       executeCommit(em, () -> {
           log.info("변경 감지");
           Member findMember = em.find(Member.class, newMember.getId());
           assertThat(findMember.getName()).isEqualTo("admin");
           em.detach(findMember);
           findMember.setName("member");
           log.info("=========");
       });
        executeCommit(em, () -> {
            Member findMember = em.find(Member.class, newMember.getId());
            assertThat(findMember.getName()).isEqualTo("admin");
        });
        executeCommit(em, () -> {
            Member findMember = em.find(Member.class, newMember.getId());
            em.remove(findMember);
        });
        executeCommit(em, () -> {
           Member findMember = em.find(Member.class, newMember.getId());
            assertThat(findMember).isNull();
        });
    }

    @Test
    @DisplayName("WriteBehindTest")
    void write_behind_test() throws Exception {
       executeCommit(em, () -> {
           Member mem1 = genMember(genMemNum());
           Member mem2 = genMember(genMemNum());
           em.persist(mem1);
           em.persist(mem2);
           log.info("쿼리 실행은 나중에");
       });
       
    }
    
    private Member genMember(String memNum) {
        return Member.builder()
                .id(memNum)
                .name("member" + memNum)
                .build();
    }

    private String genMemNum() {
        return genNumStr();
    }

}
