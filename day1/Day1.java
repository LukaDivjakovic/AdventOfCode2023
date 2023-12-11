package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 {
    public static int findIndex(String[] arr, String t) {

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
        List<Digit> Digits = new ArrayList<>();
        int sum = 0;
        while ((line = br.readLine()) != null) {
            for (String digit : digits) {
                if (line.contains(digit)) {
                    Digits.add(new Digit(findIndex(digits, digit), line.indexOf(digit)));
                    if (line.lastIndexOf(digit) != line.indexOf(digit))
                        Digits.add(new Digit(findIndex(digits, digit), line.lastIndexOf(digit)));
                }
            }
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                    Digits.add(new Digit(Integer.parseInt(String.valueOf(line.charAt(i))), i));
                }
            }
            Collections.sort(Digits);

            sum += (10 * Digits.get(0).digit + Digits.get(Digits.size() - 1).digit);
            Digits.clear();
        }
        System.out.println(sum);
    }
}
