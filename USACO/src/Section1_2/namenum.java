package Section1_2;
/*
ID: bsahoon1
LANG: JAVA
TASK: namenum
*/

import java.io.*;
import java.util.*;

public class namenum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("milk2.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        String s=br.readLine().trim();
        br=new BufferedReader(new FileReader("C://Users/Brijesh/Desktop/namenumdict.txt"));
        String temp;
        int i;
        ArrayList<String> nums=new ArrayList<String>();
        ArrayList<String> names=new ArrayList<String>();
        while((temp=br.readLine())!=null){
            names.add(temp);
            int len=temp.length();
            int[] num=new int[len];
            String s2="";
            for(i=0;i<len;i++){
                char cho=temp.charAt(i);
                switch(cho){
                    case 'A':case 'B':case 'C':num[i]=2;break;
                    case 'D':case 'E':case 'F':num[i]=3;break;
                    case 'G':case 'H':case 'I':num[i]=4;break;
                    case 'J':case 'K':case 'L':num[i]=5;break;
                    case 'M':case 'N':case 'O':num[i]=6;break;
                    case 'P':case 'R':case 'S':num[i]=7;break;
                    case 'T':case 'U':case 'V':num[i]=8;break;
                    case 'W':case 'X':case 'Y':num[i]=9;break;
                    default:num[i]=0;
                }
                s2=s2+num[i];
            }
            nums.add(s2);
        }
        boolean flag=false;
        for(i=0;i<nums.size();i++){
            if(s.equals(nums.get(i))) {
                System.out.println(names.get(i));
                flag=true;
            }
        }
        if(!flag)
            System.out.println("NONE");
        //out.println();
        //out.close();
    }
}
