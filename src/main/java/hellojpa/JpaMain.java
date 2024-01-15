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
            Team team = new Team();
            team.setName("TeamA");

            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class , member.getId()); //멤버의 아이디 찾기
            List<Member> members1 = findMember.getTeam().getMembers(); // 그 아이디를 가진 멤버의 팀의 멤버들 호출


            for (Member member1 : members1) {
                System.out.println("==============:" + members1);

            }





            tx.commit(); //트랜잭션 커밋
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }



        emf.close();
    }
}
