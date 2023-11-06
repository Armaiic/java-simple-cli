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

            if (commandName.equals("date")) {
                output = Commands.date();
            } else if (commandName.equals("time")) {
                output = Commands.time();
            } else if (commandName.equals("datetime")) {
                output = Commands.datetime();
            } else if (commandName.equals("useraccount")) {
                output = Commands.useraccount();
            } else if (commandName.equals("userhome")) {
                output = Commands.userhome();
            } else if (commandName.equals("os")) {
                output = Commands.os();
            } else if (commandName.equals("printenv")) {
                output = Commands.printenv(cmdLine.getArgument());
            } else if (commandName.equals("ls")) {
                output = Commands.ls(cmdLine.getArgument());
            } else if (commandName.equals("print") || commandName.equals("echo")) {
                output = Commands.print(cmdLine.getArgument());
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