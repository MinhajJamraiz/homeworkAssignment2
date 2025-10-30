package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

// import java.io.BufferedWriter;
// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;
import java.io.*;
import org.junit.Test;


import exceptions.ResourceManagementDemo;

public class ResourceManagementDemoTest {
    ResourceManagementDemo demo = new ResourceManagementDemo();

    private static File tempFile;

    @Test
    public void testReadFirstLine() throws IOException{
         tempFile = File.createTempFile("testFile", ".txt");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))){
            writer.write("Hello World");
        }
        String result = demo.readFirstLine(tempFile.getAbsolutePath());
        tempFile.delete();
        assertEquals("Hello World", result);

    }

    @Test
    public void testFileNotFound(){
        String result = demo.readFirstLine("doesnotexist.txt");
        assertTrue(result.startsWith("Error reading file: "));
    }

    @Test
    public void testEmptyFile() throws IOException{
        File empty = File.createTempFile("empty", ".txt");
        String result = demo.readFirstLine(empty.getAbsolutePath());
        assertEquals("File is empty", result);
    }

    @Test
    public void testFileDeletedAfterUse() throws IOException{
        tempFile = File.createTempFile("testFile", ".txt");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))){
        writer.write("Hello World");
        tempFile.delete();
        }
        assertTrue(tempFile.exists());
    }

    @Test
    public void testTryWithResources() throws IOException{
        tempFile = File.createTempFile("testFile", ".txt");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))){
            writer.write("Hello World");
        }
        String result = demo.readFirstLine((tempFile.getAbsolutePath()));
        tempFile.delete();
        assertNotNull(result);
    }
}
