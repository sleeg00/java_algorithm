package org.example.GoldRandomDepence.Boj_1005;

import java.util.*;
import java.io.*;

public class Main {
    static int T, N, K;
    static int[] A, D;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // TestCase
        D = new int[1001];
        A = new int[1001];
        list = new ArrayList[1005];
        for(int i=0; i<=1004; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j <=1000; j++) {
                D[j] = -1;
            }

            for (int j = 1; j <= N; j++) {
                list[j] = new ArrayList<>();
            }
            for (int j = 1; j <= N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[y].add(x);
            }
            int vertex = Integer.parseInt(br.readLine());

            System.out.println(getDp(vertex));
            for(int j=1; j<=1000; j++) list[j].clear();
        }

    }

    private static int getDp(int x) {
        if (D[x] != -1) {
            return D[x];
        }
        D[x] = 0;
        for (int i = 0; i < list[x].size(); i++) {
            D[x] = Math.max(D[x], getDp(list[x].get(i)));
        }
        return D[x] = D[x] + A[x];

    }
}
