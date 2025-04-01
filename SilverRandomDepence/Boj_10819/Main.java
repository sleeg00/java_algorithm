package org.example.SilverRandomDepence.Boj_10819;

import java.util.*;
import java.io.*;
public class Main {
    static int N, ma = -1_000_000;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        visit = new boolean[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {

            back(i, 0, 0);
        }
        System.out.print(ma);
    }
    private static void back(int idx, int cnt, int hap) {
        if(cnt==N-1) {
            ma = Math.max(ma, hap);
            return ;
        }
        for(int i=0; i<N; i++) {
            if(!visit[i] && idx!=i) {
                visit[idx] = true;
                back(i, cnt+1, hap+Math.abs(arr[idx]-arr[i]));
                visit[idx] = false;
            }
        }
    }
}
