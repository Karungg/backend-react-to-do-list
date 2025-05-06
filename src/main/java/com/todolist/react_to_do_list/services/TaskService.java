package com.todolist.react_to_do_list.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.react_to_do_list.enums.Status;
import com.todolist.react_to_do_list.models.Task;
import com.todolist.react_to_do_list.models.User;
import com.todolist.react_to_do_list.repositories.TaskRepository;
import com.todolist.react_to_do_list.repositories.UserRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> getById(UUID id) {
        return taskRepository.findById(id);
    }

    public Task addTask(Task task, UUID userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }

        task.setUser(user.get());
        task.setStatus(Status.ACTIVE);
        return taskRepository.save(task);
    }

    public Task updateTask(UUID taskId, Task updatedTask) {
        return taskRepository.findById(taskId).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            return taskRepository.save(task);
        }).orElseThrow(() -> new IllegalArgumentException("Task not found"));
    }

    public void deleteTask(UUID taskId) {
        if (!taskRepository.existsById(taskId)) {
            throw new IllegalArgumentException("Task not found");
        }
        taskRepository.deleteById(taskId);
    }

    public List<Task> getTasksByUserId(UUID userId) {
        return taskRepository.findAll().stream()
                .filter(task -> task.getUser().getId().equals(userId))
                .toList();
    }
}
