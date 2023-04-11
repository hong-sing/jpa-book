package jpabook.start;

import javax.persistence.*;

@Entity
// 시퀀스 전략
//@SequenceGenerator(name = "BOARD_SEQ_GENERATOR",
//        sequenceName = "BOARD_SEQ", // 매핑할 데이터베이스 시퀀스 이름
//        initialValue = 1, allocationSize = 1)
// 테이블 전략
@TableGenerator(
        name = "BOARD_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnName = "BOARD_SEQ", allocationSize = 1)
public class Board {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR")
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "BOARD_SEQ_GENERATOR")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public Long getId() {
        return id;
    }
}
