package info.date_4_20_21;

public class RelationalOperator {
    public static void main(String[] args) {

//        Comparison Operator

//        String s = "10";
//
//        System.out.println(10<15); //true
//        System.out.println(10>15); //false
//        System.out.println(10>=15); //false
//        System.out.println(10<=15); //true
//        System.out.println(10>=10); //true

//        System.out.println(s instanceof String); //true
//        System.out.println(s instanceof Object); //true

//        Child1 c1 = new Child1();
//        Parent c2 = new Child1();
//        Parent c3 = new Child1();

//        System.out.println(c1 instanceof Parent); //true
//        System.out.println(c1 instanceof Child1); //true

//        Child3 rohim = new Child3();
//        Child2 korim = new Child3();
//
//        System.out.println(rohim instanceof Child3); //true
//        System.out.println(rohim instanceof Parent); //true
//        System.out.println(rohim instanceof Child2); //true
//
//        System.out.println(korim instanceof Child3); //true
//        System.out.println(korim instanceof Child2); //true
//        System.out.println(korim instanceof Parent); //true

//        Object i = 10;
//        System.out.println(i instanceof Integer);  //true
//        System.out.println(i instanceof Double);  //false


        //        Equality Operator

        System.out.println(10 == 10); //true
        System.out.println(10 == 15); //false
        System.out.println(10 != 15); //true

    }
}

interface Parent {

}

class Child1 implements Parent {

}

class Child2 implements Parent {

}

class Child3 extends Child2 {

}
