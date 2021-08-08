package KMP;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 18-01-2017.
 */
//Site: CodeChef
public class TASHIFT {
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
        int N=Integer.parseInt(br.readLine());
        String s1=br.readLine();
        String s2=br.readLine();
        char[] txt=s2.toCharArray(),pat=s1.toCharArray();
        int n=txt.length,m=pat.length;
        int[] lps=new int[m];
        lps=computeLPS(pat,lps);

        int i = 0,j = 0;
        int maxMatch=-1,maxMatchIdx=n+1;
        while (i < n) {
            if (txt[i]==pat[j]) {
                if (j+1>maxMatch){
                    maxMatch=j+1;
                    maxMatchIdx=i-j;
                }
                i++;
                j++;
            }
            if (j == m) {
                System.out.println(i-j);
                return;
                //System.out.println("Found pattern at index " + (i-j));
                //j = lps[j-1];
            } else if (i < n && pat[j] != txt[i]) {
                if (j != 0)
                    j = lps[j-1];
                else {
                    i++;
                }
            }
        }
        if (maxMatch==0 || maxMatchIdx==n+1)
            System.out.println(0);
        else System.out.println(maxMatchIdx);

        System.exit(0);
    }
    private static int[] computeLPS(char[] pat, int[] lps) {
        //lps[i] stores length of longest (proper) prefix that is also a suffix for pat[0..i]
        lps[0]=0;
        int lenOfPrevLPS=0;
        int i=1, m=pat.length;
        // the loop calculates lps[i] for i = 1 to M-1
        while (i < m) {
            if (pat[i] == pat[lenOfPrevLPS]) {
                lenOfPrevLPS++;
                lps[i] = lenOfPrevLPS;
                i++;
            }
            else { // (pat[i] != pat[lenOfPrevLPS])
                if (lenOfPrevLPS != 0)
                    lenOfPrevLPS = lps[lenOfPrevLPS-1];
                else { // if (lenOfPrevLPS == 0)
                    lps[i] = lenOfPrevLPS;
                    i++;
                }
            }
        }
        return lps;
    }
}
