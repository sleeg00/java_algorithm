package org.example.Boj_1439;

import java.util.*;

// (조건) 0과 1로 이루어진 문자열
// (조건) 연속된 하나 이상의 숫자를 잡고 모두 뒤집을 수 있다.
//  뒤집는다 : 0 -> 1,  1 -> 0 으로 바꾸는 것
// (문제 상황) 문자열 숫자를 전부 같게 만들어야 한다. 같게 하는데 최소 횟수는?
// 직관 : 연속된 1의 개수, 0의 개수를 구한다.
// ex) 101110010100
// ->  111231211112
// 0로 바꿀 경우 arr[i] == 0 && arr[i-1] ==1 바꾼다 1회
// 1로 바꿀 경우 arr[i] == 1 && arr[i-1]==0
//
//
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int cnt = 0;
        int cnt2 = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0' && s.charAt(i - 1) == '1') { // 0으로 바꿀 경우
                cnt++;
            } else if (s.charAt(i) == '1' && s.charAt(i - 1) == '0') { // 1로 바꿀 경우
                cnt2++;
            }
        }
        if(s.charAt(s.length()-1)=='1') {
            cnt++;
        } else {
            cnt2++;
        }

        System.out.println(Math.min(cnt,cnt2));
    }
}
