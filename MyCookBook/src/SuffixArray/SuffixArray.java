package SuffixArray;

//Source Links:
//https://discuss.codechef.com/questions/21385/a-tutorial-on-suffix-arrays
//http://web.stanford.edu/class/cs97si/suffix-array.pdf
//https://www.topcoder.com/community/data-science/data-science-tutorials/range-minimum-query-and-lowest-common-ancestor/
//https://www.hackerrank.com/challenges/find-strings/topics (on improving lcp runtime and Kasai's algorithm)

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 16-01-2017.
 */

public class SuffixArray {
    private static class Tuple {
        int[] rank =new int[2];
        int pos;
    }
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


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
                tuples[i].rank[1]=i +cnt <len? rank[stp -1][i+ cnt]:-1;
                tuples[i].pos = i;
            }
            Arrays.sort(tuples,cmp);
            //Below comments supported in Java 8 only
            /*ArrayList<Tuple> arrayList=new ArrayList<>();
            for (int i=0;i<len;i++)
                arrayList.add(tuples[i]);
            arrayList.sort(cmp);*/
            for(int i=0; i < len; i++){
                if (i> 0 && tuples[i].rank[0]==tuples[i-1].rank[0] && tuples[i].rank[1] == tuples[i- 1].rank[1])
                    rank[stp][tuples[i].pos] = rank[stp][tuples[i-1].pos];
                else rank[stp][tuples[i].pos] = i;
            }
        }
        //The kth suffix (alphabetically) is now at j where P[lgN][j]=k
        //So A[j] to A[N-1] is the kth smallest suffix
        //To search for occurence of a word W we need to binary search over the array L at final



        //Finding LCP array
        int[] lcp=new int[len-1];
        for (int i=0;i<len-1;i++){
            int answer=0;
            int x=i,y=i+1;
            for (int j=lgLen;j>=0;j--){
                if (rank[j][x]==rank[j][y]){
                    // sort-index is same if the first j characters are same
                    answer+=(2*j);
                    x+=(2*j);
                    y+=(2*j);
                }
            }
            lcp[i]=answer;
        }
        //Without RMQ lcp(x,y) can be found in lg(n)
        //RMQ ??

        System.exit(0);
    }
}
