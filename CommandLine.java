
public class CommandLine {
    private String commandName;
    private String argument;

    public CommandLine(String commandLine) {
        String[] commandArg = commandLine.trim().split(" ", 2);
        this.commandName = commandArg[0];
        if (commandArg.length > 1) {
            this.argument = commandArg[1];
        }
    }

    public String getCommandName() {
        return commandName;
    }

    public String getArgument() {
        return argument;
    }

    public boolean hasArgument() {
        return argument != null;
    }
}