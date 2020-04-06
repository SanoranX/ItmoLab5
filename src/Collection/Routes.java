package Collection;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Routes extends LinkedHashSet<Route> {

    private String path;

    public Routes(String path) {
        this.path = path;
    }

    public void addWithCheck(long id){
        int sizeBefore = size();
        try{
            add(new Route(id));
        }catch (InputMismatchException e){
            System.out.println("Вы ввели значение с ошибкой!");
            if(sizeBefore < size())
                remove(size());
        }catch (Exception e){
            System.out.println("Вы ввели значение с ошибкой!");
            if(sizeBefore < size())
                remove(size());
        }
    }
    public void update(long id) {
        for (Route route : this) {
            if (route.getId().equals(id)) {
                remove(route);
                add(new Route(id));
            }
        }
    }

    public void objectInfo() {
        for (Route route : this) {
            System.out.println(route.toString());
        }
    }

    public void objectInfo(long id) {
        for (Route route : this) {
            if (route.getId().equals(id)) {
                System.out.printf(route.toString());
                break;
            }

        }
    }

    /**
     * Возвращает аргументы команды, что ввёл пользователь
     *
     * @param arg Аргумент. Вводит пользователь
     * @return Кол-во объектов, поле Distance которых больше аргумента
     */

    public Long countGreaterThanDistance(Float arg) {
        long count = 0;
        for (Route route : this) {
            if (route.getDistance() > arg)
                count++;
        }
        return count;
    }

    /**
     * Возвращает аргументы команды, что ввёл пользователь
     *
     * @return Возвзращает среднее значение поля Distance
     */

    public float averageOfDistance() {
        Float distanceSum = 0.0f;
        long count = 0;
        for (Route route : this) {
            distanceSum = distanceSum + route.getDistance();
            count++;
        }
        return distanceSum / count;
    }

    public void info() {
        System.out.println("Тип коллекции: Routes" + " Кол-во элементов: " + size());
    }

    public void removeGreater(long id) {
        long count = 0;
        for (Route route : this) {
            if (route.getId() > id) {
                remove(route);
                count++;
            }
        }
        System.out.println("Всего было удалено: " + count + " элементов");
    }

    public void removeRoute(long id) {
        Route[] array = this.toArray(new Route[0]);
        List<Route> list = new ArrayList<>(Arrays.asList(array));

        for (Route p : list) {
            if (p.getId() == id) {
                list.remove(p);
                this.clear();
                this.addAll(list);
                return;
            }
        }
    }

    public void removeGreaterThanId(long id) {
        Route[] array = this.toArray(new Route[0]);
        List<Route> list = new ArrayList<>(Arrays.asList(array));

        for (Route p : list) {
            if (p.getId() > id) {
                removeRoute(p.getId());
            }
        }
    }

    public void updateById(long id) {
        for (Route route : this) {
            if (route.getId().equals(id)) {
                remove(route);
                add(new Route(id));
            }
        }
    }

    /**
     * Сохраняет коллекцию в файл. Используется File, FileWriter, BufferedWriter
     */

    public void save() {

        if (!path.equals("")) {
            try {
                File file = new File(path);
                if (!file.exists()) System.out.println("Файл не был обнаружен, создаём новый");
                if (file.exists() && !file.canWrite())
                    System.out.println("Файл был обнаружен, но мы не можем в него записывать");
                else {
                    FileWriter fileWriter = new FileWriter(file); // поток, который подключается к текстовому файлу
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); // соединяем FileWriter
                    for (Route route : this) {
                        bufferedWriter.write(route.getCSV());
                    }
                    bufferedWriter.close();
                }
            } catch (FileNotFoundException e) {
                System.out.println("Ошибка работы с файлом. Файл не найден");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Вы не указали путь в аргументах. Для того, чтобы назначить путь самим введите команду set_path {path}");
        }
    }

    public void read(String path) {
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(",");
            if(!file.exists()) System.out.println("Файл не существует.");
            if(!file.canRead()) System.out.println("Невозможно начать чтение из файла");
            else{
                while (scanner.hasNext()) {
                    add(new Route(
                            scanner.next(),
                            Long.parseLong(scanner.next()),
                            scanner.next(),
                            Double.parseDouble(scanner.next()),
                            Double.parseDouble(scanner.next()),
                            Float.parseFloat(scanner.next()),
                            Integer.parseInt(scanner.next()),
                            Long.parseLong(scanner.next()),
                            Float.parseFloat(scanner.next())
                    ));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found, please fix it in source / arguments");
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            System.out.println("Ошибка в синтаксисе файла");
        }
    }

    /**
     * Проверяет существует ли объект в коллекции по его ID
     *
     * @param id ID, объекта которого мы проверяем на существование
     * @return true - если существует, false - если нет.
     */

    public boolean checkExistence(long id) {
        for (Route route : this) {
            if (route.getId().equals(id))
                return true;
        }
        return false;
    }

    public void setPath(String pathName){
        path = pathName;
    }
}
