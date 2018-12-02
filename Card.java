package uno;

public class Card implements Comparable<Card>{
    protected String color;
    protected int number;
    protected String function;

    public Card(String color, int number, String function) {
        this.color = color;
        this.number = number;
        this.function = function;
    }

    public String getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

    public String getFunction() {
        return function;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "uno.Card{" +
                "color='" + color + '\'' +
                ", number=" + number +
                ", function='" + function + '\'' +
                '}';
    }

    @Override
    public int compareTo(Card o) {
        if (color.compareTo(o.color)>0){
            return 1;
        }
        if (color.compareTo(o.color)<0){
            return -1;
        }
        if (color.compareTo(o.color)==0){
            if (number>o.number){
                return 1;
            }
            if (number<o.number){
                return -1;
            }
        }
        return 0;
    }
}
