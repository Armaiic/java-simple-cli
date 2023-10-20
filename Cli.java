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
            String output = "";

            CommandLine cmdLine = new CommandLine(command);

            if (cmdLine.getCommandName().equals("date")) {
                LocalDate currentDate = LocalDate.now();
                output = currentDate.toString();
            } else if (cmdLine.getCommandName().equals("time")) {
                LocalTime currentTime = LocalTime.now();
                output = currentTime.toString();
            } else if (cmdLine.getCommandName().equals("datetime")) {
                LocalDateTime currentDateTime = LocalDateTime.now();
                output = currentDateTime.toString();
            } else if (cmdLine.getCommandName().equals("useraccount")) {
                output = System.getProperty("user.name");
            } else if (cmdLine.getCommandName().equals("userhome")) {
                output = System.getProperty("user.home");
            } else if (cmdLine.getCommandName().equals("os")) {
                StringBuilder outputBuilders = new StringBuilder();
                outputBuilders.append(System.getProperty("os.name")).append(" (").append(System.getProperty("os.version")).append(")");
                output = outputBuilders.toString();
            } else if (cmdLine.getCommandName().equals("printenv")) {
                if (cmdLine.hasArgument()) {
                    String envValue = System.getenv(cmdLine.getArgument());
                    if (envValue != null) {
                        output = envValue;
                    }
                } else {
                    // Print all environment variables.
                    Map<String, String> env = System.getenv();
                    StringBuilder outputBuilder = new StringBuilder();
                    for (String envName : env.keySet()) {
                        outputBuilder.append(envName).append("=").append(env.get(envName)).append(System.lineSeparator());
                    }
                    output = outputBuilder.toString();
                }
            } else if (cmdLine.getCommandName().equals("ls")) {
                output = "Not a directory";
                if (cmdLine.hasArgument()) {
                    String path = cmdLine.getArgument();
                    File dir = new File(path);
                    if (dir.isDirectory()) {
                        File[] files = dir.listFiles();
                        output = "";
                        StringBuilder outputBuilder = new StringBuilder();
                        for (File file : files) {
                            outputBuilder.append(file.getName()).append(System.lineSeparator());
                        }
                        output = outputBuilder.toString();
                    }
                }
            } else if (cmdLine.getCommandName().equals("print") || cmdLine.getCommandName().equals("echo")) {
                if (cmdLine.hasArgument()) {
                    output = cmdLine.getArgument();
                }
            } else {
                output = "Command '" + cmdLine.getCommandName() + "' not found";
            }

            System.out.println(output);
            System.out.print("> ");
        }

        scanner.close();
        System.out.println("Bye!");
    }
}