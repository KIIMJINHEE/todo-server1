package org.example.repository;

import org.example.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//repository : persistence layer라고 하는 DB랑 데이터를 주고받기 위한 인터페이스를 정의한 부분.
//             '저장소' 라는 뜻이지만, 여기서는 실제 데이터를 저장하고 있는 클래스가 아니라 '데이터를 주고받는 방식인 인터페이스'임.

//'JpaRepository'인터페이스를 상속해서 사용
//Long : TodoEntity의 id에 해당하는 필드 타입
@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

}