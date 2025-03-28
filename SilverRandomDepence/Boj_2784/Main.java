package org.example.SilverRandomDepence.Boj_2784;

import java.util.*;
import java.io.*;

public class Main {
    static char[][] ch = new char[3][3];
    static String[] str = new String[6];
    static boolean[] visit = new boolean[6];
    static HashMap<String, Integer> map = new HashMap<>();
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 6; i++) {
            str[i] = br.readLine();
            if (!map.containsKey(str[i])) {
                map.put(str[i], 0);
            }
            map.put(str[i], map.get(str[i]) + 1);
        }
        for (int i = 0; i < 6; i++) {
            visit[i] = false;
        }
        back(0);
        if (list.size() == 0) {
            bw.write("0\n");
            bw.flush();
            return;
        }
        Collections.sort(list);

        for (int i = 0; i < list.get(0).length(); i += 3) {
            for (int j = i; j < i + 3; j++) {
                bw.write(list.get(0).charAt(j));
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void back(int idx) {
        if (idx == 3) {
            String copy = "";
            HashMap<String, Integer> compare = new HashMap<>();
            for (int i = 0; i < 3; i++) {
                String s = "";
                for (int j = 0; j < 3; j++) {
                    s += ch[j][i];
                }
                if (!compare.containsKey(s)) {
                    compare.put(s, 0);
                }
                compare.put(s, compare.get(s) + 1);
                copy += String.valueOf(ch[i]);
                if(!compare.containsKey(String.valueOf(ch[i]))) {
                    compare.put(String.valueOf(ch[i]),0);
                }
                compare.put(String.valueOf(ch[i]), compare.get(String.valueOf(ch[i]))+1);
                if (!map.containsKey(s)) {
                    return;
                }
                if(compare.get(s)>map.get(s)) return;
                if(compare.get(String.valueOf(ch[i])) > map.get(String.valueOf(ch[i])) ){
                    return;
                }

            }

            list.add(copy);
            return;
        }
        for (int i = 0; i < 6; i++) {
            if (!visit[i]) {
                visit[i] = true;
                ch[idx][0] = str[i].charAt(0);
                ch[idx][1] = str[i].charAt(1);
                ch[idx][2] = str[i].charAt(2);
                back(idx + 1);
                visit[i] = false;
            }
        }
    }
}
