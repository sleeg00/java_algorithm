package org.example.Boj_14888;

import java.util.*;

public class Main {
    static int N = 0;
    static int arr[] = new int[12];
    static int visit[] = new int[12];
    static int ma = Integer.MIN_VALUE;
    static int mi = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            visit[i] = sc.nextInt();
        }
        dfs(arr[0], 1);
        System.out.println(ma + "\n" + mi);
    }

    public static void dfs(int value, int cnt) {
        if (cnt == N) {
            ma = Math.max(ma, value);
            mi = Math.min(mi, value);
        } else {
            for (int i = 0; i < 4; i++) {
                if (i == 0 && visit[i] != 0) {
                    visit[i]--;
                    dfs(value + arr[cnt], cnt + 1);
                    visit[i]++;
                }
                if (i == 1 && visit[i] != 0) {
                    visit[i]--;
                    dfs(value - arr[cnt], cnt + 1);
                    visit[i]++;
                }
                if (i == 2 && visit[i] != 0) {

                    visit[i]--;
                    dfs(value * arr[cnt], cnt + 1);
                    visit[i]++;
                }
                if (i == 3 && visit[i] != 0) {
                    visit[i]--;
                    dfs(value / arr[cnt], cnt + 1);
                    visit[i]++;
                }
            }
        }
    }
}
