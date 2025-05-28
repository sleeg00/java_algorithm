package org.example.StudyAlgorithm.Boj_13458;

import java.util.*;
import java.io.*;

// N개 시험장, 시험장마다 응시자 존재, i번 시함장에 있는 응시자수 Ai명
// 감독 총감독/부감독
// 총감독 감시자수 : B, 부감독 감시자수 : C
// 총감독은 1명, 부감독은 여러명
// 응시자들을 모두 감시할 때, 필요한 감독관 수의 최솟값은?
// 1 <= N(시험장) <= 1,000,000
// 1 <= Ai(응시자 수) <= 1,000,000
// 1 <= B(총감독 감시 가능 인원),C(부감독 감시 가능 인원) <= 1,000,000
public class Main {
    static long N, B, C, ans;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < N; i++) {
            arr[i] -= B; // 총 감독 감시자수 제거
            ans++;
            if (arr[i] <= 0) {
                continue;
            }
            if (arr[i] % C == 0) {
                ans += arr[i] / C;
            } else if (arr[i] / C == 0) {
                ans++;
            } else {
                ans += arr[i] / C + 1;
            }
        }
        System.out.print(ans);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        arr = new long[(int) N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
    }
}
