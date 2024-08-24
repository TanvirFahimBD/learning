package info.date_4_27_21.static_test.variable.variable11;

public class Student {

    String name;
    int id;
    static String universityName = "NUBTK";

    Student(String n, int i){
        name  = n;
        id = i;
    }


    void displayInformation(){
        System.out.println("Name : " + name);
        System.out.println("ID : " + id);
        System.out.println("University Name : " + universityName);
        System.out.println();
    }


}
