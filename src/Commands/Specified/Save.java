package Commands.Specified;

import Collection.Routes;
import Commands.AbstractCommand;

import java.io.IOException;

public class Save extends AbstractCommand {
    public Save(Routes routes) {
        super(routes);
    }

    @Override
    public void execute(String arg) throws IOException {
        routes.save();
    }
}
