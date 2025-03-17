package org.example.Remind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static BufferedWriter bw;
    static boolean visit[];
    static int arr[];
    static int number[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        HashSet<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");


        visit = new boolean[N + 1];
        arr = new int[M];

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        int idx = 0;


        N = set.size();
        number = new int[N];

        for (int value : set) {
            number[idx++] = value;
        }
        Arrays.sort(number);
        // -- 전처리

        f(0,0);
        bw.flush();
        br.close();
        bw.close();
    }

    static void f(int idx, int depth) throws IOException {
        if (depth == M) {
            for (int value : arr) {
                bw.write(value + " ");
            }
            bw.write("\n");
            return ;
        }

        for (int i = idx; i < N; i++) {
            arr[depth] = number[i];
            f(i, depth + 1);
        }
    }

}
