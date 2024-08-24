package info.date_4_27_21.wrapper_class_test;

public class WrapperDemo {
    public static void main(String[] args) {

        //primitive --> Object (Autoboxing Conversion)
//
//        int x = 30;
//        Integer y = Integer.valueOf(x);
//        System.out.println("Y = " + y);
//
//        Integer z = x;  // x == Integer.valueOf(x)
//        System.out.println("Z = " + z);

        //primitive --> Object (Unboxing Conversion)

        Double d = new Double(10.25);
        System.out.println("d = " + d);

        double e = d.doubleValue();
        System.out.println("e = " + e);

        double f = d;
        System.out.println("f = " + f);

    }
}
