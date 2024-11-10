package com.todo.demo.repositories;


import com.todo.demo.entities.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepository extends JpaRepository<TodoList,Long> {
}