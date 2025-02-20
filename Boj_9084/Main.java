package org.example.Boj_9084;

import java.util.*;
import java.io.*;

// 입력 금액을 만들수 있는 모든 방법 출력
// 1 <= TeatCase(T) <= 10
// 1 <= 동전 가지수(N) <= 20
// 1 <= 금액(M) <= 10,000
// Dp
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N, M;
        for(int i=0; i<T; i++) {

            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int[] value = new int[21];

            for(int j=0; j<N; j++) value[j+1] = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(br.readLine());

            int[] Dp = new int[M+1];

            Dp[0] = 1;
            for(int j=1; j<=N; j++) {
                for(int k=value[j]; k<=M; k++) {
                    Dp[k] += Dp[k-value[j]];
                }
            }
            bw.write(Dp[M] + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
