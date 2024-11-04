package org.example.Boj_2869;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();

        V-=A;
        int day = V/(A-B);
        int mock = V%(A-B);
        if(mock!=0) {
            System.out.println(day+2);
        } else {
            System.out.println(day+1);
        }
    }
}
