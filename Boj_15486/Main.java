package org.example.Boj_15486;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 15:35
// 1 <= 퇴사 날(N) <= 1,500,000
// [T, P] = [상담 기간, 금액]
// 퇴사날 까지 받을 수 있는 최대 금액 구하기
//
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 2];
        int[] P = new int[N + 2];
        int[] Dp = new int[N +2];

        for (int i = 1; i <=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
            Dp[i] = Math.max(Dp[i], Dp[i-1]);

            if(i+T[i] <= N+1) {
                Dp[i+T[i]] = Math.max(Dp[i+T[i]], Dp[i]+P[i]);
            }
        }
        Dp[N+1] = Math.max(Dp[N+1], Dp[N]);
        bw.write(Dp[N+1] +"\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
