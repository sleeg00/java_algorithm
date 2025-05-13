package org.example.GoldRandomDepence.Boj_1039;

import java.io.*;
import java.util.*;

class point {
    String str; // 해당 숫자
    int num; // 변환 수행 숫자

    point(String str, int num) {
        this.str = str;
        this.num = num;
    }
}

public class Main {
    static int N, K, M, result = -1;
    static boolean[][] visit = new boolean[1000001][11];
    static ArrayDeque<point> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String str = st.nextToken();
        queue.addLast(new point(str, 0));

        N = Integer.parseInt(str);
        visit[N][0] = true;
        M = str.length();
        K = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(result);

        br.close();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            point cur = queue.pollFirst();

            if (cur.num == K) {
                if (result < Integer.parseInt(cur.str))  result = Integer.parseInt(cur.str);
                continue;
            } else if (cur.num > K) return;


            for (int i = 0; i < M; i++) {
                for (int j = i + 1; j < M; j++) {// i번째 숫자와 k번째 숫자를 변환하는 경우
                    char[] arr = cur.str.toCharArray();
                    char tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp; // 변환

                    String next = new String(arr);
                    if (arr[0] != '0' && !visit[Integer.parseInt(next)][cur.num + 1]) {
                        visit[Integer.parseInt(next)][cur.num + 1] = true;
                        queue.addLast(new point(next, cur.num + 1));
                    }
                }
            }
        }
    }
}
