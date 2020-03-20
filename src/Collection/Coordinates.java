package Collection;

import java.util.Scanner;

public class Coordinates {

    Scanner scanner = new Scanner(System.in);
    private Double x; //Максимальное значение поля: 641, Поле не может быть null
    private Double y; //Значение поля должно быть больше -456, Поле не может быть null


    public Coordinates(int i){

    }
    public Coordinates(){
        System.out.println("Введите, пожалуйста, X: ");
        x = scanner.nextDouble();
        while (x > 641 || x.equals(null)) {
            System.out.println("Вы ввели неверное значение для поля х (Или null, или больше 641)");
            x = scanner.nextDouble();
        }
        System.out.println("Enter please Y: ");
        y = scanner.nextDouble();
        while(y < -456 || y.equals(null)){
            System.out.println("Вы ввели неверное значение для поля у (Или null, или меньше -456");
            y = scanner.nextDouble();
        }

    }

    public void setX(Double par) { x = par; }
    public Double getX() { return x; }

    public void setY(Double par) { y = par; }
    public Double getY(){ return y; }

    public Coordinates(Double argX, Double argY){
        x = argX;
        y = argY;
    }
}

