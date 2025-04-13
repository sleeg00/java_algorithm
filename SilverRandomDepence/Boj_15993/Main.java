package org.example.SilverRandomDepence.Boj_15993;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[][] Dp = new long[100_001][2];
        int test_case = Integer.parseInt(br.readLine());
        Dp[1][0] = 1;
        Dp[1][1] = 0;

        Dp[2][0] = 1;
        Dp[2][1] = 1;

        Dp[3][0] = 2;
        Dp[3][1] = 2;

        for (int i = 4; i <= 100_000; i++) {
            Dp[i][0] = (Dp[i - 1][1] + Dp[i - 2][1] + Dp[i - 3][1]) % 1_000_000_009;
            Dp[i][1] = (Dp[i - 1][0] + Dp[i - 2][0] + Dp[i - 3][0]) % 1_000_000_009;
        }
        for (int i = 0; i < test_case; i++) {
            int index = Integer.parseInt(br.readLine());
            bw.write(Dp[index][0] + " " + Dp[index][1] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
