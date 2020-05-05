package Commands.Specified;

import Collection.Routes;
import Commands.AbstractCommand;

import java.io.IOException;
import java.util.InputMismatchException;

public class Show extends AbstractCommand {

    public Show(Routes routes){
        super(routes);
    }

    @Override
    public void execute(String arg) throws IOException {
        if(routes.size() == 0){
            System.out.println("Коллекция пуста. Выводить нечего");
        }
        else{
            if(arg.equals("")) {
                routes.objectInfo();
            }
            else {
                try{
                    long par = Long.parseLong(arg);
                    if(routes.contains(par))
                        routes.objectInfo(Long.parseLong(arg));
                    else
                        System.out.println("Такого id в коллекции нет");
                }catch (InputMismatchException e){
                    System.out.println("Вы ввели неверное значение в качестве аргумента");
                }catch (NumberFormatException e){
                    System.out.println("Вы ввели неверное значение в качестве аргумента");
                }
            }
        }

    }

}
