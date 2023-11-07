import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Map;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class Commands {
    
    public static String executeCommand(CommandLine cmdLine) {
        String commandName = cmdLine.getCommandName();

        if (commandName.equals("date")) {
            return date();
        } else if (commandName.equals("time")) {
            return time();
        } else if (commandName.equals("datetime")) {
            return datetime();
        } else if (commandName.equals("useraccount")) {
            return useraccount();
        } else if (commandName.equals("userhome")) {
            return userhome();
        } else if (commandName.equals("os")) {
            return os();
        } else if (commandName.equals("printenv")) {
            return printenv(cmdLine.getArgument());
        } else if (commandName.equals("ls")) {
            return ls(cmdLine);
        } else if (commandName.equals("print") || commandName.equals("echo")) {
            return echo(cmdLine.getArgument());
        } else if (commandName.equals("cat")) {
            return cat(cmdLine.getArgument());
        } else {
            return "Command '" + cmdLine.getCommandName() + "' not found";
        }
    }

    public static String date() {
        return LocalDate.now().toString();
    }

    public static String time() {
        return LocalTime.now().toString();
    }

    public static String datetime() {
        return LocalDateTime.now().toString();
    }

    public static String useraccount() {
        return System.getProperty("user.name");
    }

    public static String userhome() {
        return System.getProperty("user.home");
    }

    public static String os() {
        return System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")";
    }

    public static String printenv(String argument) {
        if (argument != null) {
            return System.getenv(argument);
        } else {
            Map<String, String> env = System.getenv();
            StringBuilder outputBuilder = new StringBuilder();
            for (String envName : env.keySet()) {
                outputBuilder.append(envName).append("=").append(env.get(envName)).append(System.lineSeparator());
            }
            return outputBuilder.toString();
        }
    }

    public static String ls(CommandLine cmdLine) {
        String argument = cmdLine.getArgument();
        if (argument != null) {
            String path = argument;
            File dir = new File(path);
            if (dir.isDirectory()) {
                File[] files = dir.listFiles();
                StringBuilder outputBuilder = new StringBuilder();
                for (File file : files) {
                    outputBuilder.append(file.getName()).append(System.lineSeparator());
                }
                return outputBuilder.toString();
            }
        }
        return "Not a directory";
    }

    public static String echo(String argument) {
        if (argument == null) {
        return ""; // Return an empty string
    } else {
        return argument;
    }
    }

    public static String cat(String path) {
        if (path == null || path.isEmpty()) {
            return "Please specify a path to a text file to read";
        }

        try {
            FileReader read1 = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(read1);

            StringBuilder outputBuilder = new StringBuilder();
            int lineNumberCounter = 1;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                outputBuilder.append(lineNumberCounter).append(". ").append(line).append("\n");
                lineNumberCounter++;
            }
            bufferedReader.close();

            return outputBuilder.toString();
        } catch (Exception e) {
            return "Error reading file";
        }
    }          
}
