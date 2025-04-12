package org.example.SilverRandomDepence.boj_15992;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static long[][] Dp = new long[1_001][1_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Dp[1][1] = 1;
        Dp[2][1] = 1;
        Dp[2][2]=1;
        Dp[3][1]=1;
        Dp[3][2]=2;
        Dp[3][3]=1;
        for (int i = 4; i <= 1_000; i++) {
            for(int j=1; j<=i; j++) {
                Dp[i][j] = (Dp[i-1][j-1]+Dp[i-2][j-1]+Dp[i-3][j-1])%1_000_000_009;

            }
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bw.write(Dp[x][y]+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
