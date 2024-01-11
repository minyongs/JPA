package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();//모든 데이터 변경은 transaction 에서 이루어져야 함

        tx.begin(); // 트랜잭션 시작


        Member member = new Member();

        member.setId(2L);
        member.setName("HelloB");


        em.persist(member);

        tx.commit(); //트랜잭션 커밋



        em.close();
        emf.close();
    }
}
