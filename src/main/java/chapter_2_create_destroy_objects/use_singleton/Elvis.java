package chapter_2_create_destroy_objects.use_singleton;

import java.io.ObjectStreamException;

public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() {}

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("Elvis left the building");
    }

    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
}
