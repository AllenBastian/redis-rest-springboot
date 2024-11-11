package com.todo.demo.controllers;


import com.todo.demo.entities.TodoList;
import com.todo.demo.http.response.ApiResponse;
import com.todo.demo.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todo")
public class CrudController {


    private final CrudService crudService;

    @Autowired
    public CrudController(CrudService crudService){
        this.crudService = crudService;
    }


    @GetMapping("/get-all")
    public ResponseEntity<ApiResponse<List<TodoList>>>getAllTodos(){

        List<TodoList>myTodo = crudService.getAllTodoLists();
        ApiResponse<List<TodoList>> myResponse = new ApiResponse<>("success",myTodo);
        return ResponseEntity.status(HttpStatus.OK).body(myResponse);
    }

    @PostMapping("/add")
    public ResponseEntity<TodoList> addTodo(@RequestBody TodoList todo){
        System.out.println(todo.getTodoList());
        TodoList mytodo = crudService.addTodoList(todo.getTodoList());
        return ResponseEntity.status(HttpStatus.CREATED).body(mytodo);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<TodoList> updateTodo(@PathVariable Long id,@RequestBody TodoList todoList){
        System.out.println(id);
        crudService.updateTodoList(id,todoList.getTodoList());
        return ResponseEntity.status(HttpStatus.OK).body(todoList);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TodoList> deleteTodo(@PathVariable Long id){
            crudService.deleteTodoList(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
    }




}
