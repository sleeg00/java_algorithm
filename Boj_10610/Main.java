package org.example.Boj_10610;

// 30
// 양수 N, 숫자를 섞어 30의 배수가 되는 가장 큰 수
// 1 <= N <= 100,000

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashMap<Character, Integer> m = new HashMap<>();

        Long hap = 0L;
        for (int i = 0; i < str.length(); i++) {
            if (m.get(str.charAt(i)) == null) {
                m.put(str.charAt(i), 1);
            } else {
                m.put(str.charAt(i), m.get(str.charAt(i)) + 1);
            }
            hap += (int) str.charAt(i) - '0';
        }
        if (!str.contains("0") || hap % 3 != 0) {
            System.out.println(-1);
        } else {
            for (int i = 9; i >= 0; i--) {
                char c = (char) (i + '0');
                if (m.get(c) != null) {
                    int value = m.get(c);
                    for (int j = 0; j < value; j++) {
                        System.out.print(c);
                    }
                }
            }
        }

    }
}
