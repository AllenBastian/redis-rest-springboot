package com.todo.demo.services;

import com.todo.demo.entities.TodoList;
import com.todo.demo.repositories.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudService {

    private final TodoListRepository todoListRepository;

    @Autowired
    public CrudService(TodoListRepository todoListRepository){
        this.todoListRepository = todoListRepository;
    }

    public TodoList addTodoList(String todoList){
        TodoList todo = new TodoList();
        todo.setTodoList(todoList);
        return todoListRepository.save(todo);

    }
}
