package org.example.SilverRandomDepence.Boj_1374;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] lectures = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            lectures[i][0] = Integer.parseInt(st.nextToken());  // 시작 시간
            lectures[i][1] = Integer.parseInt(st.nextToken());  // 종료 시간
        }

        Arrays.sort(lectures, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 첫 번째 강의 시작 -> 첫 번째 강의실을 사용
        pq.offer(lectures[0][1]);

        for (int i = 1; i < N; i++) {
            if (lectures[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(lectures[i][1]);
        }

        System.out.println(pq.size());
    }
}

