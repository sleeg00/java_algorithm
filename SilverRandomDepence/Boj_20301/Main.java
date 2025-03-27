package org.example.SilverRandomDepence.Boj_20301;

import java.io.*;
import java.util.*;

// 1 2 3 4 5 6 7
// 1 : 1 2 4 5 6 7  -> 3
// 2 : 1 2 4 5 7    -> 6
// 계속 으론쪽으로 제거
// 덱큐
// pollFirst() k-1번 4 5 6 7 1 2
// addLast() 2번
// poll () 출력
// 제거된 인원이 M명이면 반대로 돌아간다. sw : false
// pollLast()
// addFirst()
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.addLast(i);
        }
        boolean sw = true;
        ArrayList<Integer> stack = new ArrayList<>();
        int im =0;
        while (!queue.isEmpty()) {
            int value = 0;

            if (sw) {
                for (int i = 0; i < K - 1; i++) {
                    value = queue.pollFirst();
                    queue.addLast(value);
                }
                value = queue.pollFirst();

            } else {
                for (int i = 0; i < K - 1; i++) {
                    value = queue.pollLast();
                    queue.addFirst(value);
                }
                value = queue.pollLast();
            }

            stack.add(value);
            im++;
            if (im == M) {
                sw = !sw;
                im=0;
            }

        }
        for (int i = 0; i < stack.size(); i++) {
            bw.write(stack.get(i) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
