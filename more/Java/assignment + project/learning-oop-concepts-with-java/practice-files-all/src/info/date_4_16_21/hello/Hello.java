package info.date_4_16_21.hello;

class Hello {
    public static void main(String args[]){
        System.out.println("Hello");
    }
}

class World {
    public static void main(String[] args){
        System.out.println("World!");
    }
}

class Test {
    public static void main(String... args){
        System.out.println("args[0] "+args[0]);
        System.out.println("args[1] "+args[1]);
        System.out.println("args[2] "+args[2]);
    }
}
// If you pass less args than which required then it will show ArrayIndexOutOfBoundsException


// Docs Link - https://drive.google.com/drive/folders/1bR3ZgQf-QX0Pe1rrSnqNBCtaD_dV4U6H?usp=sharing