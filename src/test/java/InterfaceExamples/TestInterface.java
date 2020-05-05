package InterfaceExamples;

class Bike implements Vehicle  {
    static int speed;
    static int gear;

    public void changeGear(int newGear) {
        gear = newGear;
    };
    public void incrementSpeed(int a) {
        speed = speed + a;
    }
    public void slowdownSpeed(int a) {
        speed = speed - a;
    }
    public void printSpeedGear() {
        System.out.println("speed ="+ speed + "gear = "+gear);
    }
}
public class TestInterface {

    public static void main(String args[]) {
        Bike bike = new Bike();
        bike.changeGear(2);bike.incrementSpeed(4);
        System.out.println("speed is : "+ Bike.speed);
        bike.slowdownSpeed(2);
        bike.printSpeedGear();
        System.out.println("speed is : "+ Bike.speed);
        bike.display();
    }
}
