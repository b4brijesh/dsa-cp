package codeJam8Apr16;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 09-Apr-2016.
 */
public class CountingSheep {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C://Users/Brijesh/Downloads/A-large.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            int n=Integer.parseInt(br.readLine());
            int lastInc=0;
            boolean flag=false,isComplete=false;
            boolean[] arr=new boolean[10];
            Arrays.fill(arr,false);
            long m=1,r=n,g=-1;
            while(!isComplete && lastInc<1000000){
                g=m*r;
                m++;
                String s=String.valueOf(g);
                flag=false;
                for(int j=0;j<s.length();j++){
                    int k=s.charAt(j)-48;
                    //System.out.println(k);
                    if(arr[k]==false){
                        arr[k]=true;
                        lastInc=0;
                        flag=true;
                    }
                }
                //System.out.println(lastInc);
                if (flag==false)
                    lastInc++;
                for(int j=0;j<10;j++){
                    if(arr[j]==false){
                        isComplete=false;
                        break;
                    }
                    else isComplete=true;
                }
            }
            System.out.print("Case #"+i+": ");
            if(lastInc==1000000)
                System.out.println("INSOMNIA");
            else System.out.println(g);

            lastInc=0;
            flag=false;
            isComplete=false;
            arr=new boolean[10];
            Arrays.fill(arr,false);
            m=1;
            r=n;
            g=-1;
            while(!isComplete && lastInc<1000000000){
                g=m*r;
                m++;
                String s=String.valueOf(g);
                flag=false;
                for(int j=0;j<s.length();j++){
                    int k=s.charAt(j)-48;
                    //System.out.println(k);
                    if(arr[k]==false){
                        arr[k]=true;
                        lastInc=0;
                        flag=true;
                    }
                }
                //System.out.println(lastInc);
                if (flag==false)
                    lastInc++;
                for(int j=0;j<10;j++){
                    if(arr[j]==false){
                        isComplete=false;
                        break;
                    }
                    else isComplete=true;
                }
            }
            System.out.print("Case #"+i+": ");
            if(lastInc==1000000000)
                System.out.println("INSOMNIA");
            else System.out.println(g);
        }
    }
}
