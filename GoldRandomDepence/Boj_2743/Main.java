package org.example.GoldRandomDepence.Boj_2743;

import java.util.*;
import java.io.*;

// -10억 <= 용액 <= 10억
// 3가지 더해서 0에 가까운 용액
// 3 <= N <= 5_000

public class Main {
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long[] ans = new long[3];
        long ma = Long.MAX_VALUE;
        int start, mid, end;
        for (int i = 0; i < N - 2; i++) {
            start = i;
            mid = i + 1;
            end = N - 1;
            while (mid < end) {
                long sum = arr[start] + arr[mid] + arr[end];
                if (ma > Math.abs(sum)) {
                    ma = Math.abs(sum);
                    ans[0] = arr[start];
                    ans[1] = arr[mid];
                    ans[2] = arr[end];
                }
                if (sum == 0) {
                    break;
                } else if (sum > 0) {
                    end--;
                } else {
                    mid++;
                }
            }
        }
        Arrays.sort(ans);
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}



