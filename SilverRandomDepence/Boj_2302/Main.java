package org.example.SilverRandomDepence.Boj_2302;

import java.util.*;
import java.io.*;

// 자리 자리 왼쪽 오른쪽 앉을 수 있다
// VIP는 반드시 자기 좌석 앉아야 함
// 1 ~ N번 좌석 매진, VIP 좌석 주어지고 사람들이 좌서에 앉는 서로 다른 방법 가짓수는?
// VIP전까지 가능한 경우의 수
// ex)1
// 1

// ex)2
// 1 2
// 2 1

// ex) 3
// 1 2 3
// 1 3 2
// 2 1 3

// ex) 4

// 1 2 3 4
// 1 2 4 3
// 1 3 2 4
// 2 1 3 4
// 2 1 4 3

// ex)5
// 1 2 3 4 5
// 1 2 3 5 4
// 1 2 4 3 5
// 1 3 2 4 5
// 1 3 2 5 4
// 2 1 3 4 5
// 2 1 3 5 4
// 2 1 4 3 5

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] Dp = new long[50];
        Dp[0] = 1;
        Dp[1] = 1;
        Dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            Dp[i] = Dp[i - 1] + Dp[i - 2];
        }
        int M = Integer.parseInt(br.readLine());
        long hap = 1;
        int index = 0;
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(br.readLine());
            hap *= Dp[number - index - 1];
            index = number;
        }
        hap *= Dp[N - index];
        System.out.println(hap);
    }
}
