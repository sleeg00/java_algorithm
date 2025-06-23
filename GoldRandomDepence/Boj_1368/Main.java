package org.example.GoldRandomDepence.Boj_1368;

import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int N;
    static List<Edge>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1]; // 0번: 가상 우물 정점
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        // 가상 노드 0에서 각 논으로 연결 (우물 파는 비용)
        for (int i = 1; i <= N; i++) {
            int cost = Integer.parseInt(br.readLine());
            graph[0].add(new Edge(i, cost));
        }

        // 논들 사이의 물 끌어오기 비용
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i != j) {
                    graph[i].add(new Edge(j, cost));
                }
            }
        }

        System.out.println(prim());
    }

    static long prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));
        long total = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.to]) continue;
            visited[cur.to] = true;
            total += cur.cost;

            for (Edge next : graph[cur.to]) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }
        }

        return total;
    }
}
