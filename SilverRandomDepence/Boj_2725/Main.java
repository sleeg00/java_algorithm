package org.example.SilverRandomDepence.Boj_2725;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[1005];
        arr[0] = 0;
        arr[1] = 3;
        for (int i = 2; i <= 1001; i++) {
            int value = 0;
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) == 1) {
                    value++;
                }
            }
            arr[i] = arr[i - 1] + value * 2;
        }
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            bw.write(arr[value] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
