package Commands.Specified;

import Collection.Routes;
import Commands.AbstractCommand;

import java.io.IOException;

public class Clear extends AbstractCommand {


    public Clear(Routes routes) {
        super(routes);
    }

    @Override
    public void execute(String arg) throws IOException {
        if(!arg.equals(""))
            System.out.println("Напоминание: данной команде не нужны аргументы.");
        routes.clear(); //Решил немного сэкономить места в коде
        routes.saveTemp();
    }

}
