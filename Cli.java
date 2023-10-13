import java.util.Scanner;
import java.util.Calendar;

public class Cli {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //listen to the standard input (console)
        System.out.print("> "); //Prompt start
        String command; // initalise the string command before use it 
        while (!(command = scanner.nextLine()).equals("exit")) {  // infinit loop if the output isn't exit
            String output = ""; // Initialize output // 
              //if users enter the command date , give the date with format 
            if (command.equals("date")) {
                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH) + 1;
                int day = now.get(Calendar.DAY_OF_MONTH);
                output = year + "-" + (month < 10 ? "0" : "") + month + "-" + (day < 10 ? "0" : "") + day;
            } 
			// if users enter command time , give the time at this moment of command is execute
            else if (command.equals("time")) {
                Calendar now = Calendar.getInstance();
                int hour = now.get(Calendar.HOUR_OF_DAY);
                int minute = now.get(Calendar.MINUTE);
                int second = now.get(Calendar.SECOND);
                output = "L'heure actuelle est " + hour + ":" + minute + ":" + second + " !";
            }  
			//same but with date addition
            else if (command.equals("datetime")) {
                Calendar now = Calendar.getInstance();
                output = now.getTime().toString();
            }
			//give the name of the users connected to actual session
            else if (command.equals("useraccount")) {
                output = System.getProperty("user.name");
            } 
			//give the root path of the user 
            else if (command.equals("userhome")) {
                output = System.getProperty("user.home");
            } // give the os name and this actual version
            else if (command.equals("os")) {
                output = System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")";
            }
			//give the environnement variable add in arg  if is  present in system 
            else if (command.startsWith("printenv ")) {
                // Extract the environment variable name from the command
                String varName = command.substring(9); // "printenv ".length()
                String envValue = System.getenv(varName);
                if (envValue != null) {
                    output = envValue;
                }
                // If the variable doesn't exist, the output will remain an empty string.
            } 
			//display the argument give by the user after the command "echo"
            else if (command.startsWith("echo ")) {
                // Extract the arguments from the echo command
                String arguments = command.substring(5); // "echo ".length()
                output = arguments;
            }
            else {
                output = "Command '" + command + "' not found.";
            }

            System.out.println(output);
            System.out.print("> ");
        }

        scanner.close();
        System.out.println("Bye!");
    }
}