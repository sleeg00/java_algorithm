package org.example.SilverRandomDepence.Boj_17503;

import java.util.*;
import java.io.*;

public class Main {
    public static class Node {
        long hap, level;

        Node(long hap, long level) {
            this.hap = hap;
            this.level = level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Node[] arr = new Node[K];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long like = Long.parseLong(st.nextToken());
            long level = Long.parseLong(st.nextToken());

            Node node = new Node(like, level);
            arr[i] = node;
        }

        long hap = 0;

        Arrays.sort(arr, (p1, p2) -> Long.compare(p1.level, p2.level));


        for (int i = 0; i < K; i++) {
            long a = arr[i].hap;
            long level = arr[i].level;
            pq.offer(a);
            hap += a;

            if (pq.size() > N) {
                hap -= pq.poll();
            }
            if (pq.size() == N && hap >= M) {
                bw.write(level+"\n");
                bw.flush();
                return;
            }
        }
        bw.write(-1 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
