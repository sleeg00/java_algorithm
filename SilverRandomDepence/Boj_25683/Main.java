package org.example.SilverRandomDepence.Boj_25683;

import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        Node[] arr = new Node[T];
        long hap = 0;
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Node(x, y);
        }

        for (int i = T-2; i >=0; --i) {
            hap += (long)arr[i].x * arr[i].y * arr[T-1].y;
        }
        bw.write(hap + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
