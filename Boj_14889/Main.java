package org.example.Boj_14889;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N = 0;
    static int arr[][] = new int[22][22];
    static int visit[] = new int[22];
    static int mi = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                arr[i][j] = (int)(Math.random()*50);
            }
        }

        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        dfs(new ArrayList<>(), 0, 0);
        System.out.println(mi);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);
    }

    public static void dfs(List<Integer> list, int cnt, int index) {
        if (cnt == N / 2) {
            int value = 0;
            List<Integer> compare_list = new ArrayList<>();
            int compare_value = 0;
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    value += arr[list.get(i)][list.get(j)];
                    value += arr[list.get(j)][list.get(i)];
                }
            }

            for (int i = 1; i <= N; i++) {
                if (visit[i] == 0) {
                    compare_list.add(i);
                }
            }
            ;
            for (int i = 0; i < compare_list.size(); i++) {
                for (int j = i + 1; j < compare_list.size(); j++) {
                    compare_value += arr[compare_list.get(i)][compare_list.get(j)];
                    compare_value += arr[compare_list.get(j)][compare_list.get(i)];
                }
            }
            int ans = Math.abs(compare_value - value);
            mi = Math.min(ans, mi);
        } else if (cnt < N / 2) {
            for (int i = index+1; i <= N; i++) {
                if (visit[i] == 0) {
                    visit[i] = 1;
                    list.add(i);
                    dfs(list, cnt + 1, i);
                    list.remove(list.size() - 1);
                    visit[i] = 0;
                }
            }
        }
    }
}
