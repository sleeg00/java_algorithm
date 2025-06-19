package org.example.GoldRandomDepence.Boj_20055;

import java.util.*;
import java.io.*;

// 길이가 N인 컨베이어 벨트, 길이가 2N인 벨트
// 벨트 한 칸 회전하면 Deque처럼 이동
// 1번칸 : 올리는 위치, N : 내리는 위치 (내구도)
// 로봇 : 올리는 위치에 올리거나, 로콘이 이동하면 해당 칸 내구도 -1
// 로봇 옮기는 과정
// 1 : 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 이동
// 2 : 가장 먼저 벨트에 올라간 로봇 ~ 벨트 회전 방향으로 이동가능하면 이동함
//      2-1 : 이동하려는 칸에 로봇 X, 내구도가 1이상 있어야 함
// 3 : 올라가는 위치 내구도가 0이 아니면 올리는 위치에 로봇 올림 -> 중복이 가능한가?(check)
// 4 : 내구도가 0인 칸의 개수가 K개 이상이라면 종료 (while) 아니라면 1로 이동
// ans : 종료시 몇 번째 단계가 진행 중이었는지?
public class Main {
    static int n, k;
    static int[] A;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        A = new int[2 * n];
        robot = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(simulation());

    }

    private static int simulation() {
        int cnt = 0;

        while (isOk()) {
            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전
            int tmp = A[A.length - 1];
            for (int i = A.length - 1; i > 0; i--) {
                A[i] = A[i - 1];
            }
            A[0] = tmp;

            for (int i = robot.length - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[n - 1] = false;

            // 2. 가장 먼저 벨트에 올라간 로봇부터 벨트가 회전하는 방향으로 한칸 이동 가능
            // 로봇 이동위해 이동하려는 칸에 로봇없으며 그 칸의 내구도가 1이상 남아있어야함
            for (int i = robot.length - 1; i > 0; i--) {
                if (robot[i - 1] && !robot[i] && A[i] >= 1) {
                    A[i]--;
                    robot[i] = true;
                    robot[i - 1] = false;
                }
            }

            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇 올림
            if (A[0] > 0) {
                robot[0] = true;
                A[0]--;
            }

            cnt++;
        }

        return cnt;
    }

    private static boolean isOk() {
        // 4. 내구도가 0 칸의 개수가 k개 이상이라면 과정을 종료 , 그렇지 않다면 1번으로 돌아감
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                cnt++;
            }
            if (cnt >= k)
                return false;
        }
        return true;
    }

}

