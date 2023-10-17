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
             String [] commandArg = command.trim().split(" ",2);
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
                
                }else if (commandArg[0].equals("printenv")){
                    
                if (commandArg.length > 1)   {
                     String envalue = System.getenv(commandArg[1]);      
                 if (  envalue !=null) {
                      output = envalue ;
                    }
                }
           }else if (commandArg[0].equals("echo")) {
               if (commandArg.length > 1) {
              output = commandArg[1];
           }
           }else {
                    output = "Command '" + command + "' not found";
                }

                System.out.println(output);
                System.out.print("> ");
            }
            scanner.close();
        }
    }  