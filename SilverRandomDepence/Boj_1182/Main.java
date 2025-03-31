package org.example.SilverRandomDepence.Boj_1182;

import java.util.*;
import java.io.*;

public class Main {
    static int N, S, cnt;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        back(0, 0);
        if (S == 0) {
            cnt--;
        }
        System.out.println(cnt);
    }

    private static void back(int idx, int hap) {
        if (idx == N) {
            if (hap == S) {
                cnt++;
            }
            return;
        }

        back(idx + 1, hap);
        back(idx + 1, hap + arr[idx]);
    }
}
