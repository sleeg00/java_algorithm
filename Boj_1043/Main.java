package org.example.Boj_1043;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashSet<Integer> true_set = new HashSet<>();
        int person_count = Integer.parseInt(st.nextToken());
        int party_count = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int true_person_count = Integer.parseInt(st.nextToken());
        int ans = party_count;
        HashSet<Integer>[] person_set = new HashSet[party_count];
        for (int i = 0; i < true_person_count; i++) {
            true_set.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < party_count; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int party_join_person_count = Integer.parseInt(st.nextToken());
            person_set[i] = new HashSet<>();
            Boolean check = true;
            for (int j = 0; j < party_join_person_count; j++) {
                int person_number = Integer.parseInt(st.nextToken());
                person_set[i].add(person_number);
                if (true_set.contains(person_number) && check) {
                    check = false;
                }
            }
            if (!check) {
                for (int number : person_set[i]) {
                    true_set.add(number);
                }
            }
        }
        for (int i = 0; i < party_count; i++) {
            for (int number : true_set) {
                if (person_set[i].contains(number)) {
                    ans--;
                    break;
                }
            }
        }
        System.out.print(ans);
    }
}
