package org.example.SilverRandomDepence.Boj_14627;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        long right=-1, hap = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(arr[i], right);
            hap += arr[i];
        }

        long left = 1, mid, cnt, ma = 0;
        while (left <= right) {
            cnt = 0;
            mid = (left + right) / 2;
            for (int i = 0; i < N; i++) {
                cnt += (arr[i] / mid);
            }
            if (cnt >= M) {
                ma = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.print(hap - ma * M);
    }
}
