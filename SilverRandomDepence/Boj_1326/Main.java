package org.example.SilverRandomDepence.Boj_1326;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        int[] visit = new int[N+1];
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        queue.addLast(x);
        while(!queue.isEmpty()) {
            int value = queue.pollFirst();
            if(value==y) {
                bw.write(visit[value]+"\n");
                bw.flush();
                return ;
            }
            for(int i = value+arr[value]; i<=N; i+=arr[value]) {
                if(visit[i]==0) {
                    visit[i] = visit[value]+1;
                    queue.addLast(i);
                }
            }
            for(int i = value-arr[value]; i>=1; i-=arr[value]) {
                if(visit[i]==0) {
                    visit[i] = visit[value]+1;
                    queue.addLast(i);
                }
            }
        }
        bw.write("-1\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
