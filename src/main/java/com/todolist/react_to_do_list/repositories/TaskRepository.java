package com.todolist.react_to_do_list.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.react_to_do_list.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

}
