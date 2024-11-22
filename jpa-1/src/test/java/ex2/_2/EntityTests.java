package ex2._2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

@Slf4j
public class EntityTests {
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
    @DisplayName("tableStrategyTest")
    void table_strategy_test() throws Exception {

        

    }

}
