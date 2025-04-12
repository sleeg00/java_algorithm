package org.example.SilverRandomDepence.Boj_15991;

import java.util.*;
import java.io.*;

public class Main {
    static long[] Dp = new long[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Dp[1] = 1;
        Dp[2] = 2;
        Dp[3] = 2;
        Dp[4] = 3;
        Dp[5] = 3;
        Dp[6] = 6;
        for (int i = 7; i <= 100_000; i++) {
            Dp[i] = (Dp[i - 2] + Dp[i - 4] + Dp[i - 6]) % 1_000_000_009;
        }
        for (int i = 0; i < N; i++) {
            int index = Integer.parseInt(br.readLine());
            System.out.println(Dp[index]);
        }
    }
}
