package org.example.StudyAlgorithm.Boj_4949;

import java.util.*;
// 14:55
// 1초, 128MB
// 문자열이 주어짐, 괄호들의 균형이 잘 맞는지 판별하는 문제
// 괄호 종류 : (), [] 로 2종류, 조건은
// 1. ( = ) , [ = ] 로만 짝을 이룬다
// 2. ),] = 짝을 이룰 수 있는 (.[ 가 존재한다.
// 3. 괄호들 짜긍ㄴ 1:1 매칭만 가능, 괄호 하나가 둘 이상 괄호가 짝지어지지 안흔다
// 4. 짝을 이루는 두 괄호 -> 그 사이 문자열도 균형이 잡혀야 한다 !
// 제한 사항 : 마지막은 온점 (.)으로 끝난다
// 1. .으로 문자를 분리해 String 배열에 저장한다.
// 2. (을 스택에 담고 ) 을 만나면 pop을 한다.
// 3. stack size가 0보다 크면 No 출력

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Character> mini = new Stack<>();

        while (true) {
            String str = sc.nextLine();
            if (str.charAt(0) == '.') {
                break;
            }
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    mini.push('(');
                } else if (str.charAt(i) == ')') {
                    if (!mini.empty() && mini.peek() =='(') {
                        mini.pop();
                    } else {
                        mini.push(')');
                    }
                }
                if (str.charAt(i) == '[') {
                    mini.push('[');
                } else if (str.charAt(i) == ']') {
                    if (!mini.empty() && mini.peek() =='[') {
                        mini.pop();
                    } else {
                        mini.push(']');
                    }
                }

            }
            if (mini.empty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
                mini.clear();
            }

        }
    }
}
