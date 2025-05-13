package org.example.StudyAlgorithm.Boj_9095;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[13];
        arr[1]=1;
        arr[2]=2;
        arr[3]=4;
        for(int i=4; i<=12; i++) {
            arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
        }
        for(int i=0; i<N; i++) {
            bw.write(arr[Integer.parseInt(br.readLine())]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
