package org.example.StudyAlgorithm.Boj_4179;

import java.util.*;
import java.io.*;

//
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

        char map[][] = new char[N + 2][M + 2];
        int mv[][] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int visit[][] = new int[N + 2][M + 2];
        int dist[][] = new int[N + 2][M + 2];
        ArrayDeque<Node> Q1 = new ArrayDeque<>();
        ArrayDeque<Node> Q2 = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                visit[i][j] = -1;
                dist[i][j] = -1;
                if (map[i][j] == 'J') {
                    visit[i][j] = 0;
                    Q1.addLast(new Node(i, j));
                } else if (map[i][j] == 'F') {
                    dist[i][j] = 0;
                    Q2.addLast(new Node(i, j));
                }
            }
        }

        while (!Q2.isEmpty()) {
            Node fire = Q2.pollFirst();
            for (int i = 0; i < 4; i++) {
                int dx = fire.x + mv[i][0];
                int dy = fire.y + mv[i][1];
                if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                    continue;
                }
                if (map[dx][dy] == '#' || dist[dx][dy] >= 0) {
                    continue;
                }
                dist[dx][dy] = dist[fire.x][fire.y] + 1;
                Q2.addLast(new Node(dx, dy));
            }
        }

        while (!Q1.isEmpty()) {
            Node node = Q1.pollFirst();

            for (int i = 0; i < 4; i++) {
                int dx = node.x + mv[i][0];
                int dy = node.y + mv[i][1];
                if (dx >= N || dy >= M || dx < 0 || dy < 0) {
                    bw.write(visit[node.x][node.y]+1 + "\n");
                    bw.flush();
                    br.close();
                    bw.close();
                    return;
                }
                if (visit[dx][dy] >= 0 || map[dx][dy] == '#') {
                    continue;
                }
                if (dist[dx][dy] != -1 && dist[dx][dy] <= visit[node.x][node.y] + 1) {
                    continue;
                }
                visit[dx][dy] = visit[node.x][node.y] + 1;
                Q1.addLast(new Node(dx, dy));
            }

        }
        bw.write("IMPOSSIBLE" + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
