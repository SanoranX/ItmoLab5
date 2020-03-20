package Commands.Specified;

import Collection.Routes;
import Commands.AbstractCommand;

import java.io.IOException;

public class About extends AbstractCommand {

    public About(Routes route){
        super(route);
    }

    @Override
    public void execute(String arg) throws IOException {
        if(!arg.equals(""))
            System.out.println("Напоминание: данной команде не нужны аргументы.");
        System.out.println("Developer: Ilya Rafailov\nWork: 1020\nDate: 20.03.2020");
    }
}
