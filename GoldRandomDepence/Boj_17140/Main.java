package org.example.GoldRandomDepence.Boj_17140;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

// 3 x 3 배열
// R 연산 : 배열의 모든 행에 대해서 정렬 수행 행 개수 >= 열 개수 일때만
// C 연산 : 배열의 모든 열에 대해서 정렬 수행 행 개수 <  열 개수 일때만
// 각각의 수가 몇 번 나왔는지?
// 수의 등장 횟수가 커지는 순으로 (중복시 오름차순 정렬)
// 배열 A에 정렬된 결과로 초기화, 수와 등장 횟수를 모두 넣고, 순서는 수가 먼저
// [수의 등장 횟수 오름차순 -> 중복시 수 오름차순][수 등장 횟수]
public class Main {
    public static class Node {
        int countOfNumber, number;

        public Node(int countOfNumber, int number) {
            this.countOfNumber = countOfNumber;
            this.number = number;
        }
    }

    static int R, C, K, N = 3, M = 3, maN, maM;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>((p1, p2) -> {
        if (p1.countOfNumber == p2.countOfNumber) { // 등장 횟수가 같으면
            if (p1.number < p2.number) {
                return -1;
            }
            return 1;
        }
        if (p1.countOfNumber < p2.countOfNumber) {
            return -1;
        }
        return 1;
    });
    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 3; i++) {
            map.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                map.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
        maN = N;
        maM = M;
        N = maN;
        M = maM;
        if (checkAns(0)) return;
        int cnt = 0;

        while (cnt <= 100) {
            boolean sw = false;
            for (int i = 0; i < maN; i++) {
                if (N >= M) {
                    for (int j = 0; j < M; j++) {
                        int value = map.get(i).get(j);
                        changeHashMap(value);
                        sw = true;
                    }
                    sorting();
                    initList(i);
                }
            }

            addZero();
          //  print();

            if(sw) cnt++;
            sw = false;
            if (checkAns(cnt)) return;

            for (int i = 0; i < maM; i++) {
                if (N < maM) {
                    sw = true;
                    for (int j = 0; j < N; j++) {
                        int value = map.get(j).get(i);
                        changeHashMap(value);
                    }
                    sorting();
                    initListCol(i);
                }
            }

            addZeroCol();

          //  print();
          //  System.out.println();

            if(sw) cnt++;
            if (checkAns(cnt)) return;

        }
        System.out.println(-1);
    }

    private static boolean checkAns(int cnt) {
        if (map.get(R - 1).get(C - 1) == K) {
            System.out.print(cnt);
            return true;
        }
        return false;
    }

    private static void addZero() {
        for (int i = 0; i < maN; i++) {
            while (map.get(i).size() < maM) {
                map.get(i).add(0);
            }
        }
    }

    private static void print() {
        for (int i = 0; i < maN; i++) {
            for (int j = 0; j < maM; j++) {
                System.out.print(map.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static void addZeroCol() {
        int now_size = map.size();
        while (now_size < maN) {
            map.add(new ArrayList<>());
            for (int i = 0; i < maM; i++) {
                map.get(map.size() - 1).add(0);
            }
        }
    }

    private static void initListCol(int idx) {
        while (map.size() < pq.size() * 2) {
            map.add(new ArrayList<>());
            for (int i = 0; i < maM; i++) {
                map.get(map.size() - 1).add(0);
            }
        }
        maN = Math.max(maN, map.size());
        for(int i=0; i<maN; i++) {
            if(pq.isEmpty()) {
                map.get(i).set(idx, 0);
            } else {
                Node node = pq.poll();
                map.get(i).set(idx, node.number);
                i++;
                map.get(i).set(idx, node.countOfNumber);
            }
        }
    }

    private static void initList(int idx) {
        map.get(idx).clear();
        while (!pq.isEmpty()) {
            map.get(idx).add(pq.peek().number);
            map.get(idx).add(pq.poll().countOfNumber);
        }
        maM = Math.max(maM, map.get(idx).size());
    }

    private static void sorting() {
        for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
            pq.add(new Node(entry.getValue(), entry.getKey())); // 등장 횟수, 숫자
        }
        hashMap.clear();
    }

    private static void changeHashMap(int value) {
        if (value != 0) {
            if (!hashMap.containsKey(value)) {
                hashMap.put(value, 1); // 숫자, 등장 횟수
            } else {
                hashMap.put(value, hashMap.get(value) + 1);
            }
        }
    }
}
