<h1 align="center">Java Shell Project</h1>

<p align="center">
  A custom shell implementation in Java that enables users to interact with the operating system through a command-line interface. This shell supports basic commands like <code>cd</code>, <code>exit</code>, and the execution of external system commands, leveraging Java's <code>ProcessBuilder</code> class.
</p>

---

<h2>🌟 Features</h2>

<ul>
  <li><b>Custom Shell Prompt:</b> Displays a dynamic shell prompt (<code>MyShell ></code>).</li>
  <li><b>Change Directory (<code>cd</code>):</b> Navigate between directories with error handling for invalid paths.</li>
  <li><b>Execute External Commands:</b> Run system commands like <code>ls</code>, <code>pwd</code>, etc.</li>
  <li><b>Exit Command:</b> Gracefully exit the shell with <code>exit</code>.</li>
  <li><b>Error Handling:</b> User-friendly error messages for invalid commands or execution failures.</li>
</ul>

---

<h2>⚙️ How It Works</h2>

<h3>1. Custom Shell Loop</h3>
<p>Continuously reads user input, parses commands and arguments, and executes built-in commands (<code>cd</code>, <code>exit</code>) or external commands.</p>

<h3>2. Command Execution with <code>ProcessBuilder</code></h3>
<ul>
  <li>Initializes a <code>ProcessBuilder</code> for the entered command and arguments.</li>
  <li>Sets the working directory for commands.</li>
  <li>Inherits IO streams for real-time output.</li>
</ul>

<h3>3. Changing Directories (<code>cd</code>)</h3>
<ul>
  <li>Updates the shell's working directory.</li>
  <li>Verifies if the provided directory is valid.</li>
  <li>Displays an error if the directory does not exist or is invalid.</li>
</ul>

---

<h2>🚀 Usage</h2>

<h3>Prerequisites</h3>
<ul>
  <li>JDK 8 or later</li>
  <li>Terminal or command prompt</li>
</ul>

<h3>Steps to Run</h3>
<ol>
  <li>Clone the repository:
    <pre><code>git clone &lt;https://github.com/Aman-pr/Shell_project.git&gt;</code></pre>
  </li>
  <li>Navigate to the project directory:
    <pre><code>cd &lt;project_directory&gt;</code></pre>
  </li>
  <li>Compile the program:
    <pre><code>javac Main.java</code></pre>
  </li>
  <li>Run the shell:
    <pre><code>java Main</code></pre>
  </li>
</ol>

<h3>Example Commands</h3>
<ul>
  <li>Navigate directories:
    <pre><code>MyShell > cd src</code></pre>
  </li>
  <li>List files:
    <pre><code>MyShell > ls</code></pre>
  </li>
  <li>Exit the shell:
    <pre><code>MyShell > exit</code></pre>
  </li>
</ul>

---

<h2>📜 Code</h2>

```java
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static File currentDirectory = new File(System.getProperty("user.dir"));

    public static void main(String[] args) {
        String command;

        while (true) {
            System.out.print("MyShell > ");
            command = scanner.nextLine().trim();

            String[] tokens = command.split("\\s+");

            if (tokens[0].equals("exit")) {
                System.out.println("Exiting shell...");
                break;
            }

            if (tokens[0].equals("cd")) {
                if (tokens.length > 1) {
                    changeDirectory(tokens[1]);
                } else {
                    System.out.println(ANSI_RED + "cd: missing argument" + ANSI_RESET);
                }
            } else {
                executeExternalCommand(tokens);
            }
        }
        scanner.close();
    }

    public static void changeDirectory(String path) {
        File dir = new File(currentDirectory, path);

        if (dir.exists() && dir.isDirectory()) {
            currentDirectory = dir;
            System.out.println("Changed to directory: " + currentDirectory.getAbsolutePath());
        } else {
            System.out.println(ANSI_RED + "cd: No such directory: " + path + ANSI_RESET);
        }
    }

    public static void executeExternalCommand(String[] tokens) {
        try {
            ProcessBuilder builder = new ProcessBuilder(tokens);
            builder.inheritIO();
            builder.directory(currentDirectory);

            Process process = builder.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println(ANSI_RED + "Error executing command: " + e.getMessage() + ANSI_RESET);
        }
    }
}
