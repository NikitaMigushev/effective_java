package chapter_2_create_destroy_objects.use_singleton;

import chapter_2_create_destroy_objects.use_singleton.Elvis;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElvisTest {
    @Test
    void testSingletonProperty() {
        Elvis firstInstance = Elvis.INSTANCE;
        Elvis secondInstance = Elvis.INSTANCE;
        assertSame(firstInstance, secondInstance, "Elvis.INSTANCE should always return the same instance");
    }

    @Test
    void testLeaveTheBuilding() {
        // Redirect system output to capture the print statement
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        // Call the leaveTheBuilding method
        Elvis.INSTANCE.leaveTheBuilding();

        // Normalize and trim the output for comparison
        String actualOutput = outContent.toString().trim().replace("\r\n", "\n");
        String expectedOutput = "Elvis left the building";

        // Assert the printed message
        assertEquals(expectedOutput, actualOutput, "The method should print the correct message");
    }

}