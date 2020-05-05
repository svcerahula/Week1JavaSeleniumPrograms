package LambdaExpressionsExamples;



public class LambdaExpressionExample2 {
    interface FuncType1 {
        int operation(int x, int y);
    }

    interface FuncInter2
    {
        void sayMessage(String message);
    }

    private int operate(int a , int b, FuncType1 obj1) {
        return obj1.operation(a,b);
    }
    public static void main(String args[]) {
        FuncType1 add = (int a, int b)->a + b;

        FuncType1 multiply = (int a, int b)-> a * b;

        LambdaExpressionExample2 obj1 = new LambdaExpressionExample2();

        System.out.println(obj1.operate(3,6,add));
        System.out.println(obj1.operate(3,6,multiply));

        FuncInter2 message = (String mesg) -> System.out.println("Message given is :"+mesg);

        message.sayMessage("Covid-19 is cured");
    }
}
