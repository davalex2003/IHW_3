package JSON;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Manager {
    public static void writeException(Exception exception) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("Exceptions.txt"), exception);
        } catch (IOException ex) {
            System.err.println("Unable to write exception message");
            ex.printStackTrace();
        }
    }

    public static void writeFatalError(Exception exception) {
        writeException(exception);
        System.err.println("Fatal error occurred");
        System.exit(1);
    }

    public static <T> T readFromFile(String fileName, Class<T> tClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            T data = objectMapper.readValue(ClassLoader.getSystemResourceAsStream(fileName), tClass);
            return data;
        } catch (DatabindException e) {
            System.err.println("Invalid file " + fileName + " format");
            e.printStackTrace();
            try {
                objectMapper.writeValue(new File("Exceptions.txt"),
                        new Exception("DatabindException", "Invalid file " + fileName + " format"));
            } catch (IOException ex) {
                System.err.println("Unable to write exception message");
                ex.printStackTrace();
            }
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Open file " + fileName + " exception");
            e.printStackTrace();
            try {
                objectMapper.writeValue(new File("Exceptions.txt"),
                        new Exception("DatabindException", "Open file " + fileName + " exception"));
            } catch (IOException ex) {
                System.err.println("Unable to write exception message");
                ex.printStackTrace();
            }
            System.exit(1);
        }
        return null;
    }
}
