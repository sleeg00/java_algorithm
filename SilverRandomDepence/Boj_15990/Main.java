package org.example.SilverRandomDepence.Boj_15990;

import java.util.*;
import java.io.*;
public class Main {
    static long[][] Dp = new long[100001][4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Dp[1][1] = 1;
        Dp[2][2]=1;
        Dp[3][1]=1;
        Dp[3][2]=1;
        Dp[3][3]=1;
        for(int i=4; i<=100_000; i++) {
            Dp[i][1] = (Dp[i-1][2]+Dp[i-1][3])% 1_000_000_009;
            Dp[i][2] = (Dp[i-2][1]+Dp[i-2][3])% 1_000_000_009;
            Dp[i][3] = (Dp[i-3][1]+Dp[i-3][2])% 1_000_000_009;

        }
        for(int i=0; i<N; i++) {
            int index = Integer.parseInt(br.readLine());
            long hap = (Dp[index][1]+Dp[index][2]+Dp[index][3]) % 1_000_000_009;
            System.out.println(hap);
        }
    }
}
