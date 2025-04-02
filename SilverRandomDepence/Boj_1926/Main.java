package org.example.SilverRandomDepence.Boj_1926;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M, ans, cnt;
    static int[][] arr;
    static boolean[][] visit;

    public static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int u = 0; u < M; u++) {
                arr[i][u] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int u = 0; u < M; u++) {
                if (arr[i][u] == 1) {
                    ans = Math.max(ans, bfs(i, u));
                    cnt++;

                }
            }
        }
        System.out.print(cnt + "\n" + ans);
    }

    private static int bfs(int x, int y) {
        int[][] mv = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(x, y));
        ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            Node node = queue.pollFirst();
            arr[node.x][node.y] = 0;
            for (int i = 0; i < 4; i++) {
                int dx = node.x + mv[i][0];
                int dy = node.y + mv[i][1];
                if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                    continue;
                }
                if (!visit[dx][dy] && arr[dx][dy]==1) {
                    visit[dx][dy] = true;
                    queue.addLast(new Node(dx, dy));
                }
            }
        }
        return ans;
    }
}
