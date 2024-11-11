package com.todo.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "todolist should not be null")
    @NotBlank(message = "todolist cannot be blank")
    private String todoList;


    public TodoList(){}




    public void setTodoList(String todoList) {
        this.todoList = todoList;
    }

    public String getTodoList() {
        return todoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
