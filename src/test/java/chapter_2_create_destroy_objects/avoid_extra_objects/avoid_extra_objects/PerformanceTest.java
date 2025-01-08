package chapter_2_create_destroy_objects.avoid_extra_objects.avoid_extra_objects;

import chapter_2_create_destroy_objects.avoid_extra_objects.Fast;
import chapter_2_create_destroy_objects.avoid_extra_objects.Slow;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PerformanceTest {

    @Disabled
    @Test
    public void comparePerformanceInPercent() {
        // Measure execution time of Fast.sum()
        long fastStartTime = System.nanoTime();
        Fast.sum();
        long fastEndTime = System.nanoTime();
        long fastDuration = fastEndTime - fastStartTime;

        // Measure execution time of Slow.sum()
        long slowStartTime = System.nanoTime();
        Slow.sum();
        long slowEndTime = System.nanoTime();
        long slowDuration = slowEndTime - slowStartTime;

        // Calculate the percentage difference
        double percentDifference = ((double) (slowDuration - fastDuration) / fastDuration) * 100;

        System.out.println("Fast.sum() duration: " + fastDuration + " ns");
        System.out.println("Slow.sum() duration: " + slowDuration + " ns");
        System.out.println("Slow is " + percentDifference + "% slower than Fast.");

        // Assert that Fast is faster than Slow
        assertThat(fastDuration).isLessThan(slowDuration);

        // Assert that the percentage difference is significant
        assertThat(percentDifference).isGreaterThan(0);
    }
}