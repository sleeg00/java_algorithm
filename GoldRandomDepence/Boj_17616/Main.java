package org.example.GoldRandomDepence.Boj_17616;

import java.util.*;
import java.io.*;

// A, B 중 누가 더 잘했는지 알려준다 * 동점 없음
// 둘 씩 짝을 지어, M번 질문
// 등수를 알고 싶은 학생 X와 본부 답으로부터 X의 등수 찾아서 출력
// 2 <= N(학생수) <= 100_000
// 1 <= M(질문수) <= 500_000
// 1 <= X(찾을 학생) <= N
public class Main {
    static int N, M, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] min_list = new ArrayList[N+1];
        ArrayList<Integer>[] max_list = new ArrayList[N+1];

        for (int i = 0; i <=N; i++) {
            min_list[i] = new ArrayList<>();
            max_list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            min_list[x].add(y);
            max_list[y].add(x);
        }

        int min = bfs(min_list);
        int max = bfs(max_list);

        System.out.println(max + " " +(N+1-min));
    }

    public static int bfs(ArrayList<Integer>[] list) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        queue.addLast(X);
        visited[X] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int number = queue.pollFirst();
            for (int i = 0; i < list[number].size(); i++) {
                int next = list[number].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    queue.addLast(next);
                }
            }
            cnt++;

        }
        return cnt;
    }
}
