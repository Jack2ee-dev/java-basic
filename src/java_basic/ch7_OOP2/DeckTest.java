package java_basic.ch7_OOP2;

public class DeckTest {

    public static void main(String[] args) {
        Deck d = new Deck();
        Card c = d.pick(0);
        System.out.println(c);
        d.shuffle();
        c = d.pick(0);
        System.out.println(c);
    }
}

class Deck {

    final int CARD_NUM = 52;
    Card[] c = new Card[CARD_NUM];

    public Deck() {
        int i = 0;

        for (int k = Card.KIND_MAX; k > 0; k--) {
            for (int n = 1; n < Card.NUM_MAX; n++) {
                c[i++] = new Card(k, n);
            }
        }
    }

    Card pick(int index) {
        if (0 <= index && index < CARD_NUM) {
            return c[index];
        }
        return pick();
    }

    Card pick() {
        int index = (int) (Math.random() * CARD_NUM);
        return pick(index);
    }

    void shuffle() {
        for (int n = 0; n < 1000; n++) {
            int i = (int) (Math.random() * CARD_NUM);
            Card temp = c[0];
            c[0] = c[i];
            c[i] = temp;
        }
    }
}

class Card {

    static final int KIND_MAX = 4;
    static final int NUM_MAX = 13;

    static final int SPADE = 4;
    static final int DIAMOND = 3;
    static final int HEART = 2;
    static final int CLOVER = 1;

    int kind;
    int number;

    public Card() {
        this(SPADE, 1);
    }

    public Card(int kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    @Override
    public String toString() {
        String kind = "";
        String number;

        switch (this.kind) {
            case SPADE:
                kind = "SPADE";
                break;
            case DIAMOND:
                kind = "DIAMOND";
                break;
            case HEART:
                kind = "HEART";
                break;
            case CLOVER:
                kind = "CLOVER";
                break;
            default:
        }

        switch (this.number) {
            case 13:
                number = "K";
                break;
            case 12:
                number = "Q";
                break;
            case 11:
                number = "J";
                break;
            default:
                number = this.number + "";
        }

        return "kind: " + kind + ", number: " + number;
    }
}