package org.example.SilverRandomDepence.Boj_14465;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];

        for(int i=0; i<K; i++) {
            int index = Integer.parseInt(br.readLine());
            arr[index]=1;
        }
        int cnt = 1, ans = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++) {
            if(arr[i]==1) {
                arr[i]=cnt++;
            } else {
                arr[i] = arr[i - 1];
            }
            if(i>=M) {
                ans = Math.min(ans, arr[i]-arr[i-M]);
            }
        }
        System.out.print(ans);
    }
}
