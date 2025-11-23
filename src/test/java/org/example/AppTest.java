package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    //represents an in‑memory output stream
    //When you write bytes to it, they are stored in a byte array inside the object instead of going to a file, socket, etc.
    // You can later call toByteArray() or toString() to get what was written
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    //When testing code that prints to the console, you often redirect System.out to a ByteArrayOutputStream (like your outputStreamCaptor)
    // to capture the output.
    //Because in tests you often temporarily change System.out so you can inspect what got printed.
    private final PrintStream originalOut = System.out;

    //setOut changes where System.out.println(...) goes
    //so before each test, it is redirecting System.out so that all printlns are captured in memory instead of printed on the screen
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    //After each test, put System.out back to normal so the console works again.
    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainPrintsHelloWorld() {
        App.main(new String[]{});
        assertEquals("Hello World!", outputStreamCaptor.toString().trim());
    }

    @Test
    public void testMainDoesNotThrowException() {
        assertDoesNotThrow(() -> App.main(new String[]{}));
    }
}