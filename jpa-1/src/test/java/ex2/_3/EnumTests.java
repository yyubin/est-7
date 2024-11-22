package ex2._3;

import domain.ex2._3.GymMembership;
import domain.ex2._3.Level;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;
import util.TestUtil;

public class EnumTests {
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
    @DisplayName("enumTest")
    void enum_test() throws Exception {
        TestUtil.executeCommit(em, () -> {
            GymMembership gymMembership1 = new GymMembership();
            gymMembership1.setMembershipLevel(Level.GOLD);
            em.persist(gymMembership1);
            GymMembership gymMembership2 = new GymMembership();
            gymMembership2.setMembershipLevel(Level.SLIVER);
            em.persist(gymMembership2);
            GymMembership gymMembership3 = new GymMembership();
            gymMembership3.setMembershipLevel(Level.GENERAL);
            em.persist(gymMembership3);
        });

    }
}
