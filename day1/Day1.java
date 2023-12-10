package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static int findIndex(String arr[], String t) {

        // if array is Null
        if (arr == null) {
            return -1;
        }

        // find length of array
        int len = arr.length;
        int i = 0;

        // traverse in the array
        while (i < len) {

            // if the i-th element is t
            // then return the index
            if (arr[i].equals(t)) {
                return i;
            } else {
                i = i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("day1/res/input.txt"));
        String line;
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        List<Integer> Digits = new ArrayList<>();
        int sum = 0, first = 0, last = 0;
        while ((line = br.readLine()) != null) {
            boolean foundFirst = false;
            boolean hasLetters = false;
            for (String digit : digits) {
                if (line.contains(digit)) {
                    hasLetters = true;
                    Digits.add(findIndex(digits, digit));
                }
            }

            for (int i = 0; i < line.length(); i++) {

                if (line.charAt(i) >= '0' && line.charAt(i) <= '9' && !foundFirst) {
                    if (hasLetters && i < line.indexOf(digits[Digits.get(0)]))
                        first = Integer.parseInt(String.valueOf(line.charAt(i)));
                    else {
                        first = Digits.get(0);
                    }
                    foundFirst = true;
                }
                if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                    if (hasLetters && i > line.indexOf(digits[Digits.get(Digits.size() - 1)]))
                        last = Integer.parseInt(String.valueOf(line.charAt(i)));
                    else {
                        last = Digits.get(Digits.size() - 1);
                    }
                }
            }

            sum += (10 * first + last);
        }
        System.out.println(sum);
    }
}
