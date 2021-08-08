package classical;

import java.io.*;
import java.util.*;
public class STAMPS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int i,j,stamps,fr,arr[],sum;
        StringTokenizer st;
        boolean flag;
        for(i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            stamps=Integer.parseInt(st.nextToken());
            fr=Integer.parseInt(st.nextToken());
            arr=new int[fr];
            st=new StringTokenizer(br.readLine());
            for(j=0;j<fr;j++)
                arr[j]=Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            int[] sumArray=new int[fr];
            int cum=0;
            for(j=fr-1;j>=0;j--){
                cum=cum+arr[j];
                sumArray[j]=cum;
            }
            //sum=0;
            flag=false;
            System.out.println("Scenario #" + i+":");
            if(stamps==0){
                System.out.println(1);
                flag=true;
                continue;
            }
            for(j=fr-1;j>=0;j--){
                if(sumArray[j]>=stamps){
                    flag=true;
                    System.out.println(fr-j);
                    break;
                }
                /*if(stamps==0){
                    System.out.println(1);
                    flag=true;
                    break;
                }
                if(sum>=stamps) {
                    System.out.println(fr-j-1);
                    flag=true;
                    break;
                }
                sum+=arr[j];*/
            }
            if(!flag)
                System.out.println("impossible");
            System.out.println();
        }
    }
}
