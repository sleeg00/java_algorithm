package org.example.StudyAlgorithm.Boj_1427;

// 1 <= N <= 1,000,000,000

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashMap<Character, Integer> m = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (m.get(str.charAt(i)) == null) {
                m.put(str.charAt(i), 1);
            } else {
                m.put(str.charAt(i), m.get(str.charAt(i))+1);
            }
        }



        for (int i = 9; i >= 0; i--) {
            char c = (char) (i + '0');
            if (m.get(c) != null) {
                int value = m.get(c);
                for (int j = 0; j < value; j++) {
                    System.out.print(i);
                }
            }
        }
    }
}
