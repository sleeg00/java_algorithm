package org.example.StudyAlgorithm.Boj_1269;

// 17:41
// 자연수 원소로 갖는 공집합 X 두 집합 A, B
// 두 집합의 대칭 차집합의 원소 개수를 출력하기
// A, B 가 존재할 때, (A-B), (B-A)의 합집합을 대칭 차집합이라고 한다.
// 교집합을 제외한 모든 원소 !
// A = {1, 2, 4}, B = {2, 3, 4, 5, 6} -> A-B = {1}, B-A = {3, 5, 6} => 대칭 차집합은 4개

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A; i++) {
            int number = sc.nextInt();
            map.put(number, 1);
        }
        for (int i = 0; i < B; i++) {
            int number = sc.nextInt();
            if (map.get(number) != null) {
                map.remove(number);
            } else {
                map.put(number, 1);
            }
        }
        System.out.println(map.size());
    }
}
