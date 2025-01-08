package chapter_2_create_destroy_objects.use_try_with_resources;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {
    private Path testFolder;
    private Path sourceFile;
    private Path destinationFile;

    @BeforeEach
    void setUp() throws IOException {
        // Create a temporary test folder
        testFolder = Files.createTempDirectory("example-test");
        sourceFile = testFolder.resolve("test-source.txt");
        destinationFile = testFolder.resolve("test-destination.txt");

        // Create the source file with sample content
        try (FileWriter writer = new FileWriter(sourceFile.toFile())) {
            writer.write("Hello, World!\nThis is a test file.");
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        // Delete all files and the test folder
        Files.walk(testFolder)
                .map(Path::toFile)
                .forEach(File::delete);
    }

    @Test
    void testFirstLineOfFile() throws IOException {
        // Act
        String firstLine = Example.firstLineOfFile(sourceFile.toString());

        // Assert
        assertThat(firstLine).isEqualTo("Hello, World!");
    }

    @Test
    void testCopyFile() throws IOException {
        // Act
        Example.copy(sourceFile.toString(), destinationFile.toString());

        // Assert
        assertThat(destinationFile.toFile()).exists();
        assertThat(Files.readString(destinationFile)).isEqualTo(Files.readString(sourceFile));
    }

    @Test
    void testFirstLineOfFileThrowsExceptionForMissingFile() {
        // Act & Assert
        Path nonExistentFile = testFolder.resolve("non-existent.txt");
        assertThatThrownBy(() -> Example.firstLineOfFile(nonExistentFile.toString()))
                .isInstanceOf(IOException.class)
                .hasMessageContaining(nonExistentFile.toString());
    }

    @Test
    void testCopyThrowsExceptionForMissingSourceFile() {
        // Act & Assert
        Path nonExistentFile = testFolder.resolve("non-existent.txt");
        assertThatThrownBy(() -> Example.copy(nonExistentFile.toString(), destinationFile.toString()))
                .isInstanceOf(IOException.class)
                .hasMessageContaining(nonExistentFile.toString());
    }

}