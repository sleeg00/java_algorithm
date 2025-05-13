package org.example.StudyAlgorithm.Boj_10809;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = new int[30];
        String str = sc.nextLine();

        for (int i = 0; i < 30; i++) {
            arr[i] = -1;
        }
        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i) - 97] == -1) {
                arr[str.charAt(i) - 97] = i;
            }
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
