package Commands.Specified;

import Collection.Route;
import Collection.Routes;
import Commands.AbstractCommand;

import java.io.IOException;
import java.util.InputMismatchException;

public class UpdateId extends AbstractCommand {
    public UpdateId(Routes routes) {
        super(routes);
    }

    @Override
    public void execute(String arg) throws IOException {
        if(arg.equals(""))
            System.out.println("Вы не ввели аргумент. Для этой команды вам нужно вводить аргумент");
        else {
            try {
                routes.removeRoute(Long.parseLong(arg));
                routes.addWithCheck(routes.size()+1);
            }catch (InputMismatchException e){
                System.out.println("Вы ввели неверное значение в качестве аргумента");
            }catch (NumberFormatException e){
                System.out.println("Вы ввели неверное значение в качестве аргумента");
            }
        }
    }
}
