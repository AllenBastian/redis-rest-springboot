package com.todo.demo.repositories;


import com.todo.demo.entities.TodoList;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList,Long> {

    @Modifying
    @Transactional
    @Query("UPDATE TodoList t SET t.todoList =  ?1 where t.id = ?2")
    int updateTodoList(String newTodoList, Long id);

}