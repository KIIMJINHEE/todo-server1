package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity {

    //1. id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    //2. title
    @Column(nullable = false) //title이 없으면 DB에 넣는게 의미가 없기 때문
    private String title;

    //3. order
    @Column(nullable = false, name = "todoOrder") //'order'키워드가 H2 DB에서 예약어로 사용되고 있기 때문에 별도의 컬럼명 지정
    private Long order;

    //4. completed
    //완료 여부
    @Column(nullable = false)
    private Boolean completed;


}
