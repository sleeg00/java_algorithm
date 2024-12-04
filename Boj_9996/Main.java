package org.example.Boj_9996;

import java.util.Scanner;

// 문제 정의
// 패턴 = 알파벳 소문자, 별포 1개 로 이루어짐
// 패턴에 있는 '*'을 알파벳 소문자로 이루어진 문자열로 변환해 파일 이름과 같게 만들수 있어야 한다.
//-----------------------------
// (조건)
// 별포는 ' ' (빈 문자열)로 바꿀 수도 있다.
// ex) "abcd", "ad", "anestonestod"는 패턴 a*d와 일치, "bcd"는 일치하지 않음
// 1 <= 파일 개수(N) <= 100
// 패턴 = 알파벳 소문자와 별표 1개 (알파벳은 여러개 가능)
// 문자열 길이 <= 100
//---------------------------
// 예외 생각
// a*d 가능 , *ad 가능 ad* 가능, aa*d, a*bbbbbd 가능 => 마지막과 앞에 '*'가 오면 하나만 체크 중간이면 끝과 시작 체크
// 공백 생각해야함
// 해결 방안
// 1. 중간에 '*'가 있을 경우 : Pattern의 앞, 뒤 문자열과 str의 앞, 뒤가 같은지 Check
// 2. 앞에 '*'가 있을 경우 : Pattern의 뒤 문자열, str의 뒤 문자열 같은지 check
// 3. 뒤에 '*'가 있을 경우 : Pattern의 앞 문자열, str의 앞 문자열 같은지 check
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String pattern = sc.nextLine();
        int sw = 0;
        int x = 0, y = 0;
        if (pattern.charAt(0) == '*') {
            sw = 0;
        } else if (pattern.charAt(pattern.length() - 1) == '*') {
            sw = 1;
        } else {
            sw = 2;
            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == '*') {
                    x = i - 1;
                    y = pattern.length() - 1 - (i + 1);
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            if (sw == 0) {
                int index = pattern.length() - 1;
                while (true) {
                    if (str.charAt(index) != pattern.charAt(index)) {
                        System.out.println("NE");
                        break;
                    }
                    index--;
                    if (index == 0) {
                        System.out.println("DA");
                        break;
                    }
                }
            } else if (sw == 1) {
                int index = 0;
                while (true) {
                    if (str.charAt(index) != pattern.charAt(index)) {
                        System.out.println("NE");
                        break;
                    }
                    index++;
                    if (index == pattern.length() - 1) {
                        System.out.println("DA");
                        break;
                    }
                }
            } else {
                int check = 0;
                for (int j = 0; j <= x; j++) {

                    if (str.charAt(j) != pattern.charAt(j)) {
                        check = 1;
                        break;
                    }
                }
                for (int j = 0; j <= y; j++) {
                    if (str.charAt(str.length() - 1 - j) != pattern.charAt(pattern.length() - 1 - j)) {
                        check = 1;
                        break;
                    }
                    if(str.length()-1-j <= x) {
                        check = 1;
                        break;
                    }
                }
                if (check == 1) {
                    System.out.println("NE");
                } else {
                    System.out.println("DA");
                }
            }
        }
    }
}
