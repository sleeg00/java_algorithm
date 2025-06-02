package org.example.GoldRandomDepence.Boj_1915;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int ans = 0;
        int[][] dp = new int[N + 1][M + 1];
        int[][] arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = str.charAt(j - 1) - '0';
                dp[i][j] = arr[i][j];
                if (arr[i][j] == 1) {
                    if (arr[i - 1][j] == 1 && arr[i][j - 1] == 1 && arr[i - 1][j] == 1) {
                        dp[i][j] =
                                Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println((long) Math.pow(ans, 2));
    }
}
