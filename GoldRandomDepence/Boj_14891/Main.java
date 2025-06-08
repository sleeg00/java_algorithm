package org.example.GoldRandomDepence.Boj_14891;

import java.util.*;
import java.io.*;

// 8개의 톱니, N극 또는 S극, 1번 .. 4번
// 회전시킬 톱니바퀴와 뱡향 결정,
//  1. 서로 맞닿은 극에 따라서 옆에 있는 톱니바퀴 회전하거나, 회전시키지 않을수 있다.
//  2. A톱니바퀴, B톱니바퀴 극이 다르면 B는 A가 회전한 반대방향으로 회전한다, 같으면 회전 X,

// 0 : N , 1 : S
// if(arr[number][2]) -> 회전 전 [2]얻어서 move(number-1, 회전 전 [2]), move(number+1, 회전 전[2])
//
public class Main {
    static String[] strArr = new String[4];
    static int turnCount, ans;

    public static void main(String[] args) throws IOException {
        init();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            strArr[i] = br.readLine();
        }
        turnCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < turnCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int indexOfWheel = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());
            moveBackWheel(indexOfWheel - 1, -dir);
            moveFrontWheel(indexOfWheel + 1, -dir);
            turnWheel(indexOfWheel, dir);
        }

        for (int i = 0; i < 4; i++) {
            if (strArr[i].charAt(0) != '0') {
                ans += Math.pow(2, i);
            }
        }
        System.out.println(ans);
    }

    private static void moveBackWheel(int indexOfWheel, int dir) {
        if (indexOfWheel < 0) return;
        if (strArr[indexOfWheel].charAt(2) == strArr[indexOfWheel + 1].charAt(6)) return;

        // 재귀 끝나고 회전
        moveBackWheel(indexOfWheel - 1, -dir);
        turnWheel(indexOfWheel, dir);
    }

    private static void moveFrontWheel(int indexOfWheel, int dir) {
        if (indexOfWheel > 3 ) return;
        if (strArr[indexOfWheel].charAt(6) == strArr[indexOfWheel - 1].charAt(2)) return;

        // 재귀 끝나고 회전
        moveFrontWheel(indexOfWheel + 1, -dir);
        turnWheel(indexOfWheel, dir);
    }

    private static void turnWheel(int indexOfWheel, int dir) {
        if (dir == 1) {
            String str = strArr[indexOfWheel].substring(0, 7);
            String str2 = strArr[indexOfWheel].substring(7, 8);
            strArr[indexOfWheel] = str2 + str;
        } else if (dir == -1) {
            String str = strArr[indexOfWheel].substring(1, 8);
            String str2 = strArr[indexOfWheel].substring(0, 1);
            strArr[indexOfWheel] = str + str2;
        }
    }
}
