package info.date_4_16_21.varargs;

public class AddDemo {
    void add(int ... num){
        int sum = 0;
        for (int x : num){
            sum += x;
        }
        System.out.println(sum);
    }
}
