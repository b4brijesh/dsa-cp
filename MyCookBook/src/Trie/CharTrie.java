package Trie;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 18-01-2017.
 */
public class CharTrie {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        Trie trie=new Trie();
        for (int i=0;i<n;i++) {
            char[] str=br.readLine().trim().toCharArray();
            trie.recursiveInsert(str,0,trie.root);
        }
        //call search

        System.exit(0);
    }
    static int ALPHABET_SIZE=26;
    private static class TrieNode {
        int val;
        int words,prefixes;
        TrieNode[] edges=new TrieNode[ALPHABET_SIZE];
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
        }
        boolean search(char[] str){
            TrieNode curr_node=root;
            for (int i=0;i<str.length;i++){
                int idx=str[i]-'a';
                if (curr_node.edges[idx]==null){
                    return false;
                }
                curr_node=curr_node.edges[idx];
            }
            return true;
        }
    }
}

