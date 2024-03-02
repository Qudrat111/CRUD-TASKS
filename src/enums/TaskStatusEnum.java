package enums;

public enum TaskStatusEnum {
    NEW(1),
    IN_PROGRESS(2),
    FINISHED(3);
    private int index;

    TaskStatusEnum(int index) {
        this.index = index;
    }

    public static void showAllStatus() {
        TaskStatusEnum[] values = TaskStatusEnum.values();
        for (TaskStatusEnum status : values) {
            System.out.println(status.index + " " + status.name());
        }
    }

    public static TaskStatusEnum getByIndex(int index) {
        TaskStatusEnum[] statusEnum = TaskStatusEnum.values();
        for (var status : statusEnum) {
            if (status.index == index) {
                return status;
            }
        }
        return null;

    }
}
