package java_basic.ch14_InputOutput;

import java.util.Date;

public class PrintStreamEx1 {

    public static void main(String[] args) {
        int i = 65;
        float f = 1234.56789f;

        Date date = new Date();

        System.out.printf("문자 %c의 코드는 %d\n", i, i);
        System.out.printf("%d는 8진수로 %o, 16진수로 %x\n", i, i, i);
        System.out.printf("%3d%3d%3d\n", 100, 90, 80);
        System.out.println();
        System.out.printf("123456789012345678901234567890\n");
    }
}
