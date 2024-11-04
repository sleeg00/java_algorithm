package org.example.Boj_1193;

import static java.lang.System.exit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int x = 1;
        int y = 2;
        int cnt = 2;
        if (N == 1) {
            System.out.println("1/1");
            exit(0);
        } else if (N == 2) {
            System.out.println("1/2");
            exit(0);
        }

        int sw = 0;
        while (cnt != N) {
            if (x % 2 == 0 && y == 1) {
                x++;
                y = 1;
                sw = 1;
            } else if (y % 2 == 1 && x == 1) {
                x = 1;
                y++;
                sw = 0;
            } else if (sw == 0) {
                x++;
                y--;
            } else if (sw == 1) {
                x--;
                y++;
            }
            cnt++;
        }
        System.out.println(x + "/" + y);
    }
}
