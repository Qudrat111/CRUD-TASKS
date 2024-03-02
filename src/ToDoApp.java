import domain.Task;
import enums.TaskPriorityEnum;
import enums.TaskStatusEnum;
import service.TaskService;
import service.impL.TaskServiceImpl;

import java.util.Scanner;

public class ToDoApp {
    static Scanner scannerInt = new Scanner(System.in);
    static TaskService taskService = new TaskServiceImpl();
    static Scanner scannerStr = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to my app");
        while (true) {
            showMenu();
            System.out.print("Choose = ");
            int choice = scannerInt.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter task name = ");
                    String taskName = scannerStr.nextLine();
                    taskService.addTask(new Task(taskName));
                }
                case 2 -> {
                    taskService.showAllTasks();
                }
                case 3 -> {
                    TaskStatusEnum.showAllStatus();
                    System.out.print("Choose = ");
                    int choice1 = scannerInt.nextInt();
                    if (choice1 < 1 || choice1 > 3) {
                        System.out.println("You wrote incorrect index");
                    } else {
                        TaskStatusEnum byIndex = TaskStatusEnum.getByIndex(choice1);
                        taskService.showByStatus(byIndex);
                    }
                }
                case 4 -> {
                    taskService.showAllTasks();
                    System.out.print("Choose = ");
                    int choice2 = scannerInt.nextInt();
                    if (choice2 < 1 || choice2 > TaskServiceImpl.TO_DO_LIST.length) {
                        System.out.println("You wrote incorrect index");
                    }else{
                        TaskStatusEnum.showAllStatus();
                        int choice1 = scannerInt.nextInt();
                        if (choice1 < 1 || choice1 > 3) {
                            System.out.println("You wrote incorrect index");
                        } else {
                            TaskStatusEnum byIndex = TaskStatusEnum.getByIndex(choice1);
                            taskService.updateStatus(choice2, byIndex);

                        }
                    }
                }
                case 5 -> {
                    taskService.showAllTasks();
                    System.out.print("Choose = ");
                    int choice2 = scannerInt.nextInt();
                    if (choice2 < 1 || choice2 > TaskServiceImpl.TO_DO_LIST.length) {
                        System.out.println("You wrote incorrect index");
                    } else {
                        TaskPriorityEnum.showAllPriority();
                        int choice1 = scannerInt.nextInt();
                        if (choice1 < 1 || choice1 > 3) {
                            System.out.println("You wrote incorrect index");
                        } else {
                            TaskPriorityEnum byIndex = TaskPriorityEnum.getByIndex(choice1);
                            taskService.updatePriority(choice2, byIndex);
                        }
                    }
                }
                case 6 ->{
                    taskService.showAllTasks();
                    System.out.print("Choose = ");
                    int choice2 = scannerInt.nextInt();
                    if(choice2 < 1 || choice2 > TaskServiceImpl.TO_DO_LIST.length){
                        System.out.println("You wrote invalid index");
                    }else{
                        taskService.deleteTask(choice2);
                    }
                }

                case 0 -> {
                    return;
                }
            }


        }
    }

    public static void showMenu() {
        System.out.println("""
                1 Add task
                2 Show all
                3 Show by status
                4 Update Task status
                5 Update Task priority
                6 Delete task
                0 Exit""");
    }
}