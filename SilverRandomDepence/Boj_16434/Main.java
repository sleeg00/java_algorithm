package org.example.SilverRandomDepence.Boj_16434;

import java.util.*;
import java.io.*;

// N : 방 개수, 공격력 : Atack
// 3 : 3
// 1 : 공격력 1 생명력 20
// 2 : 공격력 3 증가, 현재 생명력 10 증가
// 예외 처리
// 1일 때 1. health += mon_attack * (mon_health/attack)+1
// 2일 때 1. health -= potion & Attack+=plus_attack;
// 마지막일 때 :  value = mon_attack * (mon_health/attack)
// value+1 - health >0  health+=(value-health)  ELSE
public class Main {
    static int N, Attack;
    static long health;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        Attack = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        long left = 0, right = 1_000_000_000_000_000_000L;

        while (left <= right) {
            long mid = (left + right) / 2;
            long health = mid;
            long copy_attack = Attack;
            boolean visit = true;
            for (int i = 0; i < N; i++) {
                if (arr[i][0] == 1) {
                    if(arr[i][2]%copy_attack==0) {
                        health -= arr[i][1]*(arr[i][2]/copy_attack-1);
                    } else {
                        health -= arr[i][1] * (arr[i][2]/copy_attack);
                    }

                    if (health <= 0) {
                        visit = false;
                        break;
                    }
                } else {
                    copy_attack += arr[i][1];
                    health += arr[i][2];
                    if(health > mid) health = mid;
                }
            }
            if (visit) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(left);
    }

}
