package com.example.gp9assignment2.model;

public class Task {
    private String taskId;
    private String taskName;
    private String dueDateTime;

    public Task(String taskId, String taskName, String dueDateTime) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.dueDateTime = dueDateTime;
    }

    public String getTaskId() {
        return taskId;
    }

    /*public void setTaskId(String taskId) {
        this.taskId = taskId;
    }*/

    public String getTaskName() {
        return taskName;
    }

    /*public void setTaskName(String taskName) {
        this.taskName = taskName;
    }*/

    public String getDueDateTime() {
        return dueDateTime;
    }

   /* public void setDueDateTime(String dueDateTime) {
        this.dueDateTime = dueDateTime;
    }*/
}
