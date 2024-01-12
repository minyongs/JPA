package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member1 {

    @Id //id 명시
    private Long id;

    @Column(name ="name") //객체명과 db 콜룸명을 다르게 지정 가능
    private String username;

    private Integer age;
    //Enum 타입 매핑
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    //@Temporal -> 날짜 타입 매핑
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    //BLOB , CLOB 매핑
    @Lob
    private String description;


    @Transient // db랑 관계없이 사용하고싶어 !(매핑 안할래)
    private int Temp;

    public Member1(){

    }




}
