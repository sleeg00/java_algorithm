package org.example.Boj_15988;

import java.util.*;
import java.io.*;
// 1 <= N <= 1,000,000
//
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] Dp = new long[1000004];
        int N = Integer.parseInt(br.readLine());
        Dp[0] = 0;
        Dp[1]=1;
        Dp[2]=2;
        Dp[3]=4;
        for(int i=4; i<=1000001; i++) {
            Dp[i] = (Dp[i-1]+Dp[i-2]+Dp[i-3]) % 1000000009;
        }

        for(int i=0; i<N; i++) {
            int number = Integer.parseInt(br.readLine());
            bw.write(Dp[number] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
