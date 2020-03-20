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
        if(arg.equals(""))
            routes.objectInfo();
        else {
            try{
                long par = Long.parseLong(arg);
                routes.objectInfo(Long.parseLong(arg));
            }catch (InputMismatchException e){
                System.out.println("Вы ввели неверное значение в качестве аргумента");
            }catch (NumberFormatException e){
                System.out.println("Вы ввели неверное значение в качестве аргумента");
            }
        }
    }

}
