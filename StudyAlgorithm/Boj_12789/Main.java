package org.example.StudyAlgorithm.Boj_12789;

import java.util.*;

// 15:50
// 줄 다시서기
// 대기열 왼쪽 1열 공간 존재
// 모든 사람들이 순서대로 간식을 받을 수 있는지 확인하는 문제
// 5, 4, 1, 3, 2로 줄을 서 있다면
// 5, 4 번은 Queue -> 1번 받기
// 5,4,3  Queue -> 2번 받기
// 순서대로 pop
// 그렇지 않으면 SAD 출력
// queue에 계속 넣다가 i번째가 cnt : 1 이 맞다면 cnt를 더한다.
// 만약 i번째가 맞지 않는다면 peek()를 확인한다 pop이 순서에 맞지 않는다면 SAD 출력
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Stack<Integer> stack= new Stack<>();

        int cnt = 1;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int sw=0;
            if(cnt==x) {
                sw=1;
                cnt++;
            }
            while(!stack.isEmpty()) {
                if(stack.peek()==cnt) {
                    stack.pop();
                    cnt++;
                } else {
                    break;
                }
            }
            if (sw==0) {
                stack.push(x);
            }
        }

        if(!stack.isEmpty()) {
            System.out.println("Sad");
        } else {
            System.out.println("Nice");
        }
    }
}
