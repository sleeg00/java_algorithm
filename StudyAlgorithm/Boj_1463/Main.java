package org.example.StudyAlgorithm.Boj_1463;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bufferedReader.readLine());
        int arr[] = new int[N + 10];
        arr[1] = 0;
        arr[2] = 1;
        for (int i = 3; i <= N; i++) {
            int compare_first = Integer.MAX_VALUE;
            int compare_second = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                compare_first = arr[i / 3] + 1;
            }
            if (i % 2 == 0) {
                compare_second = arr[i / 2] + 1;
            }
            arr[i] = Math.min(Math.min(compare_first, compare_second), arr[i-1]+1);

        }
        bw.write(arr[N] + " ");
        bw.flush();
        bw.close();
        bufferedReader.close();
    }
}
