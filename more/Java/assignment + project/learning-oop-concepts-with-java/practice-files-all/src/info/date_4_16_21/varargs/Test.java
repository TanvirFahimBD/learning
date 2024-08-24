package info.date_4_16_21.varargs;

public class Test {
    public static void main(String[] args) {
        AddDemo ob = new AddDemo();
        ob.add(10, 20);
        ob.add(10, 20, 30);
        ob.add(10, 20, 30, 40);
    }
}

//        res -->
//        30
//        60
//        100