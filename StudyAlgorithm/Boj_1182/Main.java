package org.example.StudyAlgorithm.Boj_1182;

import java.util.*;
import java.io.*;

public class Main {
    static int arr[];
    static int ans = 0, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        f(0,0);
        if(M==0) ans--;
        bw.write(ans + " ");
        bw.flush();
        br.close();
        bw.close();
    }

    static void f(int idx, long hap) {
        if (idx == N) {
            if (hap == M) {
                ans++;

            } return ;
        }

        f(idx + 1, hap);
        f(idx + 1, hap + arr[idx]);
    }
}
