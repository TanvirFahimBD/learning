package info.date_4_27_21.enum_test;

// for static
//interface MobileCompany{
//    static String APPLE = "Apple";
//    static String SAMSUNG = "Samsung";
//}
//
//public class EnumExample {
//    public static void main(String[] args)
//    {
//        if(MobileCompany.APPLE == 1) //Show errow if you don't know the type
//        {
//
//        }
//
//    }
//}


// for enum

//enum outside the class
//enum Mobile
//{
//    APPLE, SAMSUNG, HTC; //semicolon is optional here
//}

public class EnumExample {
    //enum inside the class
    enum Mobile
    {
        APPLE, SAMSUNG, HTC; //semicolon is optional here
    }
    public static void main(String[] args)
    {
        System.out.println(Mobile.SAMSUNG);
    }
}
