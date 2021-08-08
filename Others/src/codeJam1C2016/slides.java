package codeJam1C2016;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by Brijesh on 08-05-2016.
 */
public class slides {
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("C://Users/Brijesh/Downloads/B-small-practice.in"));
        BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/B-large-practice.in"));
        //BufferedReader br = new BufferedReader(new FileReader("C://Users/Brijesh/Downloads/A-large.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        long arr[]=new long[50];
        arr[0]=1;
        Vector<Vector<Long>> sums=new Vector<Vector<Long>>();
        Vector<Long> v=new Vector<Long>();
        v.add(1L);
        sums.add(v);
        for(int i=1;i<=29;i++){
            arr[i]=(long)Math.pow(2,i-1);
            v=new Vector<Long>();
            for(int j=0;j<sums.elementAt(sums.size()-1).size();j++){
                v.add(sums.elementAt(sums.size()-1).elementAt(j));
            }
            for(int j=0;j<sums.elementAt(sums.size()-1).size();j++){
                v.add(sums.elementAt(sums.size()-1).elementAt(j)+arr[i]);
            }
            sums.add(v);
        }
        System.out.println("here");
        for(int i=1;i<=t;i++){
            System.out.print("Case #"+i+": ");
            st=new StringTokenizer(br.readLine());
            int b=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int c=b-2,flag=0,index=0;
            if(m>arr[c+1])
                System.out.println("IMPOSSIBLE");
            else{
                v=sums.elementAt(c+1);
                if(m==arr[c+1]){
                    flag=2;
                    System.out.println("POSSIBLE");
                    int mat[][]=new int[b][b];
                    for(int j=0;j<b;j++){
                        for(int k=j+1;k<b;k++){
                            mat[j][k]=1;
                        }
                    }
                    for(int j=0;j<b;j++){
                        for(int k=0;k<b;k++){
                            System.out.print(mat[j][k]+"");
                        }
                        System.out.println();
                    }
                }
                for(int j=0;j<v.size();j++){
                    long num=arr[c+1]-v.elementAt(j);
                    if(num==m){
                        flag=1;
                        index=j;
                        break;
                    }
                }
                if(flag==0)
                    System.out.println("IMPOSSIBLE");
                else if(flag==1){
                    //System.out.println("here");
                    System.out.println("POSSIBLE");
                    int mat[][]=new int[b][b];
                    for(int j=0;j<b;j++){
                        for(int k=j+1;k<b;k++){
                            mat[j][k]=1;
                        }
                    }
                    long min=v.elementAt(index);
                    //System.out.println(min);
                    while(min>0){
                        //System.out.println(min+" "+arr[c+1]);
                        long div=min/(arr[c+1]);
                        if(div==1){
                            mat[c+1][b-1]=0;
                            min=min-(int)arr[c+1];
                        }
                        c--;
                    }
                    for(int j=0;j<b;j++){
                        for(int k=0;k<b;k++){
                            System.out.print(mat[j][k]+"");
                        }
                        System.out.println();
                    }
                }

            }
        }
    }
}
