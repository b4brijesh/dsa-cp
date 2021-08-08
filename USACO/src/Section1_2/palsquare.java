package Section1_2;
/*
ID: bsahoon1
LANG: JAVA
TASK: namenum
*/

import java.io.*;
public class palsquare {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("palsquare.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        int base=Integer.parseInt(br.readLine());
        int i;
        for(i=1;i<=300;i++){
            String numB=toBaseB(i,base);
            //System.out.println(i+" "+numB);
            int square=i*i;
            String squareB=toBaseB(square,base);
            StringBuffer sbf=new StringBuffer(squareB);
            String revSq=sbf.reverse().toString();
            if(revSq.equals(squareB))
                System.out.println(numB+" "+squareB);
        }
        //out.println();
        //out.close();
    }
    static String toBaseB(int num,int base){
        int rem;
        String numB="";
        while(num>0){
            rem=num%base;
            if(rem<10)
                numB=rem+numB;
            else{
                switch(rem){
                    case 10:numB="A"+numB;break;
                    case 11:numB="B"+numB;break;
                    case 12:numB="C"+numB;break;
                    case 13:numB="D"+numB;break;
                    case 14:numB="E"+numB;break;
                    case 15:numB="F"+numB;break;
                    case 16:numB="G"+numB;break;
                    case 17:numB="H"+numB;break;
                    case 18:numB="I"+numB;break;
                    case 19:numB="J"+numB;break;
                }
            }
            num=num/base;
        }
        //numB=num+numB;
        return numB;
    }
}
