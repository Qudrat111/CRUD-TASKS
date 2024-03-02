package enums;

public enum TaskPriorityEnum {
    LOW(1),
    MEDIUM(2),
    HIGH(3);
    private int index;

    TaskPriorityEnum(int index) {
        this.index = index;
    }
    public static void showAllPriority(){
        TaskPriorityEnum[] values = TaskPriorityEnum.values();
        for (TaskPriorityEnum priority: values) {
            System.out.println(priority.index +" " + priority.name());
        }
    }
    public static TaskPriorityEnum getByIndex(int index){
        TaskPriorityEnum[] values = TaskPriorityEnum.values();
        for (TaskPriorityEnum priority: values) {
         if (priority.index == index){
             return priority;
         }
        }
        return null;
    }
}
