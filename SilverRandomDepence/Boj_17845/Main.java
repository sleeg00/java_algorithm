package org.example.SilverRandomDepence.Boj_17845;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[M + 1][2];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int like = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            arr[i][0] = like;
            arr[i][1] = time;

        }
        int[][] Dp = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                Dp[i][j] = Dp[i - 1][j];
                if (j - arr[i][1] >= 0) {
                    Dp[i][j] = Math.max(Dp[i][j], Dp[i-1][j - arr[i][1]] + arr[i][0]);
                }
            }
        }

        System.out.print(Dp[M][N]);
    }
}
