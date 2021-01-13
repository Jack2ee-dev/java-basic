package java_basic.ch11_CollectionFrameworks;

import java.util.Stack;

public class StackEx1 {

    public static Stack back = new Stack();
    public static Stack forward = new Stack();

    public static void main(String[] args) {
        goURL("1. 네이트");
        goURL("2. 네이버");
        goURL("3. 다음");

        printStatus();

        goBack();
        System.out.println("= 뒤로가기 버튼을 누른 후 =");
        printStatus();

        goBack();
        System.out.println("= 뒤로가기 버튼을 누른 후 =");
        printStatus();

        goForward();
        System.out.println("= 앞으로 가기 버튼을 누른 수 =");
        printStatus();

        goURL("javachobo.com");
        System.out.println("= 새로운 주소로 이동 후 =");
        printStatus();
    }

    public static void printStatus() {
        System.out.println("back:" + back);
        System.out.println("forward:" + forward);
        System.out.println("현재 화면은 " + back.peek() + "입니다.");
        System.out.println();
    }

    public static void goURL(String url) {
        back.push(url);
        if (!forward.isEmpty()) {
            forward.clear();
        }
    }

    public static void goForward() {
        if (!forward.isEmpty()) {
            back.push(forward.pop());
        }
    }

    public static void goBack() {
        if (!back.isEmpty()) {
            forward.push(back.pop());
        }
    }
}
