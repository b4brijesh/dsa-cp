package Trie;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 18-01-2017.
 */
//wrong answer!!!!
public class B455 {
    static int e09$7=1000000007;
    static double e_06=0.000001;
    static long INF=1000000000000000L;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    static String d_loc2="C:\\Users\\Brijesh\\Downloads\\";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        Trie trie=new Trie();
        for (int i=0;i<n;i++) {
            char[] str=br.readLine().trim().toCharArray();
            trie.recursiveInsert(str,0,trie.root);
        }
        //System.out.println(trie.root.val);
        if (k%2==0) {
            if (trie.root.lose && trie.root.win) System.out.println("First");
            else System.out.println("Second");
        } else {
            if (trie.root.lose && trie.root.win) System.out.println("First");
            else if (trie.root.win && !trie.root.lose) System.out.println("First");
            else System.out.println("First");
        }

        System.exit(0);
    }
    static int ALPHABET_SIZE=26;
    private static class TrieNode {
        boolean win,lose=true;
        int words,prefixes;
        TrieNode[] edges=new TrieNode[ALPHABET_SIZE];
        TrieNode(){}
    }
    private static class Trie{
        TrieNode root=new TrieNode();

        void insert(char[] str) {
            TrieNode curr_node=root;
            for (int i=0;i<str.length;i++){
                int idx=str[i]-'a';
                curr_node.prefixes++;
                if (i==str.length-1) curr_node.words++;
                if (curr_node.edges[idx]==null){
                    curr_node.edges[idx]=new TrieNode();
                }
                curr_node=curr_node.edges[idx];
            }
        }
        void recursiveInsert(char[] str,int i, TrieNode curr_node) {
            if (i==str.length) return;
            int idx=str[i]-'a';
            curr_node.prefixes++;
            if (i==str.length-1) curr_node.words++;
            if (curr_node.edges[idx]==null) {
                curr_node.edges[idx]=new TrieNode();
            }
            recursiveInsert(str,i+1,curr_node.edges[idx]);
            boolean win=false;
            for (int j=0;j<ALPHABET_SIZE;j++) {
                if (curr_node.edges[j]!=null && !curr_node.edges[j].win && curr_node.edges[j].lose) {
                    win=true;
                    break;
                }
            }
            curr_node.win = win;
            boolean lose=false;
            int j,count=0,cnt2=0;
            for (j=0;j<ALPHABET_SIZE;j++) {
                if (curr_node.edges[j]!=null) {
                    count++;
                    if (!curr_node.edges[j].lose && curr_node.edges[j].win)
                        cnt2++;
                }
            }
            if (cnt2==count) lose=true;
            else lose=false;
            curr_node.lose=lose;
        }
        boolean search(char[] str) {
            TrieNode curr_node=root;
            for (int i=0;i<str.length;i++) {
                int idx=str[i]-'a';
                if (curr_node.edges[idx]==null) {
                    return false;
                }
                curr_node=curr_node.edges[idx];
            }
            return true;
        }

    }
}
