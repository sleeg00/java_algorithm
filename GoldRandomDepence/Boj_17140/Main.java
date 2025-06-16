package org.example.GoldRandomDepence.Boj_17140;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

// 3 x 3 배열
// R 연산 : 배열의 모든 행에 대해서 정렬 수행 행 개수 >= 열 개수 일때만
// C 연산 : 배열의 모든 열에 대해서 정렬 수행 행 개수 <  열 개수 일때만
// 각각의 수가 몇 번 나왔는지?
// 수의 등장 횟수가 커지는 순으로 (중복시 오름차순 정렬)
// 배열 A에 정렬된 결과로 초기화, 수와 등장 횟수를 모두 넣고, 순서는 수가 먼저
// [수의 등장 횟수 오름차순 -> 중복시 수 오름차순][수 등장 횟수]
public class Main {
    public static class Node {
        int number, countOfNumber;

        public Node(int number, int countOfNumber) {
            this.number = number;
            this.countOfNumber = countOfNumber;
        }
    }

    static int R, C, K, row=3, col=3;
    static int[][] map = new int[101][101], temp = new int[101][101];
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    static ArrayList<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        while (true) {
            temp = new int[101][101];
            if (map[R-1][C-1]==K) break;
            if(cnt>100) {
                cnt=-1;
                break;
            }
            if(row >= col) {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++)
                        changeHashMap(map[i][j]);
                    if(hashMap.isEmpty()) continue;
                    sorting();
                    initList(i);
                    hashMap.clear();
                    list.clear();
                }
            } else {
                for (int i = 0; i < col; i++) {
                    for (int j = 0; j < row; j++)
                        changeHashMap(map[j][i]);
                    if(hashMap.isEmpty()) continue;
                    sorting();
                    initListCol(i);
                    hashMap.clear();
                    list.clear();
                }
            }
            map = temp;
            cnt++;
        }
        System.out.println(cnt);
    }
    private static void initListCol(int idx) {
        row = Math.max(row,list.size()*2);
        int i = 0;
        for(Node node : list){
            temp[i++][idx] = node.number;
            temp[i++][idx] = node.countOfNumber;
        }
    }

    private static void initList(int idx) {
        col= Math.max(col, list.size()*2);
        int i = 0;
        for(Node node : list){
            temp[idx][i++] = node.number;
            temp[idx][i++] = node.countOfNumber;
        }
    }

    private static void sorting() {
        for(Integer key : hashMap.keySet())	//숫자 반복횟수 리스트에 저장
            list.add(new Node(key, hashMap.get(key)));
        Collections.sort(list, (p1,p2) -> {
            if (p1.countOfNumber == p2.countOfNumber) { // 등장 횟수가 같으면
                if (p1.number < p2.number) return -1;
                return 1;
            }
            if (p1.countOfNumber < p2.countOfNumber) return -1;
            return 1;
        });
    }

    private static void changeHashMap(int value) {
        if (value != 0) {
            if (!hashMap.containsKey(value)) {
                hashMap.put(value, 1); // 숫자, 등장 횟수
            } else {
                hashMap.put(value, hashMap.get(value) + 1);
            }
        }
    }
}
