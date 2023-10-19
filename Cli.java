import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Map;
import java.io.File;

public class Cli {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String command;

        while (!(command = scanner.nextLine()).equals("exit") && !command.equals("logout")) {
            StringBuilder output = new StringBuilder();
            String[] commandArg = command.trim().split(" ", 2);

            // Replace the switch/case statement with if/else statements.
            if (commandArg[0].equals("date")) {
                LocalDate currentDate = LocalDate.now();
                output.append(currentDate.toString());
            } else if (commandArg[0].equals("time")) {
                LocalTime currentTime = LocalTime.now();
                output.append(currentTime.toString());
            } else if (commandArg[0].equals("datetime")) {
                LocalDateTime currentDateTime = LocalDateTime.now();
                output.append(currentDateTime.toString());
            } else if (commandArg[0].equals("useraccount")) {
                output.append(System.getProperty("user.name"));
            } else if (commandArg[0].equals("userhome")) {
                output.append(System.getProperty("user.home"));
            } else if (commandArg[0].equals("os")) {
                 output.append(System.getProperty("os.name")).append(" (").append(System.getProperty("os.version")).append(")");
            } else if (commandArg[0].equals("printenv")) {
                if (commandArg.length > 1) {
                    String envValue = System.getenv(commandArg[1]);
                    if (envValue != null) {
                        output.append(envValue);
                    }
                } else {
                    // Print all environment variables.
                    Map < String, String > env = System.getenv();
                    for (String envName: env.keySet()) {
                        output.append(envName).append("=").append(env.get(envName)).append(System.lineSeparator());
                    }
                }
            } else if (commandArg[0].equals("ls")) {
                output.append("Not a directory");
                if (commandArg.length > 1) {
                    String path = commandArg[1];
                    File dir = new File(path);
                    if (dir.isDirectory()) {
                        File[] files = dir.listFiles();
                        output.setLength(0);
                        for (File file: files) {
                            output.append(file.getName()).append(System.lineSeparator());
                        }
                    }
                }
            } else if (commandArg[0].equals("print") || commandArg[0].equals("echo")) {
                if (commandArg.length > 1) {
                    output.append(commandArg[1]);
                }
            } else {
                output.append("Command '").append(commandArg[0]).append("' not found");
            }

            System.out.println(output.toString());
            System.out.print("> ");
        }

        scanner.close();
        System.out.println("Bye!");
    }
}