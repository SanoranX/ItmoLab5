package Commands.Specified;

import Collection.Routes;
import Commands.AbstractCommand;

import java.io.File;
import java.io.IOException;

public class Exit extends AbstractCommand {
    public Exit(Routes routes){
        super(routes);
    }

    @Override
    public void execute(String arg) throws IOException {
        if(!arg.equals(""))
            System.out.println("Напоминание: данной команде не нужны аргументы.");
        File file = new File(routes.TEMPPATH);
        file.delete();
        System.exit(0);
    }
}
