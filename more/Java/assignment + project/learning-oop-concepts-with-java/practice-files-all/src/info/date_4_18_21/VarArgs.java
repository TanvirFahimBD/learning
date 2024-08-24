package info.date_4_18_21;

public class VarArgs {
    public static void firstVar(int[] i) {
        System.out.println("0 index value: "+i[0]);
        System.out.println("1 index value: "+i[1]);
    }

    public static void main(String[] args) {
        firstVar(new int[]{10,30});
    }
}

//class SecondClass{
//    public static void main(String[] args) {
//        System.out.println("From Second Class");
//    }
//}

//    Doc Link - https://drive.google.com/drive/folders/1uT-pufKV1Yfro7aaxM5pOZ2ybNDWEHN7?usp=sharing

