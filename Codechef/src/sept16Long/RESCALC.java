package sept16Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 06-09-2016.
 */
public class RESCALC {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            int[][] counts=new int[n][6];
            int[] cum=new int[n];
            for(int j=0;j<n;j++){
                st=new StringTokenizer(br.readLine());
                int c=Integer.parseInt(st.nextToken());
                cum[j]=c;
                for(int k=0;k<c;k++){
                    int type=Integer.parseInt(st.nextToken());
                    counts[j][type-1]++;
                }
            }
            int[] mix=new int[n];
            for(int j=0;j<n;j++){
                int zeros,sum=0,min;
                do{
                    zeros=0;
                    min=Integer.MAX_VALUE;
                    for(int k=0;k<6;k++){
                        if(counts[j][k]==0)
                            zeros++;
                        else min=Math.min(min,counts[j][k]);
                    }
                    int nonzeros=6-zeros;
                    if(nonzeros>3){
                        if(nonzeros==6){
                            sum=sum+(4*min);
                        }
                        if(nonzeros==5){
                            sum=sum+(2*min);
                        }
                        if(nonzeros==4){
                            sum=sum+min;
                        }
                        for(int k=0;k<6;k++){
                            if(counts[j][k]>=min)
                                counts[j][k]=counts[j][k]-min;
                        }
                    }
                }while (zeros<3);
                mix[j]=cum[j]+sum;
            }
            int max=-1,maxi=-1;
            for(int j=0;j<n;j++){
                if(mix[j]>max){
                    max=mix[j];
                    maxi=j;
                }
            }
            int co_max=0;
            for(int j=0;j<n;j++){
                if(mix[j]==max)
                    co_max++;
            }
            if(co_max>1)
                System.out.println("tie");
            else{
                if(maxi==0) System.out.println("chef");
                else System.out.println(maxi+1);
            }
        }
    }
}
