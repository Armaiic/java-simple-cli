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
            String[] commandArg = command.trim().split(" ", 2);

            // Replace the switch/case statement with if/else statements.
            if (commandArg[0].equals("date")) {
                LocalDate currentDate = LocalDate.now();
                output = currentDate.toString();
            } else if (commandArg[0].equals("time")) {
                LocalTime currentTime = LocalTime.now();
                output = currentTime.toString();
            } else if (commandArg[0].equals("datetime")) {
                LocalDateTime currentDateTime = LocalDateTime.now();
                output = currentDateTime.toString();
            } else if (commandArg[0].equals("useraccount")) {
                output = System.getProperty("user.name");
            } else if (commandArg[0].equals("userhome")) {
                output = System.getProperty("user.home");
            } else if (commandArg[0].equals("os")) {
                StringBuilder outputBuilders = new StringBuilder();
               outputBuilders.append(System.getProperty("os.name")).append(" (").append(System.getProperty("os.version")).append(")");
               output = outputBuilders.toString();
            } else if (commandArg[0].equals("printenv")) {
                if (commandArg.length > 1) {
                    String envValue = System.getenv(commandArg[1]);
                    if (envValue != null) {
                        output = envValue;
                    }
                } else {
                    // Print all environment variables.
                    Map < String, String > env = System.getenv();
                    StringBuilder outputBuilder = new StringBuilder();
                    for (String envName: env.keySet()) {
                       outputBuilder.append(envName).append("=").append(env.get(envName)).append(System.lineSeparator());
                    }
                    output = outputBuilder.toString();
                }
            }else if (commandArg[0].equals("ls")) {
    output = "Not a directory";
if (commandArg.length > 1 ) {
        String path = commandArg[1];
        File dir = new File(path);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
                output = "";
                StringBuilder outputBuilder = new StringBuilder();
            for (File file : files) {
                outputBuilder.append(file.getName()).append(System.lineSeparator());
            }
            output =outputBuilder.toString();
        } 
    }
}else if (commandArg[0].equals("print") || commandArg[0].equals("echo")) {
                if (commandArg.length > 1) {
                    output = commandArg[1];
                }
            } else {
                output = "Command '" + commandArg[0] + "' not found";
            }

            System.out.println(output);
            System.out.print("> ");
        }

        scanner.close();
        System.out.println("Bye!");
    }
}