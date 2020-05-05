class Demo {
    public void show(int x)
    {
        System.out.println("In int " + x);
    }
    public void show(String s)
    {
        System.out.println("In String " + s);
    }
    public void show(byte b)
    {
        System.out.println("In byte " + b);
    }
    public void show(long d) {
        System.out.println("In double " + d);
    }

    public int  sum(int x , int y) {
        System.out.println("in int return type sum() method");
        return x+y;
    }

    public double sum(double x, double y) {
        System.out.println("in double return type sum() method");
        return x+y;
    }
}

public class MethodOverload1 {
    public static void main(String[] args)
    {
        byte a = 25;
        Demo obj = new Demo();
        obj.show(a); // it will go to
        // byte argument
        obj.show("hello"); // String
        obj.show(250); // Int
        obj.show('A'); // Since char is
        // not available, so the datatype
        // higher than char in terms of
        // range is int.
        obj.show("A"); // String
        //obj.show(7.5); // since float datatype
// is not available and so it's higher
// datatype, so at this step their
// will be an error.
        double sumvalue = obj.sum(13.2,34.532);
        System.out.println(sumvalue);
    }
}
