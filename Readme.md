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
    <pre><code>javac MyShell.java or java MyShell.java</code></pre>
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
