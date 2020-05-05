package Collection;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Route {
    private Scanner scanner = new Scanner(System.in);
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически +
    private String name; //Поле не может быть null, Строка не может быть пустой +
    private Coordinates coordinates = new Coordinates(1); //Поле не может быть null +
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private LocationFrom from = new LocationFrom(1); //Поле не может быть null +
    private Float distance; //Поле не может быть null, Значение поля должно быть больше 1 +

    public Route(Long id) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        creationDate = LocalDateTime.now();
        System.out.println("Для этого объекта был автоматически присвоен id - " + id);
        this.id = id;
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
    }

    public Route(String creationTime, Long parID, String parName, Double parCoordinatesX, Double parCoordinatesY, Float parLocationX, Integer parLocationY, Long parLocationZ, Float parDestination) {
        this.creationDate = LocalDateTime.parse(creationTime);
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
        return creationDate.toString() + "," + id + "," + name + "," + coordinates.getX() + "," + coordinates.getY() + "," + from.getX() + "," + from.getY() + "," + from.getZ() + "," + distance + ",";
    }

}
