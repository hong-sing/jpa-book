package jpabook.start;

import javax.persistence.*;
import java.util.Date;

@Entity // 해당 클래스를 테이블과 매핑한다고 JPA에게 알려준다.
@Table(name = "MEMBER") // 엔티티 클래스에 매핑할 테이블 정보를 알려준다.
//@Table(name = "MEMBER", uniqueConstraints = {@UniqueConstraint(name = "NAME_AGE_UNIQUE", columnNames = {"NAME", "AGE"})})
public class Member {
    @Id // 엔티티 클래스의 필드를 테이블의 기본키에 매핑한다.
    @Column(name = "ID")    // 필드를 컬럼에 매핑한다.
    private String id;          //아이디
//    @Column(name = "NAME", nullable = false, length = 10)
    @Column(name = "NAME")
    private String username;    //이름
    // 매핑 어노테이션이 없다면 필드명을 사용해서 컬럼명으로 매핑한다.
    private Integer age;        //나이

    // p.124
    @Enumerated(EnumType.STRING)    // 자바의 enum을 사용하려면 @Enumerated 어노테이션으로 매핑해야 함
    private RoleType roleType;      // enum을 사용해서 회원 타입 구분

    @Temporal(TemporalType.TIMESTAMP)   // 자바의 날짜 타입은 @Temporal을 사용해서 매핑
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob    // 회원을 설명하는 필드는 길이 제한이 없다. 따라서 VARCHAR 대신 CLOB 타입으로 저장. @LOB을 사용하면 CLOB, BLOB 타입을 매핑할 수 있음
    private String description;



    //Getter, Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
