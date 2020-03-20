package Collection;

import java.util.Scanner;
import java.util.zip.ZipEntry;

public class LocationFrom {
    Scanner scanner = new Scanner(System.in);
    private Float x; //Поле не может быть null
    private Integer y; //Поле не может быть null
    private Long z; //Поле не может быть null


    public LocationFrom(int i){

    }
    public LocationFrom(Float argX, Integer argY, Long argZ) {
        x = argX;
        y = argY;
        z = argZ;
    }

    public LocationFrom() {
        System.out.println("Введите координату X");
        x = scanner.nextFloat();

        while (x.equals(null)) {
            System.out.println("Поле х не может быть null");
            x = scanner.nextFloat();
        }

        System.out.println("Введите координату Y");
        y = scanner.nextInt();

        while (y.equals(null)) {
            System.out.println("Поле y не может быть null");
            y = scanner.nextInt();
        }

        System.out.println("Введите координату Z");
        z = scanner.nextLong();

        while (z.equals(null)) {
            System.out.println("Поле z не может быть null");
            z = scanner.nextLong();
        }
    }

    public Float getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Long getZ() {
        return z;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setZ(Long z) {
        this.z = z;
    }

}
