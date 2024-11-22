package ex4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class ProxyTests {

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
    @DisplayName("proxyTest")
    void proxy_test() throws Exception {


    }
}
