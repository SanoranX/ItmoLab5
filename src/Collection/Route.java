package Collection;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Route {
    private Scanner scanner = new Scanner(System.in);
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически +
    private String name; //Поле не может быть null, Строка не может быть пустой +
    private Coordinates coordinates = new Coordinates(1); //Поле не может быть null +
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private LocationFrom from = new LocationFrom(1); //Поле не может быть null +
    //private Location to; //Поле может быть null
    private Float distance; //Поле не может быть null, Значение поля должно быть больше 1 +

    public Route(Long par) {
        try {
            System.out.println("Для этого объекта был автоматически присвоен id - " + par);
            id = par;
            //Name
            System.out.println("Введите название дороги");
            name = scanner.nextLine();
            while (name.equals(null) || name.equals("")) {
                System.out.println("Значение не может быть null или пустым, попробуйте ещё раз");
                name = scanner.nextLine();
            }
            //Distance
            System.out.println("Enter distance");
            distance = scanner.nextFloat();
            while (distance.equals(null) || distance < 1) {
                if (distance.equals(null))
                    System.out.println("Вы ввели значение null");
                else if (distance < 1)
                    System.out.println("Вы ввели значение меньше 1");
                distance = scanner.nextFloat();
            }
            //Coordinates
            coordinates = new Coordinates();
            //Location (from)
            from = new LocationFrom();
            System.out.println("Ready");
        } catch (InputMismatchException e) {
            System.out.println("Вы осуществили неправильный ввод, тем самым остановив программу. Требуемый тип ввода всегда написан перед вводом.");
            //routes.removeById(routes.size());
        } catch (Exception e) {
            System.out.println("Произошла ошибка. Возможно, вы ввели не тот тип данных. Так же возможно, что вы вышли за пределы переменных.");
            //routes.removeById(routes.size());
        }
    }

    public Route(Long parID, String parName, Double parCoordinatesX, Double parCoordinatesY, Float parLocationX, Integer parLocationY, Long parLocationZ, Float parDestination) {
        id = parID;
        name = parName;
        coordinates.setX(parCoordinatesX);
        coordinates.setY(parCoordinatesY);
        from.setX(parLocationX);
        from.setY(parLocationY);
        from.setZ(parLocationZ);
        distance = parDestination;
    }

    public Long getId() {
        return id;
    }

    public Float getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Название дороги: " + name + "\nID дороги: " + id + "\nDistance " + distance + "\nВремя создания объекта коллекции " + creationDate + "\nCoordinates X: " + coordinates.getX() + "\nCoordinates Y: " + coordinates.getY() + "\nLocation X: " + from.getX() + "\nLocation Y: " + from.getY() + "\nLocation Z " + from.getZ();
    }
    
    public String getCSV() {
        return id + "," + name + "," + coordinates.getX() + "," + coordinates.getY() + "," + from.getX() + "," + from.getY() + "," + from.getZ() + "," + distance + ",";
    }

}