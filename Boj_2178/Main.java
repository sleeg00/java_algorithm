package org.example.Boj_2178;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int mv[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int map[][] = new int[N+1][M+1];
        int visit[][] = new int[N+1][M+1];
        int ans = Integer.MAX_VALUE;
        ArrayDeque<Node> queue = new ArrayDeque<Node>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = 100000;
            }
        }
        visit[0][0] = 1;
        queue.addLast(new Node(0, 0));

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';

            }

        }

        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();

            if (node.x == N - 1 && node.y == M - 1) {
                ans = Math.min(ans, visit[N - 1][M - 1]);
            }
            for (int i = 0; i < 4; i++) {
                int dx = node.x + mv[i][0];
                int dy = node.y + mv[i][1];
                if (dx < 0 || dy < 0 || dx >= N || dy >= M || map[dx][dy] == 0) {
                    continue;
                }
                if (visit[dx][dy] > visit[node.x][node.y] + 1) {
                    visit[dx][dy] = visit[node.x][node.y] + 1;
                    queue.addLast(new Node(dx, dy));
                }

            }
        }
        bw.write(ans + " ");
        bw.close();
        br.close();
    }
}
