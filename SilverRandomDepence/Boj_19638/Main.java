package org.example.SilverRandomDepence.Boj_19638;

import java.util.*;
import java.io.*;

// 뿅망치 맞은 사람 키를 키/2 로 만듦
// * 단 1인 경우 더 줄어들 수 없다
// 가장 큰 거인 중 한명을 때림
// 1 <= N (거인 수) <= 100_000
// 1 <= H (센티 키) <= 2_000_000_000
// 1 <= T (망치 횟수) <= 100_000
// PQ로 망치 때리고, 만약 poll() < centi 면 종료
public class Main {
    static int N, H, T;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> {
        if (p1 < p2) {
            return 1;
        } else {
            return -1;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        init(br);
        if (pq.peek() < H) { // centi보다 작은 경우 (처음에 예외처리)
            System.out.println("YES");
            System.out.println(0);
            return;
        }
        for (int i = 1; i <=T; i++) {

            if (pq.peek() != 1) {
                pq.add(pq.poll() / 2);
            }
            if (pq.peek() < H) { // centi보다 작은 경우
                System.out.println("YES");
                System.out.println(i);
                return;
            }
        }
        System.out.println("NO");
        System.out.println(pq.poll());
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
    }
}
