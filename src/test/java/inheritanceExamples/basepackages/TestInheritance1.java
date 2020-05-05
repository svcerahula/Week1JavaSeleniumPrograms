package inheritanceExamples.basepackages;

class Entity {
    Entity() {
        System.out.println("In Entity class with no arg construcotr");
    }
    Entity(int a ) {
        System.out.println("In Entity class with int arg  constructor. integer a =" + a);
    }
}
class Person extends Entity {
    Person() {
        super(10);
        System.out.println("In Person Class no-argument constructor method");
    }


    public void display() {
        System.out.println("display method in Person class : "+ this.getClass().getCanonicalName());
    }
}

class Student extends Person {
    Student() {

       // super();
        System.out.println("Student class no-argument constructor method");
    }

}
public class TestInheritance1 {

    public static void main(String args[]) {
        Student s = new Student();
        s.display();
    }
}
