package info.date_4_20_21;

public class UnaryOperator {
    public static void main(String[] args) {
        int x = 10;
        System.out.println("x = " + x++); //x = 10
        System.out.println("x = " + x); //x = 11
        int y = 20;
        System.out.println("y = " + ++y); //y = 21
        System.out.println("y = " + y); //y = 21
    }
}
