package Commands.Specified;

import Collection.Route;
import Collection.Routes;
import Commands.AbstractCommand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class RemoveGreater extends AbstractCommand {
    public RemoveGreater(Routes routes) {
        super(routes);
    }

    @Override
    public void execute(String arg) throws IOException {
        if (arg.equals(""))
            System.out.println("Вы не ввели аргумент. Для этой команды вам нужно вводить аргумент");
        else {
            try{
                routes.removeGreaterThanId(Long.parseLong(arg));
                routes.saveTemp();
            }catch (InputMismatchException e){
                System.out.println("Ошибка ввода");
            }catch(NumberFormatException e){
                System.out.println("Ошибка ввода");
            }
        }
    }
}
