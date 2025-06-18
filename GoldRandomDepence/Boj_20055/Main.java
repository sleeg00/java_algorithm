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
    public static class Node {
        int health;
        boolean robot;

        Node(int health, boolean robot) {
            this.health = health;
            this.robot = robot;
        }
    }

    static int step = 1;
    static int lengthOfBelt, K;
    static ArrayDeque<Node> deque = new ArrayDeque<Node>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        lengthOfBelt = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < lengthOfBelt; i++) {
            deque.addLast(new Node(Integer.parseInt(st.nextToken()), false));
        }

        while (true) {
            forwardOfBelt();// 1번
            // 2번
            healthZeroCountEqualsK();// 4번

            // 3번
            healthZeroCountEqualsK();// 4번
            step++;
        }
        System.out.print(step);
    }

    private static void forwardOfBelt() {
        Node endPoint = deque.pollLast();
        deque.addFirst(endPoint);
        getOffEndPointRobot(endPoint);
    }

    private static void getOffEndPointRobot(Node endPoint) {
        if(endPoint.robot) endPoint.robot = false;
    }
}
