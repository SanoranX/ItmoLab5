package Commands.Specified;

import Collection.Routes;
import Commands.AbstractCommand;

import java.io.IOException;
import java.util.InputMismatchException;

public class CountGreaterThanDistance extends AbstractCommand {
    public CountGreaterThanDistance(Routes routes) {
        super(routes);
    }

    @Override
    public void execute(String arg) throws IOException {
        if(arg.equals(""))
            System.out.println("Вы не ввели аргумент. Для этой команды вам нужно вводить аргумент");
        else {
            try {
                System.out.println("Кол-во элементов: " + routes.countGreaterThanDistance(Float.parseFloat(arg)));
            }catch (InputMismatchException e){
                System.out.println("Вы ввели неверное значение в качестве аргумента");
            }catch (NumberFormatException e){
                System.out.println("Вы ввели неверное значение в качестве аргумента");
            }
        }
    }
}
