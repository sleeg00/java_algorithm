package org.example.SilverRandomDepence.Boj_1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    static String[] word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);

        if (returnException()) {
            return;
        }

        backtracking(0, 0);
        System.out.println(max);
    }

    public static void backtracking(int alpha, int len) {
        if (len == K - 5) { // a n t i c (5개 제외하고 길이)
            int count = 0;
            for (int i = 0; i < N; i++) { //뽑은 알파벳으로 몇개의 단어를 읽을 수 있는지 카운트.
                boolean read = true;
                for (int j = 0; j < word[i].length(); j++) {
                    if (!visited[word[i].charAt(j) - 'a']) { // 백트래킹후 못 읽으면 break
                        read = false;
                        break;
                    }
                }
                if (read) {
                    count++;
                }
            }
            max = Math.max(max, count);
            return;
        }

        for (int i = alpha; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(i, len + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean returnException() {
        if (K < 5) { //a c i n t의 개수가 5개이므로
            System.out.println("0");
            return true;
        }
        if (K == 26) { //모든 알파벳을 다 읽을 수 있다.
            System.out.println(N);
            return true;
        }
        return false;
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        word = new String[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            str = str.replace("anta", "");
            str = str.replace("tica", "");
            word[i] = str;
        }
        visited = new boolean[26]; //각 알파벳을 배웠는지 체크
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
    }
}
