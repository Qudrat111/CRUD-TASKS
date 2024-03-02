package service;

import domain.Task;
import enums.TaskPriorityEnum;
import enums.TaskStatusEnum;

public interface TaskService {
    Task[] TO_DO_LIST = new Task[20];

    public void addTask(Task task);
    public void showAllTasks();
    public void updateStatus(int index, TaskStatusEnum status);
    public void updatePriority(int index, TaskPriorityEnum priority);
    public void showByStatus(TaskStatusEnum status);
    public void deleteTask(int index);
}
