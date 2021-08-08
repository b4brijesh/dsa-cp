package worksAp;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/16/16.
 */
public class maxXorSub {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-large.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-practice.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        //System.out.println(Long.parseLong("1011100101011010110101110111111111111",2));
        //System.out.println(Long.toBinaryString(1000000000000L));
        N=Integer.parseInt(br.readLine().trim());
        arr=new long[N];
        st=new StringTokenizer(br.readLine().trim());
        for (int i=0;i<N;i++)
            arr[i]=Long.parseLong(st.nextToken());
        long[] prefix_xor=new long[N+1];
        prefix_xor[0]=0;
        for (int i=1;i<=N;i++)
            prefix_xor[i]=prefix_xor[i-1]^arr[i-1];
        Trie trie=new Trie();
        trie.insert(0);
        long max_xor=prefix_xor[N];
        //System.out.println(max_xor);
        long suf_xor=0;
        for (int i=N-1;i>=0;i--){
            suf_xor=suf_xor^arr[i];
            trie.insert(suf_xor);
            max_xor=Math.max(max_xor,trie.findMax(prefix_xor[i]));
            //System.out.println(i+" "+max_xor);
        }
        System.out.println(max_xor);

        //System.exit(0);
    }
    private static int N;
    private static long[] arr;
}
class Node{
    int val;
    Node left=null,right=null;
    Node(){}
    Node(int val){this.val=val;};
}
class Trie{
    Node root=new Node();

    void insert(long suf_xor) {
        //StringBuffer sbf=new StringBuffer(Long.toBinaryString(suf_xor));
        //String s=sbf.toString();
        String s=String.format("%40s", Long.toBinaryString(suf_xor)).replace(' ', '0');
        Node curr_node=root;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='0'){
                if (curr_node.left==null)
                    curr_node.left=new Node(0);
                curr_node=curr_node.left;
            } else {
                if (curr_node.right==null)
                    curr_node.right=new Node(1);
                curr_node=curr_node.right;
            }
        }
    }

    long findMax(long prefix){
        String s=String.format("%40s", Long.toBinaryString(prefix)).replace(' ', '0');
        Node curr_node=root;
        String xor="";
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='0'){
                if (curr_node.right!=null){
                    xor+="1";
                    curr_node=curr_node.right;
                } else {
                    xor+="0";
                    curr_node=curr_node.left;
                }
            } else {
                if (curr_node.left!=null){
                    xor+="1";
                    curr_node=curr_node.left;
                } else {
                    xor+="0";
                    curr_node=curr_node.right;
                }
            }
        }
        return Long.parseLong(xor,2);
    }
}