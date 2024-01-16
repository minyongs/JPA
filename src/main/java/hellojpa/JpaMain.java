package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();//모든 데이터 변경은 transaction 에서 이루어져야 함

        tx.begin(); // 트랜잭션 시작

        try {
          Movie movie = new Movie();
          movie.setActor("송민형");
          movie.setDirector("감독");
          movie.setName("인셉션");

          movie.setPrice(10000);

          em.persist(movie);








            tx.commit(); //트랜잭션 커밋
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }



        emf.close();
    }
}
