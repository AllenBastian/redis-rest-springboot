package com.todo.demo.controllers;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
public class CrudController {

    @GetMapping("/get-all")
    public String getAllTodos(){
        return "hello checking";
    }

//    @PostMapping("/add")
//    public String addTodo(){
//        return "added";
//    }
//
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteTodo(){
//        return "deleted";
//    }


}
