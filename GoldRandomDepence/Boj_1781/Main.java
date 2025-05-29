package org.example.GoldRandomDepence.Boj_1781;

import java.util.*;
import java.io.*;

public class Main {
    static class Problem {
        int deadline, ramen;

        Problem(int deadline, int ramen) {
            this.deadline = deadline;
            this.ramen = ramen;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Problem> problems = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            problems.add(new Problem(d, r));
        }

        // 데드라인 기준으로 오름차순 정렬
        problems.sort(Comparator.comparingInt(p -> p.deadline));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Problem p : problems) {
            minHeap.add(p.ramen);
            if (minHeap.size() > p.deadline) {
                minHeap.poll();
            }
        }

        long total = 0;
        while (!minHeap.isEmpty()) {
            total += minHeap.poll();
        }

        System.out.println(total);
    }
}
