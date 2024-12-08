package org.example.Boj_1629;

import java.util.*;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    int first() {
        return first;
    }

    int second() {
        return second;
    }
}

// 0.5초 128MB
/*
문제 정의
A를 B번 곱하고 %C 한 나머지를 구하자
-----------------
조건
1. 1 <= A,B,C <= 2147483647
-----------------
풀이 접근
1. Long, Int형으로는 처리 불가
2. 모듈러 연산?
-> A * B % C = X,   A
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt();
        long B = sc.nextInt();
        long C = sc.nextInt();
        long im = A;
        sc.nextLine();
        for (int i = 0; i < B; i++) {
            System.out.println(A % C);
            A *= im;
        }
    }
}
