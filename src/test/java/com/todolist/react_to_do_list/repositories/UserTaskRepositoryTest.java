package com.todolist.react_to_do_list.repositories;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.todolist.react_to_do_list.models.Task;
import com.todolist.react_to_do_list.models.User;

@SpringBootTest
public class UserTaskRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void testHello() {
        String hello = "Hello world";
        String hello1 = "Hello world";

        assertSame(hello, hello1);
    }

    @Test
    void testRepositoryUserAndTask() {
        User user = new User();
        user.setName("Miftah");
        user.setEmail("miftahfadilah71@gmail.com");
        user.setPassword("rahasia");
        userRepository.save(user);

        Task task = new Task();
        task.setTitle("Coding");
        task.setDescription("Do Coding");
        task.setUser(user);
        taskRepository.save(task);

        List<Task> tasks = taskRepository.findAll();

        tasks.forEach(n -> System.out.println("Title : " + n.getTitle() + " Description : " + n.getDescription()
                + " User : " + n.getUser().getName()));
    }

}
