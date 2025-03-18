package org.example.Boj_1074;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N, count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        f((int) Math.pow(2, N), R, C);
        System.out.println(count);
    }

    static void f(int size, int R, int C) {
        if(size==1) {
            return;
        }
        if (R < size / 2 && C < size / 2) {
            count += 0;
            f(size / 2, R, C);
        } else if (R < size / 2 && C >= size / 2) {
            count += (size * size / 4) * 1;
            f(size / 2, R, C - size / 2);
        } else if (R >= size / 2 && C < size / 2) {
            count += (size * size / 4) * 2;
            f(size / 2, R - size / 2, C);
        } else {
            count+=(size*size/4)*3;
            f(size/2, R-size/2, C-size/2);
        }
    }
}
