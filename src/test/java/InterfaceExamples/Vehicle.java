package InterfaceExamples;

public interface Vehicle {

    void changeGear(int a);
    void incrementSpeed(int a);
    void slowdownSpeed(int a);

    default void display() {
        System.out.println("display name : Rahula");
    }
}
