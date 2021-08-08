package Section1_2;
/*
ID: bsahoon1
LANG: JAVA
TASK: dualpal
*/

import java.io.*;
import java.util.*;

public class dualpal {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("palsquare.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());
        while(n>0){
            s++;
            int count=0;
            for(int i=2;i<=10;i++){
                String numB=toBaseB(s,i);
                StringBuffer sbf=new StringBuffer(numB);
                String revNum=sbf.reverse().toString();
                if(revNum.equals(numB))
                    count++;
                if(count>=2){
                    System.out.println(s);
                    n--;
                    break;
                }
            }
        }
        //out.println();
        //out.close();
    }
    static String toBaseB(int num,int base) {
        int rem;
        String numB = "";
        while (num > 0) {
            rem = num % base;
            numB = rem + numB;
            num = num / base;
        }
        return numB;
    }
}
