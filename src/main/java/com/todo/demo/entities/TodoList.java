package com.todo.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "todolist should not be null")
    @NotBlank(message = "todolist cannot be blank")
    @Size(min=0,max=50,message = "todolist size must be between 0 and 50 characters")
    private String todoList;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


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
