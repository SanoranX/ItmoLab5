package Commands.Specified;

import Collection.Routes;
import Commands.AbstractCommand;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExecuteScript extends AbstractCommand {
    public ExecuteScript(Routes routes) {
        super(routes);
    }

    @Override
    public void execute(String arg) throws IOException, NoSuchFieldException {
        if (arg.equals(""))
            System.out.println("Вы не ввели путь к скрипту. Команда не выполнилась");
        else {
            File file = new File(arg);
            if (!file.exists()) System.out.println("Файла не существует");
            else if (file.exists() && !file.canRead()) System.out.println("Файл существует, нет прав на чтение.");
            else if (file.exists() && !file.canExecute()) System.out.println("Проверьте файл на выполнение");
            else {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    List<String> collection = Arrays.asList(line.split(" "));
                    if (collection.get(0).equals("execute_script")) {
                        if (!routes.isEmpty()) {
                            AbstractCommand cmd = AbstractCommand.getCommand(AbstractCommand.parseCommand(collection.get(0)));
                            cmd.execute(collection.get(1));
                        } else System.err.println("Рекурсия прервалась");
                    } else {
                        AbstractCommand cmd = AbstractCommand.getCommand(AbstractCommand.parseCommand(line));
                        String argum = AbstractCommand.parseArg(line);
                        cmd.execute(argum);
                    }

                }
            }
        }
    }
}
