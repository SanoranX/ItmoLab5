package Commands;

import Collection.Routes;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public abstract class AbstractCommand {

    private static boolean DEBUG = true;

    public static History history = new History();
    protected static ArrayList<AbstractCommand> commands = new ArrayList<>();
    public String helpText;
    public String syntax; //Сама команда, во время выполнения главного цикла в Main мы ищем такую команду среди всех команд.
    //TODO: JavaDoc
    protected Routes routes;
    public AbstractCommand(Routes routes) {
        this.routes = routes;
    }

    public static AbstractCommand getCommand(String name) throws NoSuchFieldException{
        for (AbstractCommand command : commands) {
            if (command.syntax.equals(name))
                return command;
        }
        throw new NoSuchFieldException("Такой команды нет");
    }

    public static void setCommands(Routes routes, String helpText, String syntax, Class<? extends AbstractCommand> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        AbstractCommand command = clazz.getConstructor(Routes.class).newInstance(routes);
        command.helpText = helpText;
        command.syntax = syntax;
        command.routes = routes;
        if(DEBUG)
            System.out.println("[DEBUG] Команда " + syntax + " была успешно инициализирована");
        commands.add(command);
    }

    /**
     * Возвращает аргументы команды, что ввёл пользователь
     *
     * @param source строка, которая содержит параметры команды
     * @return параметры команды
     */

    public static String getArgument(String source) {
        try {
            return source.split(" ")[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
    }

    /**
     * Возвращает команду
     *
     * @param command Команда, которую мы пытаемся найти
     * @return Команда
     */
    public static String parseCommand(String command) {
        return command.split(" ")[0];
    }

    public static String parseArg(String command) {
        try {
            return command.split(" ")[1];
        }catch (ArrayIndexOutOfBoundsException e){
            return "";
        }
    }

    /**
     * Абстрактный метод исполнения команды
     *
     * @param arg Аргументы команды
     *
     */
    public abstract void execute(String arg) throws IOException, NoSuchFieldException;

    @Override
    public String toString() {
        return "[" + syntax + "] " + helpText;
    }
}
