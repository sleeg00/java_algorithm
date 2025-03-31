package org.example.SilverRandomDepence.Boj_1535;

import java.util.*;
import java.io.*;


public class Main {
    public static class Node {
        int health, like;

        Node(int a, int b) {
            this.health = a;
            this.like = b;
        }
    }

    static int N, ma = 0;
    static Node[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        arr = new Node[N];
        StringTokenizer health_st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer like_st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int health = Integer.parseInt(health_st.nextToken());
            int like = Integer.parseInt(like_st.nextToken());
            arr[i] = new Node(health, like);
        }
        back(0, 0, 100);
        System.out.print(ma);
    }

    private static void back(int idx, int hap, int health) {
        if (health <= 0) return;
        if (idx == N) {
            ma = Math.max(ma, hap);
            return;
        }

        back(idx + 1, hap, health);

        if (health - arr[idx].health > 0) {
            back(idx + 1, hap + arr[idx].like, health - arr[idx].health);
        }
    }
}
