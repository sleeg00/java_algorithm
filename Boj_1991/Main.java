package org.example.Boj_1991;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        Node left, right;
        String root;

        Node(String root) {
            this.root = root;
        }
    }

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Map<String, Node> tree = new HashMap<>();  // 노드 저장용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            tree.putIfAbsent(root, new Node(root));
            Node current = tree.get(root);

            if(!left.equals(".")) {
                tree.putIfAbsent(left, new Node(left));
                current.left = tree.get(left);
            }
            if(!right.equals(".")) {
                tree.putIfAbsent(right, new Node(right));
                current.right = tree.get(right);
            }
        }

        f(tree.get("A"));
        bw.write("\n");
        ff(tree.get("A"));
        bw.write("\n");
        fff(tree.get("A"));
        bw.flush();
        br.close();
        bw.close();
    }
    static void f(Node node) throws IOException {
        if(node==null)
            return;
        bw.write(node.root +"");
        f(node.left);
        f(node.right);
    }
    static void ff(Node node) throws IOException {
        if(node==null)
            return;

        ff(node.left);
        bw.write(node.root +"");
        ff(node.right);
    }
    static void fff(Node node) throws IOException {
        if(node==null)
            return;
        fff(node.left);
        fff(node.right);
        bw.write(node.root +"");
    }
}
