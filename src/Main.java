import Collection.Route;
import Collection.Routes;
import Commands.AbstractCommand;
import Commands.Specified.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {

    public static String path = null;
    protected static ArrayList<AbstractCommand> commands = new ArrayList<>();
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

        AbstractCommand.setCommandsBeta("Выводит информацию об авторе", "about", new About(routes));
        AbstractCommand.setCommandsBeta("Выводит подсказку по всем командам", "help", new Help(routes));
        AbstractCommand.setCommandsBeta("Удаляет объект по его ID", "remove_by_id", new RemoveById(routes));
        AbstractCommand.setCommandsBeta("Позволяет добавлять новый элемент в коллекцию.", "add", new Add(routes));
        AbstractCommand.setCommandsBeta("Если нет аргумента, позволяет вывести информацию о всей коллекции. Если аргумент есть, то выводит информацию об объекте с айди равному аргументу", "show", new Show(routes));
        AbstractCommand.setCommandsBeta("Выводит информацию о коллекции.", "info", new Info(routes));
        AbstractCommand.setCommandsBeta("Завершает работу программы без сохранения коллекции", "exit", new Exit(routes));
        AbstractCommand.setCommandsBeta("Очищает полностью коллекцию", "clear", new Clear(routes));
        AbstractCommand.setCommandsBeta("Удаляет все элементы коллекции больше ID которых больше, чем аргумент", "remove_greater", new RemoveGreater(routes));
        AbstractCommand.setCommandsBeta("Сохраняет всю коллекцию в csv файл.", "save", new Save(routes));
        AbstractCommand.setCommandsBeta("Выводит информацию о среднем значении Distance", "average_of_distance", new AverageOfDistance(routes));
        AbstractCommand.setCommandsBeta("Выводит кол-во объектов, Distance которых больше аргумента", "count_greater_than_distance", new CountGreaterThanDistance(routes));
        AbstractCommand.setCommandsBeta("Выводит последние 12 команд без их аргументов.", "history", new History(routes));
        AbstractCommand.setCommandsBeta("Выполняет скрипт, написанный пользователем. В качестве аргумента принимает абсолютный путь к файлу", "execute_script", new ExecuteScript(routes));
        AbstractCommand.setCommandsBeta("Устанавливает путь вручную.", "set_path", new SetPath(routes));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("# ");
            input = scanner.nextLine();
            //System.out.println(input.split(" ")[0]);
            try {
                //input.toLowerCase(); //Для того, чтобы команда выполнялась в независимости от регистра ввода
                AbstractCommand cmd = AbstractCommand.getCommand(input.toLowerCase().split(" ")[0]);
                AbstractCommand.history.addCommand(input.split(" ")[0]);
                cmd.execute(AbstractCommand.getArgument(input));
            }
                 catch (NoSuchFieldException e) {
                System.out.println("Такой команды нет");
            }
        }

    }
}