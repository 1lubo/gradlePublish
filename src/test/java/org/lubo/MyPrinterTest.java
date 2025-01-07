package org.lubo;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MyPrinterTest {

    @Test
    void printTextPrintsCorrectMessage() {
        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the method
        MyPrinter.printText();

        // Verify the output
        assertEquals("Hello from Maven Repository!\n", outContent.toString());
    }

    @Test
    void printTextDoesNotThrowException() {
        assertDoesNotThrow(() -> MyPrinter.printText());
    }
}