package info.date_4_27_21.static_test.method.method2;

public class StaticMethodDemo {

    static int x = 10;

    static void display1(){
//        display2();
        System.out.println("I am non Static Method");
    }

    static void display2(){
        System.out.println("X = " + x);
        System.out.println("I am Static Method");
        display1();
    }


}
