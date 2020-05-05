package LambdaExpressionsExamples;


//functional interface contains at the most only one abstract method
@FunctionalInterface
interface Square {
    int calculate(int x);
}
public class LambdaExpExampleTest1 {
    public static void main(String args[]) {
         int a = 5;
        Square s = (int w) -> (w * w);
        int ans = s.calculate(a);
        System.out.println(ans);
    }
}
