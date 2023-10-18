import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Map;

public class Cli {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String command;

        while (!(command = scanner.nextLine()).equals("exit") && !command.equals("logout")) {
            String output = "";
            String[] commandArg = command.trim().split(" ", 2);

            switch (commandArg[0]) {
                case "date":
                    LocalDate currentDate = LocalDate.now();
                    output = currentDate.toString();
                    break;
                case "time":
                    LocalTime currentTime = LocalTime.now();
                    output = currentTime.toString();
                    break;
                case "datetime":
                    LocalDateTime currentDateTime = LocalDateTime.now();
                    output = currentDateTime.toString();
                    break;
                case "useraccount":
                    output = System.getProperty("user.name");
                    break;
                case "userhome":
                    output = System.getProperty("user.home");
                    break;
                case "os":
                    output = System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")";
                    break;
                case "printenv":
                    if (commandArg.length > 1) {
                        String envValue = System.getenv(commandArg[1]);
                        if (envValue != null) {
                            output = envValue;

                        }
                    } else {
                        // Print all environment variables.
                        Map < String, String > env = System.getenv();
                        for (String envName: env.keySet()) {
                            output += envName + "=" + env.get(envName) + "\n";
                        }
                    }

                    break;

                case "print":
                case "echo":
                    if (commandArg.length > 1) {
                        output = commandArg[1];
                    }
                    break;
                default:
                    output = "Command '" + commandArg[0] + "' not found";
                    break;
            }

            System.out.println(output);
            System.out.print("> ");
        }

        scanner.close();
    }
}