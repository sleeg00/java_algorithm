package org.example.StudyAlgorithm.Boj_14002;

import java.io.*;
import java.sql.Array;
import java.util.*;
// 1 <= N <= 1,000
// 가장 긴 수열 (DP, LIS(n^2)) 해결 가능
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        ArrayList<Integer> list = new ArrayList<>();
        int[] Dp = new int[N];


        st = new StringTokenizer(br.readLine(), " ");
        int checker = 0;
        int cnt = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            for(int j=0; j<i; j++) {
                if (arr[i] > arr[j]) {
                    Dp[i] = Math.max(Dp[i], Dp[j] + 1);
                }
            }
            if(checker < Dp[i]) {
                checker = Dp[i];
                cnt++;
            }
        }
        bw.write(cnt+1 + "\n");
        int v = -1;
        for(int i=N-1; i>=0; i--) {
            if(Dp[i]==cnt) {
                if(arr[i] > v) {
                    v = arr[i];
                    N = i+1;
                }
            }
        }
        list.add(v);
        cnt--;
        for(int i=N-1; i>=0; i--) {
            int index = list.size()-1;
            if(Dp[i]==cnt&& list.get(index) > arr[i]) {
                list.add(arr[i]);
                cnt--;
            }
        }

        for(int i=list.size()-1; i>=0; i--) {
            bw.write(list.get(i) + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
