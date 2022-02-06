package org.example;

import org.example.repository.TodoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
스프링부트로 어플리케이션을 설계할 때 다양한 컴포넌트(패키지)들을 조합해서 사용하는데 .
우리는 Model, Repository, Service, Controller 이렇게 4개의 Layer로 나누어 구현!
1. Model : model -> TodoEntity, TodoRequest, TodoResponse
2. Repository : repository -> TodoRepository
3. Service : service -> TodoService
4. Controller(서버에 들어오는 요청을 받는 부분) :
 */

//org.example -> TodoServerApplication
//이 부분이 '메인 메서드' 입니다!!

@SpringBootApplication
public class TodoServerApplication {
    public static void main(String[] args) {
        //System.out.println("K JH");
        SpringApplication.run(TodoServerApplication.class, args);
    }
}