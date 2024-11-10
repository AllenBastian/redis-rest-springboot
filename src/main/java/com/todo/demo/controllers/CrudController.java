package com.todo.demo.controllers;


import com.todo.demo.entities.TodoList;
import com.todo.demo.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<TodoList> getAllTodos(){
        return crudService.getAllTodoLists();
    }

    @PostMapping("/add")
    public String addTodo(@RequestBody TodoList todo){
        System.out.println(todo.getTodoList());
        crudService.addTodoList(todo.getTodoList());
        return "successfully added the list";
    }


    @PutMapping("/update/{id}")
    public String updateTodo(@PathVariable Long id,@RequestBody TodoList todoList){
        crudService.updateTodoList(id,todoList.getTodoList());
        return "success";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id){
            crudService.deleteTodoList(id);
            return "success";
    }




}
