package org.example.Boj_2294;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coin = new int[N+1];
        int[] Dp = new int[K+1];

        for(int i=1; i<=N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin);
        for(int i=1; i<=K; i++) {
            Dp[i] = Integer.MAX_VALUE;
        }
        Dp[0]=0;
        for(int i=1; i<=N; i++) {
            int cost = coin[i];
            for(int j=cost; j<=K; j++) {
                if(Dp[j-cost]==Integer.MAX_VALUE) {
                    Dp[j] = Math.min(Dp[j], Dp[j-cost]);
                } else {
                    Dp[j] = Math.min(Dp[j], Dp[j - cost] + 1);
                }
            }
        }

        if(Dp[K]!=Integer.MAX_VALUE) bw.write(Dp[K] + " ");
        else bw.write(-1 + " ");
        bw.flush();
        bw.close();
        br.close();
    }
}
