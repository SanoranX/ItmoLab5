/*
        Для того, чтобы в случае ошибки не добавлялись фантомные объекты, конструктор я добавил сюда

 */

package Commands.Specified;

import Collection.Route;
import Collection.Routes;
import Commands.AbstractCommand;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;

public class Add extends AbstractCommand {
    public Add(Routes routes){
        super(routes);
    }

    @Override
    public void execute(String arg) throws IOException {
        if(arg.equals(""))
            routes.add(new Route((long) (routes.size() + 1)));
        else{
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            Route route = gson.fromJson(arg, Route.class);
            if(routes.checkExistence(route.getId())){
                System.out.println("ID уже существует в коллекции, невозможно добавить");
            }
            else{
                routes.add(route);
            }
        }
    }
}
