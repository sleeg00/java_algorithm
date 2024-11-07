package org.example.Boj_11478;

import java.util.*;
// 17:50
// 문자열 S, S의 서로 다른 부분 문자열 개수 구하기
// S에서 연속된 일부분 = 부분 문자열
// 1 <= S <=1,000
// ababc => a, b, a, b, c, ab, ba,ab,.... 12개

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();
        String str = sc.nextLine();

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (j + (i + 1) <= str.length()) {
                    String s = str.substring(j, (j + (i + 1)));
                    if (map.get(s) == null) {
                        map.put(s, 1);
                    }
                }
            }
        }
        System.out.println(map.size());
    }
}
