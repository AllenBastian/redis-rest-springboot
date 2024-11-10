package com.todo.demo.controllers;


import com.todo.demo.entities.TodoList;
import com.todo.demo.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class CrudController {


    private final CrudService crudService;

    @Autowired
    public CrudController(CrudService crudService){
        this.crudService = crudService;
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<TodoList>> getAllTodos(){
        List<TodoList>myTodo = crudService.getAllTodoLists();
        return ResponseEntity.status(HttpStatus.OK).body(myTodo);
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
