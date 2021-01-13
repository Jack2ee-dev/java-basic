package java_basic.ch7_OOP2;

public class PolyArgumentTest {

    public static void main(String[] args) {
        Buyer b = new Buyer();
        Tv1 tv = new Tv1();
        Computer computer = new Computer();
        Audio audio = new Audio();

        b.buy(tv);
        b.buy(computer);
        b.buy(audio);
        b.summary();
    }
}

class Product {

    int price;
    int bonusPoint;

    Product(int price) {
        this.price = price;
        this.bonusPoint = (int) (price / 10.0);
    }
}

class Tv1 extends Product {

    Tv1() {
        super(100);
    }

    @Override
    public String toString() {
        return "Tv";
    }
}

class Computer extends Product {

    public Computer() {
        super(200);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}

class Audio extends Product {

    Audio() {
        super(50);
    }

    @Override
    public String toString() {
        return "Audio";
    }
}

class Buyer {

    int money = 1000;
    int bonusPoint = 0;
    Product[] item = new Product[10];
    int i = 0;

    void buy(Product p) {
        if (this.money < p.price) {
            System.out.println("잔액이 부족합니다.");
            return;
        }

        item[i++] = p;
        this.money -= p.price;
        this.bonusPoint += p.bonusPoint;
        System.out.println(p + "을/를 구매하셨습니다.");
    }

    void summary() {
        int sum = 0;
        String itemList = "";

        for (int i = 0; i < item.length; i++) {
            if (item[i] == null) {
                break;
            }
            sum += item[i].price;
            itemList += item[i] + ", ";
        }
        System.out.println("총 가격: " + sum);
        System.out.println("구매한 물품: " + itemList);
    }
}
