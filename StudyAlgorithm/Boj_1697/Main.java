package org.example.StudyAlgorithm.Boj_1697;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int visit[] = new int[200005];
        queue.addLast(N);
        for (int i = 0; i <= 200003; i++) {
            visit[i] =-1;
        }
        visit[N] = 0;

        while (!queue.isEmpty()) {
            int value = queue.pollFirst();
            if(value==M) {
                bw.write(visit[M] + " ");
                break;
            }
            if (value - 1 >= 0 && visit[value-1]==-1) {
                visit[value - 1] = visit[value] + 1;
                queue.addLast(value - 1);
            }
            if (value * 2 <= 100000 && visit[value*2]==-1) {
                visit[value * 2] = visit[value] + 1;
                queue.addLast(value * 2);
            }
            if (value + 1 <= 100000 && visit[value+1]==-1) {
                visit[value + 1] = visit[value] + 1;
                queue.addLast(value + 1);
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
