package java_basic.ch7_OOP2;

public class CastingTest1 {

    public static void main(String[] args) {
        Car car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;

        fe.water();
        car = fe; // Car car = new FireEngine()과 같은 효과 -> 다형성
        fe2 = (FireEngine) car; // downcasting
        fe2.water();
    }
}

class Car {

    String color;
    int door;

    void drive() {
        System.out.println("drive, Brrrr~");
    }

    void stop() {
        System.out.println("stop!!!");
    }
}

class FireEngine extends Car {

    void water() {
        System.out.println("water!!!");
    }
}
