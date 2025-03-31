package org.example.SilverRandomDepence.Boj_6118;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList[] graph;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        arr = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = Integer.MAX_VALUE;
        }

        arr[1] = 0;
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        int ma = bfs(1);
        int cnt = 0, place = Integer.MAX_VALUE, value;
        for (int i = 1; i <= N; i++) {
            if (arr[i] == ma) {
                cnt++;
                place = Math.min(i, place);
            }
        }
        bw.write(place + " " + ma + " " + cnt + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int bfs(int idx) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(idx);
        int ma = -1;
        while (!queue.isEmpty()) {
            int index = queue.pollFirst();
            if (arr[index] != Integer.MAX_VALUE) {
                ma = Math.max(ma, arr[index]);
            }
            for (int i = 0; i < graph[index].size(); i++) {
                int value = (int) graph[index].get(i);
                if (!visit[value]) {
                    visit[value] = true;
                    arr[value] = Math.min(arr[value], arr[index] + 1);
                    queue.addLast(value);
                }
            }
        }
        return ma;
    }
}
