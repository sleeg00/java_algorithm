package org.example.SilverRandomDepence.Boj_16195;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[][] Dp = new long[1_001][1_001];
        long[][] ans = new long[1_001][1_001];
        int N = Integer.parseInt(br.readLine());
        Dp[1][1] = 1;
        Dp[2][1] = 1;
        Dp[2][2] = 1;
        Dp[3][1] = 1;
        Dp[3][2] = 2;
        Dp[3][3] = 1;
        for (int i = 4; i <= 1_000; i++) {
            for (int j = 1; j <= i; j++) {
                Dp[i][j] = (Dp[i - 1][j - 1] + Dp[i - 2][j - 1] + Dp[i - 3][j - 1]) % 1_000_000_009;
            }
        }
        for (int i = 0; i < N; i++) {
            long hap = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= y; j++) {
                hap = (hap + Dp[x][j]) % 1_000_000_009;
            }
            bw.write(hap + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
