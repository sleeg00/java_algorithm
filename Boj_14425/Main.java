package org.example.Boj_14425;

import java.io.BufferedReader;
import java.util.*;
// N개 문자열로 이루어진 집합 S
// M개 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇개인지 구하는 프로그램

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int cnt=0;
        HashMap<String,Integer> m = new HashMap<>();
        for (int i = 0; i < N; i++) {
            m.put(sc.nextLine(), 0);
        }

        for (int i = 0; i < M; i++) {
            if(m.containsKey(sc.nextLine())) {
                cnt++;
            }
        }
        System.out.print(cnt);

    }
}
