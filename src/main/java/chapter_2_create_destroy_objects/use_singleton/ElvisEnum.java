package chapter_2_create_destroy_objects.use_singleton;

public enum ElvisEnum {
    INSTANCE;
    public void leaveBuilding() {
        System.out.println("Elvis left building");
    }
}
