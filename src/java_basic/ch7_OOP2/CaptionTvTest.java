package java_basic.ch7_OOP2;

class Tv {

    boolean power;
    int channel;

    void power() {
        this.power = !this.power;
    }

    void channelUp() {
        this.channel++;
    }

    void channelDown() {
        this.channel--;
    }
}

class CaptionTv extends Tv {

    boolean caption;

    void displayCaption(String text) {
        if (this.caption) {
            System.out.println(text);
        }
    }
}


public class CaptionTvTest {

    public static void main(String[] args) {
        CaptionTv ctv = new CaptionTv();
        ctv.channel = 10;
        ctv.channelUp();
        System.out.println(ctv.channel);
        ctv.displayCaption("Hello world");
        ctv.caption = true;
        ctv.displayCaption("Hello world2");
    }
}
