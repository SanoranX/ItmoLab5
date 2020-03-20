package Commands.Specified;

import Collection.Route;
import Collection.Routes;
import Commands.AbstractCommand;

import java.io.IOException;

public class Help extends AbstractCommand {

    public Help(Routes route){
        super(route);
    }

    @Override
    public void execute(String arg) throws IOException {
        if(!arg.equals(""))
            System.out.println("Напоминание: данной команде не нужны аргументы.");
        for(AbstractCommand command : commands){
            System.out.println(command.syntax + " - " + command.helpText);
        }
    }
}
