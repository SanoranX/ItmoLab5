/*
        Для того, чтобы в случае ошибки не добавлялись фантомные объекты, конструктор я добавил сюда

 */

package Commands.Specified;

import Collection.Route;
import Collection.Routes;
import Commands.AbstractCommand;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;

public class Add extends AbstractCommand {
    public Add(Routes routes){
        super(routes);
    }

    @Override
    public void execute(String arg) throws IOException {
        if(arg.equals("")) {
            routes.addWithCheck(routes.size() + 1);
            routes.saveTemp();
        }
        /*else{
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            Route route = gson.fromJson(arg, Route.class);
            if(routes.checkExistence(route.getId())){
                System.out.println("ID уже существует в коллекции, невозможно добавить");
            }
            else{
                routes.add(route);
            }
        } */
    }
}
