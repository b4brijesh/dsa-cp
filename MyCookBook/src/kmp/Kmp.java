package KMP;

//Source Links:
//http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
//In Python but good explanation: http://keithschwarz.com/interesting/code/?dir=knuth-morris-pratt
//https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm

import java.io.*;

/**
 * Created by Brijesh on 18-01-2017.
 */
public class Kmp {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1=br.readLine();
        String s2=br.readLine();
        char[] txt=s1.toCharArray(),pat=s2.toCharArray();
        int n=txt.length,m=pat.length;
        int[] lps=new int[m];
        lps=computeLPS(pat,lps);

        int i = 0,j = 0;
        while (i < n) {
            if (txt[i]==pat[j]) {
                i++;
                j++;
            }
            if (j == m) {
                //System.out.println("Found pattern at index " + (i-j));
                j = lps[j-1];
            } else if (i < n && pat[j] != txt[i]) {
                if (j != 0)
                    j = lps[j-1];
                else
                    i++;
            }
        }

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
