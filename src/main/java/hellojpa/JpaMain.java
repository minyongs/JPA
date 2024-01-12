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

        try {
            Member1 member1 = new Member1();
             // 비영속 상태
            //member.setId(100L);
            //member.setName("HelloJPA");
            //영속 상태 진입 -> enityManger를 통해 엔티티가 관리됨

            member1.setId(1L);
            member1.setUsername("송민형");
            em.persist(member1);




            tx.commit(); //트랜잭션 커밋
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }


        em.close();
        emf.close();
    }
}
