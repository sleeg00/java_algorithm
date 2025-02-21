package org.example.Boj_2293;

import java.util.*;
import java.io.*;
// N개 동전, 합이 K가 되는 경우의 수
// 1 <= N(동전 개수) <= 100
// 1 <= K(합) <= 10,000

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] Dp = new int[K+1];
        int[] cost = new int[N+1];
        Dp[0]=1;
        for(int i=0; i<N; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<N; i++) {
            int coin = cost[i];
            for(int j=coin; j<=K; j++) {
                Dp[j] = Dp[j-coin] + Dp[j];
            }

        }
        bw.write(Dp[K] + " ");
        bw.flush();
        bw.close();
        br.close();
    }
}
