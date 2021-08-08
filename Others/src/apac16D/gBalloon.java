package apac16D;

import java.io.*;
import java.util.*;
public class gBalloon {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        int i,j,k,l;
        for(i=1;i<=t;i++){
            System.out.print("Case #"+i+": ");
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int q=Integer.parseInt(st.nextToken());
            int[] velos=new int[m];
            st=new StringTokenizer(br.readLine());
            for(j=0;j<m;j++)
                velos[j]=Integer.parseInt(st.nextToken());
            int[] ps=new int[n];
            int[] hs=new int[n];
            for(j=0;j<n;j++){
                st=new StringTokenizer(br.readLine());
                ps[j]=Integer.parseInt(st.nextToken());
                hs[j]=Integer.parseInt(st.nextToken());
            }
            int[][] times=new int[n][m];
            for(j=0;j<n;j++){
                for(k=0;k<m;k++){
                    if(velos[k]!=0)
                        times[j][k]=(int)Math.ceil(-(double)ps[j]/(double)velos[k]);
                    else times[j][k]=30000;
                    /*if(times[j][k]<0)
                        times[j][k]=Integer.MAX_VALUE;*/
                }
            }
            int sum;
            Vector<Integer> mins=new Vector<>();
            for(j=0;j<=10;j++){
                sum=0;
                for(k=0;k<n;k++){
                    l=0;
                    while(hs[k]-l>=0 || hs[k]+l<m){
                        if(hs[k]-l>=0 && times[k][hs[k]-l]<=j){
                            sum+=l;
                            //System.out.println("sum="+times[k][hs[k]-l]);
                            break;
                        }
                        else if(hs[k]+l<m && times[k][hs[k]+l]<=j){
                            sum+=l;
                            //System.out.println("sum="+times[k][hs[k]-l]);
                            break;
                        }
                        l++;
                    }
                }
                //System.out.println("add="+sum);
                mins.add(sum);
            }
            int flag=0;
            for(j=0;j<mins.size();j++){
                if(mins.elementAt(j)<=q && mins.elementAt(j)!=0){
                    flag=1;
                    System.out.println(j);
                    break;
                }
            }
            if(flag==0)
                System.out.println("IMPOSSIBLE");
            /*for(j=0;j<mins.size();j++)
                System.out.println(mins.elementAt(j));*/
        }
    }
}
