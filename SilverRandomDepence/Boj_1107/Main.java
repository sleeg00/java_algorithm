package org.example.SilverRandomDepence.Boj_1107;

import java.util.*;
import java.io.*;

// 0 ~ 9 숫자, +, -
// 0에서 - => 채널 변함 X
// 고장난 버튼이 주어짐
//
public class Main {
    static int button_count, ma = Integer.MAX_VALUE, touch = Integer.MAX_VALUE;
    static String N;
    static int[] button = new int[10];

    public static void main(String[] args) throws IOException {
        init();
        dfs("");
        System.out.print(getFirstChannel());

    }

    private static long getFirstChannel() {
        int value = Math.abs(Integer.parseInt(N) - 100);
        if (touch == Integer.MAX_VALUE || ma == Integer.MAX_VALUE) return value;  // 숫자 버튼으로는 도달 불가능
        return Math.min(touch + ma, value);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        button_count = Integer.parseInt(br.readLine());
        for (int i = 0; i < button.length; i++) {
            button[i] = 1;
        }
        if (button_count != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < button_count; i++) {
                int number = Integer.parseInt(st.nextToken());
                button[number] = 0;
            }
        }
        br.close();
    }

    private static void dfs(String str) {
        if (!str.equals("")) {
            int value = Math.abs(Integer.parseInt(str) - Integer.parseInt(N));
            if (value < ma) {
                ma = value;
                touch = str.length();
            } else if (value == ma && touch > str.length()) {
                touch = str.length();
                ma = value;
            }

        }
        if (str.length() >= N.length()+1) {
            return;
        }
        for (int i = 0; i < button.length; i++) {
            if (button[i] == 1) {
                dfs(str + i);
            }
        }
    }
}
