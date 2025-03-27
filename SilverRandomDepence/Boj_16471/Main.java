package org.example.SilverRandomDepence.Boj_16471;

import java.util.*;
import java.io.*;

// N장의 카드 (홀수)
// 각자 1장씩 카드 수 비교
// 더 작은 카드 1점
// N번 승부후 (N+1)/2 >= => 승리
// (N+1)/2 점 이상 점수 획득이 없을 경우 승자 X

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Integer[] ju = new Integer[N];
        Integer[] sa = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            ju[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            sa[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ju, Collections.reverseOrder());
        Arrays.sort(sa, Collections.reverseOrder());
        int x = 0;
        int y = 0;
        int cnt = 0;
        while (x < N) {
            if (ju[x] < sa[y]) {
                cnt++;

                y++;
            }
            x++;
            if (cnt >= (N + 1) / 2) {
                bw.write("YES\n");
                bw.flush();
                return;
            }
        }
        bw.write("NO\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
