package HackerEarth.JanCircuits17;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 27-01-2017.
 */
public class MicrosHouse {
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
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++)
                arr[i][j]=Integer.parseInt(st.nextToken());
        }
        int[][][] grid=new int[n][m][m];
        for (int i=0;i<n;i++) {
            for (int diff=0;diff<m+1;diff++) {
                for (int j=0;j<m;j++) {
                    if (j+diff>=m) break;
                    if (diff==0) grid[i][j][j+diff]=arr[i][j];
                    else grid[i][j][j+diff]=grid[i][j][j+diff-1]^arr[i][j+diff];
                }
            }
        }
        int[][][] mat=new int[m][m][n];
        long max=0;
        for (int i=0;i<m;i++) {
            for (int j=i;j<m;j++) {
                mat[i][j][0]=grid[0][i][j];
                max=Math.max(max,mat[i][j][0]);
                Trie trie=new Trie();
                String val;
                val=String.format("%40s", Long.toBinaryString(0)).replace(' ', '0');
                trie.insert(val.toCharArray());
                val=String.format("%40s", Long.toBinaryString(mat[i][j][0])).replace(' ', '0');
                trie.insert(val.toCharArray());
                for (int k=1;k<n;k++) {
                    mat[i][j][k]=mat[i][j][k-1]^grid[k][i][j];
                    //System.out.println(i+" "+j+" "+k+" = "+mat[i][j][k]);
                    val=String.format("%40s", Long.toBinaryString(mat[i][j][k])).replace(' ', '0');
                    trie.insert(val.toCharArray());
                    max=Math.max(max,mat[i][j][k]^trie.findMax(val.toCharArray()));
                }
            }
        }
        //long max=0;
        //for (int i=0;i<m;i++) for (int j=0;j<m;j++) max=Math.max(max,maxXor[i][j]);
        System.out.println(max);

        //System.exit(0);
    }
    static int ALPHABET_SIZE=2;
    private static class TrieNode {
        TrieNode[] edges=new TrieNode[ALPHABET_SIZE];
    }
    private static class Trie{
        TrieNode root=new TrieNode();

        void insert(char[] str) {
            TrieNode curr_node=root;
            for (int i=0;i<str.length;i++){
                int idx=str[i]-'0';
                //curr_node.prefixes++;
                //if (i==str.length-1) curr_node.words++;
                if (curr_node.edges[idx]==null){
                    curr_node.edges[idx]=new TrieNode();
                }
                curr_node=curr_node.edges[idx];
            }
        }
        long findMax(char[] str) {
            char[] val=new char[str.length];
            TrieNode curr_node = root;
            for (int i = 0; i < str.length; i++) {
                int ind = str[i] - '0';
                int idx = 1 - ind;
                if (curr_node.edges[idx] == null) {
                    val[i]=(char)(ind+'0');
                    curr_node = curr_node.edges[ind];
                } else {
                    val[i]=(char)(idx+'0');
                    curr_node = curr_node.edges[idx];
                }
            }
            long v=Long.parseLong(new String(val),2);
            return v;
        }
    }
}
