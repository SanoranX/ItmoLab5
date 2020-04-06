package Commands.Specified;

import Collection.Route;
import Collection.Routes;
import Commands.AbstractCommand;
import java.io.IOException;
import java.util.InputMismatchException;

public class RemoveById extends AbstractCommand {

    public RemoveById(Routes route) {
        super(route);
    }

    @Override
    public void execute(String arg) {
        if(arg.equals(""))
            System.out.println("Вы не ввели аргумент.");
        try {
            routes.removeRoute(Long.parseLong(arg));
        }catch (InputMismatchException e){
            System.out.println("Вы ввели неверное значение в качестве аргумента");
        }catch (NumberFormatException e){
            System.out.println("Вы ввели неверное значение в качестве аргумента");
        }
    }
}
