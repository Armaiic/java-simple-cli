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
            String output;

            CommandLine cmdLine = new CommandLine(command);
            String commandName = cmdLine.getCommandName();

            output = Commands.executeCommand(cmdLine);

            System.out.println(output);
            System.out.print("> ");
        }

        scanner.close();
        System.out.println("Bye!");
    }
}