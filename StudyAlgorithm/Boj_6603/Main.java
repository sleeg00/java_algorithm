package org.example.StudyAlgorithm.Boj_6603;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class result {
        int arr[];
        int ans[];

        result(int number) {
            arr = new int[number];
            ans = new int[6];
        }
    }

    static int N;
    static BufferedWriter bw;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        List<result> list = new ArrayList<>();
        int cnt = 0;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            if(N==0) break;

            list.add(new result(N));
            for (int i = 0; i < N; i++) list.get(cnt).arr[i] = Integer.parseInt(st.nextToken());

            f(list.get(cnt), 0, 0);

            bw.write("\n");
            cnt++;
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static void f(result list, int idx, int depth) throws IOException {
        if (depth == 6) {
            for (int value : list.ans) {
                bw.write(value + " ");
            }
            bw.write("\n");
            return ;
        }
        for (int i = idx; i < list.arr.length; i++) {
            list.ans[depth] = list.arr[i];
            f(list, i + 1, depth + 1);
        }
    }
}
