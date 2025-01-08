package chapter_2_create_destroy_objects.avoid_extra_objects;

public class Fast {
    public static long sum() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }
}
