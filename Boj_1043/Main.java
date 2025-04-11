package org.example.Boj_1043;

import java.util.*;
import java.io.*;

public class Main {
    static int person_number, party_number;
    static int[] parents;
    static List<Integer> know_true_story_person_list;
    static List<Integer>[] party_list;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Main() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        initPersonNumberAndParty();
        initUnionFindValue();
        initKnowTrueStoryOfPerson();

        for (int i = 0; i < party_number; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int attend_person_number = Integer.parseInt(st.nextToken());
            int attend_person_id = Integer.parseInt(st.nextToken());

            party_list[i].add(attend_person_id);
            for (int j = 1; j < attend_person_number; j++) {
                int y = Integer.parseInt(st.nextToken());
                union(attend_person_id, y);
                party_list[i].add(y);
            }
        }

        int cnt = 0;
        for (int i = 0; i < party_number; i++) {
            boolean flag = true;
            for (int num : party_list[i]) {
                if (know_true_story_person_list.contains(find(parents[num]))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    private static void initKnowTrueStoryOfPerson() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int person_number = Integer.parseInt(st.nextToken());
        know_true_story_person_list = new ArrayList<>();
        for (int i = 0; i < person_number; i++) {
            know_true_story_person_list.add(Integer.parseInt(st.nextToken()));
        }
    }

    private static void initUnionFindValue() {
        parents = new int[person_number + 1];
        for (int i = 1; i <= person_number; i++) {
            parents[i] = i;
        }
    }

    private static void initPersonNumberAndParty() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        person_number = Integer.parseInt(st.nextToken());
        party_number = Integer.parseInt(st.nextToken());
        initPartyList();
    }

    private static void initPartyList() {
        party_list = new ArrayList[party_number];
        for (int i = 0; i < party_number; i++) {
            party_list[i] = new ArrayList<>();
        }
    }


    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (know_true_story_person_list.contains(y)) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        parents[y] = x;
    }
}
