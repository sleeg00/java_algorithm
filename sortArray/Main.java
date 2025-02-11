package org.example.sortArray;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
        //내림차순
        Collections.sort(list, (p1, p2) -> p1.compareTo(p2));
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
