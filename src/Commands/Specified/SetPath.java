package Commands.Specified;

import Collection.Routes;
import Commands.AbstractCommand;

import java.io.IOException;
import java.util.Scanner;

public class SetPath extends AbstractCommand {
    public SetPath(Routes routes) {
        super(routes);
    }

    @Override
    public void execute(String arg) throws IOException, NoSuchFieldException {
        if(arg.equals(""))
            System.out.println("Вы не ввели аргумент.");
        else{
            try {
                routes.setPath(arg);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
