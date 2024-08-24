package info.date_4_27_21.static_test.variable.variable13;public class Student {

    static int count = 0;

    Student(){
        count++;
    }

    void totalStudent(){
        System.out.println("Total: " + count);
    }

}
