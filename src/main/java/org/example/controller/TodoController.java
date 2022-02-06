package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.model.TodoEntity;
import org.example.model.TodoRequest;
import org.example.model.TodoResponse;
import org.example.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/")
public class TodoController {

    private final TodoService service;

    @PostMapping
    //Response를 응답으로 내려주는 create 메서드(엔드포인트)
    //postman : POST -> create()
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request){
        System.out.println("CREATE");

        //잘못된 요청이라고 응답
        if(ObjectUtils.isEmpty(request.getTitle()))  return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getOrder()))  request.setOrder(0L);

        if(ObjectUtils.isEmpty(request.getCompleted()))  request.setCompleted(false);

        TodoEntity result = this.service.add(request);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @GetMapping("{id}")
    //하나만 읽어 오는 readOne 메서드(엔드포인트)
    public ResponseEntity<TodoResponse> readOne(@PathVariable Long id){
        System.out.println("READ ONE");
        TodoEntity result = this.service.searchById(id);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @GetMapping
    //전체를 읽어오는 메서드(엔드포인트)
    //postman : GET -> create()
    public ResponseEntity<List<TodoResponse>> readAll(){
        System.out.println("READ ALL");
        List<TodoEntity> list = this.service.searchAll();
        List<TodoResponse> response = list.stream().map(TodoResponse::new)
                                                    .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PatchMapping("{id}")
    //postman : PATCH -> create()
    public ResponseEntity<TodoResponse> update(@PathVariable Long id, @RequestBody TodoRequest request){
        System.out.println("UPDATE");
        TodoEntity result = this.service.updateById(id, request);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id){
        System.out.println("DELETE");
        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll(){
        System.out.println("DELETE ALL");
        this.service.deleteAll();
        return ResponseEntity.ok().build();
    }

    //위 메서드들 작성후, API 잘 동작하는지 POSTMAN에서 확인
    //이후에, 구현된 프론트에 Todo-server2를 붙이는 작업
}
