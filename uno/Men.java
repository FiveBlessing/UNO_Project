package uno;

import java.util.Arrays;

public class Men {
    protected String name;
    protected Card[] card;
    protected int num;

    public Men(String name, Card[] card, int num) {
        this.name = name;
        this.card = card;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public Card[] getCard() {
        return card;
    }

    public int getNum() {
        return num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCard(Card[] card) {
        this.card = card;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Men{" +
                "name='" + name + '\'' +
                ", card=" + Arrays.toString(card) +
                ", num=" + num +
                '}';
    }
}
