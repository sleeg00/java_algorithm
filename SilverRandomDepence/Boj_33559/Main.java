package org.example.SilverRandomDepence.Boj_33559;

import java.util.*;
import java.io.*;

// 배열 A에서 두 원소 교환
// 배열 B에서 두 원쇼 교환
// 조건 1: 도 원소의 인덱스는 다름
// Ai == Bi 개수 최대화
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer, Integer> A = new HashMap<>();
        HashMap<Integer, Integer> B = new HashMap<>();
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int valueA = Integer.parseInt(st.nextToken());
            int valueB = Integer.parseInt(st2.nextToken());
            if (!A.containsKey(valueA)) {
                A.put(valueA, 0);
            }
            A.put(valueA, A.get(valueA) + 1);
            if (!B.containsKey(valueB)) {
                B.put(valueB, 0);
            }
            B.put(valueB, B.get(valueB) + 1);
        }
        int hap = 0;
        for (Map.Entry<Integer, Integer> entry : A.entrySet()) {
            int key = entry.getKey();
            if (B.containsKey(key)) {
                int mi = Math.min(B.get(key), entry.getValue());
                hap += mi;
                for(int i=0; i<mi; i++) {
                    listA.add(key);
                    listB.add(key);
                    B.put(key, B.get(key)-1);
                    A.put(key, A.get(key)-1);

                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : A.entrySet()) {
            int key = entry.getKey();
            for(int i=0; i<A.get(key); i++) listA.add(key);
        }
        for (Map.Entry<Integer, Integer> entry : B.entrySet()) {
            int key = entry.getKey();
            for(int i=0; i<B.get(key); i++) listB.add(key);
        }
        bw.write(hap + "\n");
        for(int i=0; i<listA.size(); i++) {
            bw.write(listA.get(i)+" ");
        }
        bw.write("\n");
        for(int i=0; i<listB.size(); i++) {
            bw.write(listB.get(i)+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}




