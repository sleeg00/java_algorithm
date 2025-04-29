//package org.example.SilverRandomDepence.Boj_1062;
//
//import java.util.*;
//import java.io.*;
//
//// k개의 글자
//// anta ** tica
//// 1 <= N (단어 개수) <= 50
//// 0 <= K(가르칠 글자) <= 26
//public class Main {
//    static int total_word_count, know_word_count;
//    static HashSet<Character>[] words;
//    static HashSet<Character> total = new LinkedHashSet<>();
//    static char[] ch;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        total_word_count = Integer.parseInt(st.nextToken());
//        know_word_count = Integer.parseInt(st.nextToken());
//        if (!checkError()) {
//            System.out.println(0);
//            return;
//        }
//        initWords(br);
//        ch = new char[know_word_count];
//        int index = 0;
//        for (Character value : total) {
//            ch[index++] = value;
//        }
//        back(4);
//    }
//
//    private static void back(int count) {
//        if (count > know_word_count) {
//
//        }
//        for (int i = 0; )
//
//    }
//
//    private static boolean checkError() {
//        if (know_word_count < 5) {
//            return false;
//        }
//        return true;
//    }
//
//    private static void initWords(BufferedReader br) throws IOException {
//        words = new HashSet[total_word_count];
//        total.add('a');
//        total.add('n');
//        total.add('i');
//        total.add('c');
//        total.add('t');
//        for (int count = 0; count < total_word_count; count++) {
//            String str = br.readLine();
//            for (int i = 4; i < str.length() - 4; i++) {
//                words[i].add(str.charAt(i));
//                total.add(str.charAt(i));
//            }
//        }
//    }
//}
