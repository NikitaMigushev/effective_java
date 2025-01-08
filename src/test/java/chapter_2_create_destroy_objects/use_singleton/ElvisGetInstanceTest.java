package chapter_2_create_destroy_objects.use_singleton;

import chapter_2_create_destroy_objects.use_singleton.Elvis;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ElvisGetInstanceTest {
    @Test
    void testSingletonProperty() {
        // Access the singleton instance using the getInstance() method
        Elvis firstInstance = Elvis.getInstance();
        Elvis secondInstance = Elvis.getInstance();

        // Verify that both references point to the same instance
        assertSame(firstInstance, secondInstance, "Elvis.getInstance() should always return the same instance");
    }

    @Test
    void testLeaveTheBuilding() {
        // Redirect system output to capture the print statement
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        // Call the leaveTheBuilding method
        Elvis.getInstance().leaveTheBuilding();

        // Normalize and trim the output for comparison
        String actualOutput = outContent.toString().trim().replace("\r\n", "\n");
        String expectedOutput = "Elvis left the building";

        // Assert the printed message
        assertEquals(expectedOutput, actualOutput, "The method should print the correct message");
    }
}