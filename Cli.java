// Import statements.
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Map;
import java.io.File;

// Public class Cli.
public class Cli {

    // Main method.
    public static void main(String[] args) {
        // Create a Scanner object to read user input.
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a command.
        System.out.print("> ");

        // Read the user's command.
        String command;

        // Continue the loop until the user enters the "exit" or "logout" command.
        while (!(command = scanner.nextLine()).equals("exit") && !command.equals("logout")) {
            // Initialize the output variable.
            String output = "";

            // Split the command into an array of arguments.
            String[] commandArg = command.trim().split(" ", 2);

            // Replace the switch/case statement with if/else statements.
            if (commandArg[0].equals("date")) {
                // Get the current date.
                LocalDate currentDate = LocalDate.now();

                // Set the output to the current date.
                output = currentDate.toString();
            } else if (commandArg[0].equals("time")) {
                // Get the current time.
                LocalTime currentTime = LocalTime.now();

                // Set the output to the current time.
                output = currentTime.toString();
            } else if (commandArg[0].equals("datetime")) {
                // Get the current date and time.
                LocalDateTime currentDateTime = LocalDateTime.now();

                // Set the output to the current date and time.
                output = currentDateTime.toString();
            } else if (commandArg[0].equals("useraccount")) {
                // Get the current user account name.
                output = System.getProperty("user.name");
            } else if (commandArg[0].equals("userhome")) {
                // Get the current user's home directory.
                output = System.getProperty("user.home");
            } else if (commandArg[0].equals("os")) {
                // Get the current operating system name and version.
                output = System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")";
            } else if (commandArg[0].equals("printenv")) {
                // If the user specified an environment variable name, print its value.
                if (commandArg.length > 1) {
                    String envValue = System.getenv(commandArg[1]);
                    if (envValue != null) {
                        output = envValue;
                    }
                } else {
                    // Otherwise, print all environment variables.
                    Map<String, String> env = System.getenv();
                    for (String envName : env.keySet()) {
                        output += envName + "=" + env.get(envName) + System.lineSeparator();
                    }
                }
            } else if (commandArg[0].equals("ls")) {
                // If the user specified a directory path, list the files in that directory.
                if (commandArg.length > 1) {
                    String path = commandArg[1];
                    File dir = new File(path);
                    if (dir.isDirectory()) {
                        File[] files = dir.listFiles();
                        output = "";
                        for (File file : files) {
                            output += file.getName() + System.lineSeparator();
                        }
                    } else {
                        output = "Not a directory";
                    }
                } else {
                    output = "Not a directory";
                }
            } else if (commandArg[0].equals("print") || commandArg[0].equals("echo")) {
                // If the user specified a message, print it to the console.
                if (commandArg.length > 1) {
                    output = commandArg[1];
                }
            } else {
                // If the user entered an unknown command, print an error message.
                output = "Command '" + commandArg[0] + "' not found";
            }

            // Print the output to the console.
            System.out.println(output);

            // Prompt the user for the next command.
            System.out.print("> ");
        }

        // Close the Scanner object.
        scanner.close();

        // Print
        System.out.println("Bye!");
    }
}