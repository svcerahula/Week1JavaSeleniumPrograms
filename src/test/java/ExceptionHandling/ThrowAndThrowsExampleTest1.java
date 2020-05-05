package ExceptionHandling;

public class ThrowAndThrowsExampleTest1 {

    public static void fun() throws ArithmeticException {
        System.out.println("Inside fun() method");
        throw new ArithmeticException();
    }

    public static void main(String args[]) {
        try {
            int i = 1/0;
            ThrowAndThrowsExampleTest1.fun();
        } catch (ArithmeticException ex) {
            System.out.println("exception handling done using throw and throws caught here : "+ ex.getMessage());
        }
    }
}
