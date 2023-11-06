import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Map;
import java.io.File;

 public class Commands {

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

    public static String ls(String argument) {
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

    public static String print(String argument) {
        return argument;
    }

    public static String echo(String argument) {
        return argument;
    }
}