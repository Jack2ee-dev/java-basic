package java_basic.ch7_OOP2;

public class BindingTest {

    public static void main(String[] args) {
        Parent p = new Child();
        Child c = new Child();
        /*
         멤버변수가 조상 클래스와 자손 클래스에 중복으로 정의된 경우,
         조상타입의 참조변수를 사용했을 때는 조상 클래스에 선언된 멤버변수가 사용되고,
         자손타입의 참조변수를 사용했을 때는 자손 클래스에 선언된 멤버변수가 사용된다.

         하지만, 중복 정의되지 않은 경우, 조상타입의 참조변수를 사용했을 때와 자손타입의 참조변수를 사용했을 때의 차이는 없다.
         중복된 경우는 참조변수의 타입에 따라 달라지지만, 중복되지 않은 경우 하나뿐이므로 선택의 여지가 없기 때문이다.

         메서드의 경우 참조변수의 타입에 관계없이 항상 실제 인스턴스의 타입에 정의된 메서드가 호출된다.
         */
        System.out.println("p.x = " + p.x);
        System.out.println("c.x = " + c.x);
    }
}
