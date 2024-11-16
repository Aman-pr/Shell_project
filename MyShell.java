import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    // Store the current directory
    private static File currentDirectory = new File(System.getProperty("user.dir"));
    static String name="";

    public static void main(String[] args) {
        String command;

        // Loop to take commands from the user
        while (true) {
            System.out.print("MyShell "+ " > "); // Display current directory
            command = scanner.nextLine().trim();

            String[] tokens = command.split("\\s+");

            if (tokens[0].equals("exit")) {
                System.out.println("Exiting shell...");
                break;
            }

            // Handle 'cd' command
            if (tokens[0].equals("cd")) {
                if (tokens.length > 1) {
                    changeDirectory(tokens[1]);
                } else {
                    System.out.println(ANSI_RED + "cd: missing argument" + ANSI_RESET);
                }
            } else {
                // Handle external commands
                executeExternalCommand(tokens);
            }
        }

        scanner.close();
    }

    // Method to change the directory
    public static void changeDirectory(String path) {
        File dir = new File(currentDirectory, path); // Create a new File object based on the current directory

        if (dir.exists() && dir.isDirectory()) {
            currentDirectory = dir;  // Update current directory
            System.out.println("Changed to directory: "+currentDirectory.getParentFile());
        } else {
            // Directory doesn't exist or isn't valid
            System.out.println(ANSI_RED + "cd: No such directory: " + path + ANSI_RESET);
        }
    }


    // Execute external commands (like 'ls', 'pwd', or others)
    public static void executeExternalCommand(String[] tokens) {
        try {
            ProcessBuilder builder = new ProcessBuilder(tokens);
            builder.inheritIO();  // This allows the external process to inherit IO streams (so you can see output in your shell)
            builder.directory(currentDirectory);  // Set the working directory for the external command
            Process process = builder.start();
            process.waitFor();  // Wait for the process to finish
        } catch (IOException | InterruptedException e) {
            System.out.println(ANSI_RED + "Error executing command: " + e.getMessage() + ANSI_RESET);
        }
    }
}
