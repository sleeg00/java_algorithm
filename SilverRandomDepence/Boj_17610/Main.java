package org.example.SilverRandomDepence.Boj_17610;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr, Dp, visit;
    static int hap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = 0;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            hap += arr[i];
        }
        Dp = new int[hap + 2];
        visit = new int[N];
        back(0, 0);

        for (int i = 1; i <= hap; i++) {
            if (Dp[i] == 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void back(int idx, int value) {

        if (idx == N) {
            if(value>0 && value<=hap) {
                Dp[value]=1;
            }
            return;
        }

        back(idx + 1, value - arr[idx]);
        back(idx + 1, value + arr[idx]);
        back(idx+1, value);

    }

}
