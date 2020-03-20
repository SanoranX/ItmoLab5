package Commands.Specified;

import Collection.Routes;
import Commands.AbstractCommand;

import java.io.IOException;

public class AverageOfDistance extends AbstractCommand {

    public AverageOfDistance(Routes routes) {
        super(routes);
    }

    @Override
    public void execute(String arg) throws IOException {
        if(!arg.equals(""))
            System.out.println("Напоминание: данной команде не нужны аргументы.");
        System.out.println("average_of_distance " + routes.averageOfDistance());
    }
}
