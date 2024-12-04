package org.example.Boj_17609;

import java.util.*;

// 정의
// 회문 or 펠린드롬은 <-,-> 방향으로 같은 순서의 문자로 구성된 문자열이다.
// ex) "abba", "kayak", "reviver"...
// 문자열이 회문이 아니지만 한 문자를 삭제해 회문으로 만들수 있는지?
// 회문이면 0, 만들 수 있는 회문이면 1, 그 외 2 출력
//-------------------------------------------------/
// 조건
// 1 <= 문자 개수(T) <= 30, 3 <= 문자 길이 <= 100,000 (알파벳 소문자)
//-------------------------------------------------/
// 해결 방안
// 1. Tow Pointer
// 2. 0번 Index, length()-1 Index = x, y
// 3. x == y -> x+1, y-1, else x+1==y x+1, x+=2, y-1, else x==y-1 => x+1, y-2 =>sw=1
// 4. sw==2이면 break 2, sw==0 print(0) else print(1)
// ex) aaabbbaaac
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, y;
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            String str = sc.nextLine();
            x = 0;
            y = str.length() - 1;
            int sw=0;
            while (x < y) {

                if (str.charAt(x) == str.charAt(y)) {
                    x++; y--;
                } else if (str.charAt(x + 1) == str.charAt(y)) {
                    x += 2; y--;
                    sw++;
                } else if (str.charAt(x) == str.charAt(y - 1)) {
                    x++; y -= 2;
                    sw++;
                } else {
                    sw=2;
                    break;
                }
            }
            x=0;
            y=str.length()-1;
            int im = 0;
            while (x < y) {
                if (str.charAt(x) == str.charAt(y)) {
                    x++; y--;
                }  else if (str.charAt(x) == str.charAt(y - 1)) {
                    x++; y -= 2;
                    im++;
                } else if (str.charAt(x + 1) == str.charAt(y)) {
                    x += 2; y--;
                    im++;
                } else {
                    im=2;
                    break;
                }
            }
            System.out.println(Math.min(sw,im));
        }
    }
}
