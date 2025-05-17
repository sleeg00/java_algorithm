package org.example.GoldRandomDepence.Boj_1976;

import java.util.*;
import java.io.*;

//
public class Main {
    static int N, M;
    static int[][] arr;
    static int[] p;
    static int[] road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        road = new int[M];
        for (int i = 0; i < M; i++) {
            road[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int root = find(road[0]);
        for(int i=0; i<M; i++) {
            if(root!=find(road[i])) {
                System.out.println("NO");
                return ;
            }
        }
        System.out.println("YES");

    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return false;
        }
        if (x < y) {
            p[y] = x;
        } else {
            p[x] = y;
        }
        return true;
    }

    public static int find(int x) {
        if (p[x] == x) {
            return x;
        }
        return find(p[x]);
    }
}
