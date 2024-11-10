package com.todo.demo.controllers;


import com.todo.demo.entities.TodoList;
import com.todo.demo.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
public class CrudController {


    private final CrudService crudService;

    @Autowired
    public CrudController(CrudService crudService){
        this.crudService = crudService;
    }


    @GetMapping("/get-all")
    public String getAllTodos(){
        return "hello checkinsssgss";
    }

    @PostMapping("/add")
    public String addTodo(@RequestBody TodoList todo){
        System.out.println(todo.getTodoList());
        crudService.addTodoList(todo.getTodoList());
        return "successfully added the list";
    }
//
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteTodo(){
//        return "deleted";
//    }


}
