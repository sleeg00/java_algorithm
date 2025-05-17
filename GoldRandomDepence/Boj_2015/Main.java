package org.example.GoldRandomDepence.Boj_2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long[] A = new long[N + 1];

        st = new StringTokenizer(br.readLine(), " ");

        long[] sum = new long[N+1];
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
            if(i==0) sum[i] = A[i];
            else sum[i] = sum[i-1] + A[i];
        }

        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);

        long count = 0;

        for (int i = 0; i < N; i++) {
            if (map.containsKey(sum[i] - K)) {
                count += map.get(sum[i] - K);
            }

            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }

        System.out.println(count);
    }
}
