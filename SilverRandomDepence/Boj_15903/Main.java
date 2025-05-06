package org.example.SilverRandomDepence.Boj_15903;

import java.util.*;
import java.io.*;

// 카드 n장
// x, y 카드를 골라 두 카드에 쓰여진 수를 더함 (x!=y)
// 더한 값을 x, y번 카드에 덮어씀
// m번하면 놀이 종료 -> n장 카드 모두 더한값이 놀이 점수
// 이 값을 가장 작게 만들어라
// 2 <= N (카드수) <= 1_000
// 0 <= M (놀이 횟수) <= 15_000
// PQ로 가장 작은값 두개 꺼내오고 합을 두번 push
public class Main {
    static int card_count, game_count;
    static PriorityQueue<Long> pq = new PriorityQueue<>((p1, p2) -> {
        if (p1 < p2) {
            return -1;
        }
        return 1;
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        for(int i=0; i<game_count; i++) {
            long min_value_first = pq.poll();
            long min_value_second = pq.poll();
            long hap = min_value_first + min_value_second;
            pq.add(hap);
            pq.add(hap);
        }
        long ans = 0;
        while(!pq.isEmpty()) {
            ans += pq.poll();
        }
        System.out.println(ans);
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        card_count = Integer.parseInt(st.nextToken());
        game_count = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < card_count; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }
    }
}
