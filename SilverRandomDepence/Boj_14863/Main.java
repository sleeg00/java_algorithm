package org.example.SilverRandomDepence.Boj_14863;

import java.util.*;
import java.io.*;

// 도보 이용시 시간, 모금액
// 자전거 이동시 시간, 모금액
// K분 이내 최대 모금액
// 3 <= N(구간) <= 100
// 1 <= K(시간) <= 100_000
public class Main {
    public static class Node {
        int walk_time, walk_value;
        int cycle_time, cycle_value;

        Node(int walk_time, int walk_value, int cycle_time, int cycle_value) {
            this.walk_time = walk_time;
            this.walk_value = walk_value;
            this.cycle_time = cycle_time;
            this.cycle_value = cycle_value;
        }
    }

    static int N, K, ma = 0;
    static int[][] dp;

    static int[][] distance = new int[105][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        dp = new int[N][K + 1];
        int w = distance[0][0], wv = distance[0][1];
        int c = distance[0][2], cv = distance[0][3];
        dp[0][w] = Math.max(dp[0][w], wv);
        dp[0][c] = Math.max(dp[0][c], cv);
        ma = Math.max(ma, Math.max(dp[0][w], dp[0][c]));


        for (int i = 1; i < N; i++) {
            for (int time = 0; time <= K; time++) {
                if (dp[i - 1][time] == 0) {
                    continue;
                }
                int now_walk_time = time + distance[i][0];
                int now_cycle_time = time + distance[i][2];

                if (now_walk_time <= K) { // walk
                    dp[i][now_walk_time] =
                            Math.max(dp[i][now_walk_time], dp[i - 1][time] + distance[i][1]);

                }

                if (now_cycle_time <= K) { // walk
                    dp[i][now_cycle_time] =
                            Math.max(dp[i][now_cycle_time], dp[i - 1][time] + distance[i][3]);
                }
            }
        }
        int result = 0;
        for (int t = 0; t <= K; t++) {
            result = Math.max(result, dp[N-1][t]);
        }
        System.out.println(result);
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            distance[i][0] = Integer.parseInt(st.nextToken());
            distance[i][1] = Integer.parseInt(st.nextToken());
            distance[i][2] = Integer.parseInt(st.nextToken());
            distance[i][3] = Integer.parseInt(st.nextToken());
        }
    }
}

