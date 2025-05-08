package com.todolist.react_to_do_list.dto;

import java.util.UUID;

import com.todolist.react_to_do_list.enums.Status;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequest {

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    private UUID user_id;
}
