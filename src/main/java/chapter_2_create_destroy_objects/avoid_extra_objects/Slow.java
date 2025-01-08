package chapter_2_create_destroy_objects.avoid_extra_objects;

public class Slow {
    public static long sum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }
}
