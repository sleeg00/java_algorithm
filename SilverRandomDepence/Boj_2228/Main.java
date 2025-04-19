package org.example.SilverRandomDepence.Boj_2228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int x=Integer.parseInt(br.readLine());
            sum[i] = x + sum[i - 1];
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int j = 1; j <= m; j++) {
            dp[0][j] = -3276800;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k <= i; k++) { // 사용한 구간들 까지
                    if (k >= 2) // i~k까지 누적합 (K: 이전 구간합의 구간)
                        dp[i][j] = Math.max(dp[i][j], dp[k - 2][j - 1] + sum[i] - sum[k - 1]);
                    else if (k == 1 && j == 1) // 예외 처리
                        dp[i][j] = Math.max(dp[i][j], sum[i]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }

}
