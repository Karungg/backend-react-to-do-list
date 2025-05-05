package com.todolist.react_to_do_list.enums;

public enum Status {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    CANCELED("Canceled"),
    DONE("Done");

    private final String label;

    Status(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
