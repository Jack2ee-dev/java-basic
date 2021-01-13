package java_basic.ch7_OOP2;

public class CastingTest2 {

    public static void main(String[] args) {
        Car car = new Car();
        Car car2 = null;
        FireEngine fe = null;

        car.drive();
        fe = (FireEngine) car;
        // ClassCastException 발생 -> car는 Car의 인스턴스이므로 자손 클래스 참조변수로 부모 인스턴스를 참조할 수 없다.
        // 첫 번째 줄을 Car car = new FireEngin()으로 변경하면 정상적으로 작동함
        fe.drive();
        car2 = fe; // car2 = (Car)fe;
        car2.drive();
    }
}
