package SuffixArray;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 16-01-2017.
 */
//Site: SPOJ
public class BEADS {
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
        int t=Integer.parseInt(br.readLine());
        for (int ind=1;ind<=t;ind++){
            String s=br.readLine().trim();
            char[] str=s.toCharArray();
            int len=str.length;
            int lgLen= (int) Math.ceil(Math.log(len)/Math.log(2))+1;
            Tuple[] tuples=new Tuple[len];
            for (int i=0;i<len;i++) tuples[i]=new Tuple();
            int[][] rank=new int[lgLen][len];
            for(int i = 0; i < len; i++)
                rank[0][i] = str[i] - 'a';
            Comparator<Tuple> cmp=new Comparator<Tuple>() {
                @Override
                public int compare(Tuple a, Tuple b) {
                    if (a.rank[0]==b.rank[0]){
                        if (a.rank[1]!=b.rank[1]) return a.rank[1]-b.rank[1];
                        else return 0;
                    }
                    else return a.rank[0]-b.rank[0];
                }
            };
            int stp,cnt;
            for(stp=1, cnt = 1; cnt < len; stp++, cnt *= 2)
            {
                for(int i=0; i < len; i++)
                {
                    tuples[i].rank[0]=rank[stp- 1][i];
                    if (i+cnt<len) tuples[i].rank[1]=rank[stp -1][i+ cnt];
                    else tuples[i].rank[1]=rank[stp -1][(i+ cnt)%len];
                    tuples[i].pos = i;
                }
                Arrays.sort(tuples,cmp);
                for(int i=0; i < len; i++){
                    if (i> 0 && tuples[i].rank[0]==tuples[i-1].rank[0] && tuples[i].rank[1] == tuples[i- 1].rank[1])
                        rank[stp][tuples[i].pos] = rank[stp][tuples[i-1].pos];
                    else rank[stp][tuples[i].pos] = i;
                }
            }
            System.out.println(tuples[0].pos+1);
        }

        //System.exit(0);
    }
    static class Tuple {
        int[] rank =new int[2];
        int pos;
    }
}
