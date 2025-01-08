package chapter_2_create_destroy_objects.use_singleton;

import chapter_2_create_destroy_objects.use_singleton.ElvisEnum;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ElvisEnumTest {
    @Test
    void testSingletonProperty() {
        // Verify that ElvisEnum.INSTANCE is the same instance
        ElvisEnum firstInstance = ElvisEnum.INSTANCE;
        ElvisEnum secondInstance = ElvisEnum.INSTANCE;

        // Assert that both instances are the same
        assertThat(firstInstance).isSameAs(secondInstance);
    }

    @Test
    void testLeaveBuilding() {
        // Redirect system output to capture the print statement
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        // Call the leaveBuilding method
        ElvisEnum.INSTANCE.leaveBuilding();

        // Assert the printed output
        String actualOutput = outContent.toString().trim();
        assertThat(actualOutput).isEqualTo("Elvis left building");
    }
}