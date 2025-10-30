package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ResourceManagementDemo {

    public String readFirstLine(String filePath){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            return line != null ? line : "File is empty";
        } catch (IOException e) {
            return "Error reading file: "+ e.getMessage();
        }
    }
}
