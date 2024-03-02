package service.impL;

import domain.Task;
import enums.TaskPriorityEnum;
import enums.TaskStatusEnum;
import service.TaskService;

import java.time.LocalDateTime;

public class TaskServiceImpl implements TaskService {
    static{
        TO_DO_LIST[0] = new Task("Running at 4 pm");
        TO_DO_LIST[1] = new Task("Reading books every day");
        TO_DO_LIST[2] = new Task("Playing tennis ");
    }
    @Override
    public void addTask(Task task) {
        boolean isAdded = false;
        for (int i = 0; i < TO_DO_LIST.length; i++) {
            if(TO_DO_LIST[i] == null){
                isAdded = true;
                TO_DO_LIST[i] = task;
                System.out.println("Task successfully added");
                break;
            }
        }
        if(!isAdded){
            System.out.println("Don't have space for task");
        }
    }

    @Override
    public void showAllTasks() {
        for (int i = 0; i < TO_DO_LIST.length; i++) {
            if(TO_DO_LIST[i] == null){
                break;
            }
            System.out.println(i+1 + " " + TO_DO_LIST[i]);
        }
    }

    @Override
    public void updateStatus(int index, TaskStatusEnum status) {
        if(index < 1 || index > TO_DO_LIST.length) System.out.println("You wrote invalid index");
        TO_DO_LIST[index-1].setStatus(status);
        TO_DO_LIST[index-1].setLastEditedAt(LocalDateTime.now());

    }

    @Override
    public void updatePriority(int index, TaskPriorityEnum priority) {
        if(index < 1  || index > TO_DO_LIST.length) System.out.println("You wrote invalid index");
        TO_DO_LIST[index-1].setPriority(priority);
        TO_DO_LIST[index-1].setLastEditedAt(LocalDateTime.now());
    }

    @Override
    public void showByStatus(TaskStatusEnum status) {
        int index = 0;
        for (Task task: TO_DO_LIST) {
            if (task == null) break;
            else if(task.getStatus().equals(status)){
                System.out.println(++index + " " + task);
            }
        }

    }

    @Override
    public void deleteTask(int index) {
        for (int i = index - 1; i < TO_DO_LIST.length-1; i++) {
            if (TO_DO_LIST[i] == null){
                break;
            }
            TO_DO_LIST[i] = TO_DO_LIST[i+1];
        }
        System.out.println("Deleted task");
    }
}
