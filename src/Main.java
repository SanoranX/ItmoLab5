import Collection.Route;
import Collection.Routes;
import Commands.AbstractCommand;
import Commands.Specified.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {

    public static String path = null;
    protected static ArrayList<AbstractCommand> commands = new ArrayList<>();
    private static int index;
    private static String input;
    private static Scanner scanner = new Scanner(System.in);
    protected LinkedHashSet<Route> routes = new LinkedHashSet<Route>();
    public static Main main = new Main();


    public static void main(String[] args) throws IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        try{
            path = args[0];
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Вы не ввели путь к коллекции при запуске, используем чистую коллекцию.");
            path = "";
        }

        main.start(path);
    }

    private static void start(String path) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException, IOException {
        Routes routes = new Routes(path);
        if(!path.equals(""))
            routes.read(path);

        AbstractCommand.setCommands(routes, "Выводит информацию об авторе", "about", About.class);
        AbstractCommand.setCommands(routes, "Выводит подсказку по всем командам", "help", Help.class);
        AbstractCommand.setCommands(routes, "Удаляет объект по его ID", "remove_by_id", RemoveById.class);
        AbstractCommand.setCommands(routes, "Позволяет добавлять новый элемент в коллекцию.", "add", Add.class);
        AbstractCommand.setCommands(routes, "Если нет аргумента, позволяет вывести информацию о всей коллекции. Если аргумент есть, то выводит информацию об объекте с айди равному аргументу", "show", Show.class);
        AbstractCommand.setCommands(routes, "Выводит информацию о коллекции.", "info", Info.class);
        AbstractCommand.setCommands(routes, "Завершает работу программы", "exit", Exit.class);
        AbstractCommand.setCommands(routes, "Очищает полностью коллекцию", "clear", Clear.class);
        AbstractCommand.setCommands(routes, "Удаляет все элементы коллекции больше ID которых больше, чем аргумент", "remove_greater", RemoveGreater.class);
        AbstractCommand.setCommands(routes, "Сохраняет всю коллекцию в csv файл.", "save", Save.class);
        AbstractCommand.setCommands(routes, "Выводит информацию о среднем значении Distance", "average_of_distance", AverageOfDistance.class);
        AbstractCommand.setCommands(routes, "Выводит кол-во объектов, Distance которых больше аргумента", "count_greater_than_distance", CountGreaterThanDistance.class);
        AbstractCommand.setCommands(routes, "Выводит последние 12 команд без их аргументов.", "history", History.class);
        AbstractCommand.setCommands(routes, "Выполняет скрипт, написанный пользователем. В качестве аргумента принимает абсолютный путь к файлу", "execute_script", ExecuteScript.class);
        AbstractCommand.setCommands(routes, "Устанавливает путь вручную.", "set_path", SetPath.class);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("# ");
            input = scanner.nextLine();
            //System.out.println(input.split(" ")[0]);
            try {
                input.toLowerCase(); //Для того, чтобы команда выполнялась в независимости от регистра ввода
                AbstractCommand cmd = AbstractCommand.getCommand(input.split(" ")[0]);
                cmd.execute(AbstractCommand.getArgument(input));
                AbstractCommand.history.addCommand(input.split(" ")[0]);
            } catch (NoSuchFieldException e) {
                System.out.println("Такой команды нет");
            }
        }

    }
}