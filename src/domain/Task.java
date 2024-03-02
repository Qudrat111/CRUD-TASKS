package domain;

import enums.TaskPriorityEnum;
import enums.TaskStatusEnum;
import util.DateUtil;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
    UUID uuid = UUID.randomUUID();
    private String name;
    private  TaskStatusEnum status = TaskStatusEnum.NEW;
    private  TaskPriorityEnum priority = TaskPriorityEnum.MEDIUM;
    private final LocalDateTime createdAt = LocalDateTime.now();
    private  LocalDateTime lastEditedAt;
    public Task(){

    }
    public Task(String taskName){
        this.name = taskName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setStatus(TaskStatusEnum status){this.status = status;}
    public void setPriority(TaskPriorityEnum priority){this.priority = priority;}

    public TaskStatusEnum getStatus() {
        return status;
    }

    public TaskPriorityEnum getPriority() {
        return priority;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastEditedAt() {
        return lastEditedAt;
    }

    public void setLastEditedAt(LocalDateTime lastEditedAt) {
        this.lastEditedAt = lastEditedAt;
    }

    @Override
    public String toString() {
        return String.format("%s { status = %s , priority = %s , createdAt = %s , lastEditedAt = %s , id = %s}"
                , name, status, priority, DateUtil.formatDate(createdAt), DateUtil.formatDate(lastEditedAt),uuid);
    }
}
