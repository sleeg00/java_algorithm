package org.example.Boj_1717;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

// 2초 128MB
// N+1개의 집합 (0~N)이 있다.
// 합집합 연산, 두 원소가 같은 집합에 포함되어 있는지(교집합) 확인하는 연산을 수행할려고 한다.
// 집합을 표현하는 프로그램을 작성해라
// -----------------
// 입력
// 1 <= N <= 1,000,000 , 1 <= M <= 100,000
// M : 입력으루 주어지는 연산의 개수
// m개 줄에는 각각의 연산 주어짐
// 합집합 : 0 a b의 형태로 주어짐 (0으로 분리)
// => a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미
// 두 원소(교집합) 1 a b 형태 (1로 분리)
// a와 b가 집합의 포함되어 있는지는 확인하는 연산
// a,b => 정수, a,b가 같을 수도 있다.
// 결과
// 1로 시작하는 입력에서 a와 b가 집합에 포함되어 있는 YES else No
// 7, 8로 주어진다면
// 0~7까지 정수 집합 존재
// 1, 3이 포함되어 있는 집합끼리 합침 {1,3}
// 1, 7이 같은 집합에 포함되지 않음
// 7, 6이 포함된 집합 합ㅂ침 {7,6}
// 7,1이 같은 집합에 포함되지 않음
// {3,7} => {1,3,6,7}
// {4,2} => {1,3,6,7}, {4,2}
// {0,1} => {0,1,3,6,7} , {4,2}
// {1,1} => {0,1,3,6,7}, {4,2}
// v[1] = 3. v[3] = 1
// v[6] = 7; v[7] = 6
// v[3] = 1, 7, v[7] = 3
// dfs(3) -> 1 ->7 - > 6 존재. ok

public class Main {

    static int[] arr;
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //n : 집합의 수
        int M = Integer.parseInt(st.nextToken()); //m :연산의 수

        arr = new int[N + 6];
        for (int i = 0; i <= N + 5; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < M; i++) {
            check = false;
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x == y && command == 1) {
                System.out.println("YES");
            } else {
                if (command == 0) { // 집합 합치기
                    union(x, y);
                } else if (command == 1) {
                    check = dfs(x, y);
                    if (check == true) {
                        bw.write("YES" + "\n");
                    } else {
                        bw.write("NO" + "\n");
                    }
                }
            }
            bw.flush();
        }
        bw.close();
        br.close();
    }


    private static boolean dfs(int x, int y) {
        int a = find(x);
        int b = find(y);
        return a == b;
    }

    private static void union(int x, int y) {
        int x1 = find(x);
        int x2 = find(y);
        arr[x1] = x2;
    }

    private static int find(int a) {
        if (a == arr[a]) {
            return a;
        }
        return arr[a] = find(arr[a]);
    }
}
