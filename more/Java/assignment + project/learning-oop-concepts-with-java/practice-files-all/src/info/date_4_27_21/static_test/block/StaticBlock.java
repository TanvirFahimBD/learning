package info.date_4_27_21.static_test.block;

public class StaticBlock {

    static int id;
    static String name;

    static {
        id = 101;
        name = "Tanvir";
        System.out.println("Static Block");
    }

    static void display(){
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Main Method");
    }

    public static void main(String[] args) {
        StaticBlock.display();
    }

}

