package day1;

public class Digit implements Comparable<Digit> {
    public int digit;
    public int index;

    public Digit(int digit, int index) {
        this.digit = digit;
        this.index = index;
    }

    @Override
    public int compareTo(Digit o) {
        if (this.index > o.index)
            return 1;
        return -1;
    }

    @Override
    public String toString() {
        return "Digit{" +
                "digit=" + digit +
                ", index=" + index +
                '}';
    }
}
