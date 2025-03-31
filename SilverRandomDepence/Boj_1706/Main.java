package org.example.SilverRandomDepence.Boj_1706;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] arr = new char[R][C];
        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i<R; i++) {
            String str = br.readLine();
            for(int p =0; p<C; p++) {
                arr[i][p] = str.charAt(p);
            }
        }

        for(int i=0; i<R; i++) {
            String str = "";
            for(int p=0; p<C; p++) {
                if(arr[i][p]=='#') {
                    if(str.length()>1) {
                        list.add(str);
                    }
                    str="";
                } else {
                    str+=arr[i][p];
                    if(p==C-1) {
                        if(str.length()>1) {
                            list.add(str);
                            str="";
                        }
                    }
                }
            }
        }
        for(int i=0; i<C; i++) {
            String str = "";
            for(int p=0; p<R; p++) {
                if(arr[p][i]=='#') {
                    if(str.length()>1) {
                        list.add(str);
                    }
                    str="";
                } else {
                    str+=arr[p][i];
                    if(p==R-1) {
                        if(str.length()>1) {
                            list.add(str);
                            str="";
                        }
                    }
                }
            }
        }
        Collections.sort(list);
        bw.write(list.get(0)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
