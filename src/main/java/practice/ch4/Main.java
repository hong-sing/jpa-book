package practice.ch4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // 엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpastudy");

        // 엔티티 매니저 생성
        EntityManager em = emf.createEntityManager();

        // 트랜잭션 획득
        EntityTransaction tx = em.getTransaction(); // 트랜잭션 API
        try {
            tx.begin();     // 트랜잭션 시작

            // 비즈니스 로직 실행

            tx.commit();    // 트랜잭션 커밋
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();  // 트랜잭션 롤백
        } finally {
            em.close();     // 엔티티 매니저 종료
        }
        emf.close();       // 엔티티 매니저 팩토리 종료
    }
}
