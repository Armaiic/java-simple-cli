import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Cli {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String command;

        while (!(command = scanner.nextLine()).equals("exit")) {
            String output = "";
             command = command.trim();

            if (command.equals("date")) {
                LocalDate now = LocalDate.now();
                output = now.toString();
            } else if (command.equals("time")) {
                LocalTime now = LocalTime.now();
                output = now.toString();
            } else if (command.equals("datetime")) {
                LocalDateTime now = LocalDateTime.now();
                output = now.toString();
            } else if (command.equals("useraccount")) {
                output = System.getProperty("user.name");
            } else if (command.equals("userhome")) {
                output = System.getProperty("user.home");
            } else if (command.equals("os")) {
                output = System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")";
            } else if (command.startsWith("printenv")) {
                String varName = command.substring(8); // "printenv".length()
                varName = varName.trim(); // Remove leading and trailing spaces
                String envValue = System.getenv(varName);
                    if (envValue != null) {
                        output = envValue;
                    } else {
                output = "Command '" + command + "' not found";
            }

                }
             else if (command.indexOf(" ") > 3) {
                String arguments = command.substring(4); // "echo".length()
                arguments = arguments.trim(); // Remove leading and trailing spaces
                output = arguments;
            } else {
                output = "Command '" + command + "' not found";
            }

            System.out.println(output);
            System.out.print("> ");
        }

        scanner.close();
        System.out.println("Bye!");
    }
}