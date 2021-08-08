package aug15LTime;

import java.io.*;
import java.util.*;
public class CLOST {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int i,j;
        for(i=0;i<t;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            char[] arr=new char[n];
            char[] ar2=new char[n];
            int[] start=new int[k];
            int[] stop=new int[k];
            Arrays.fill(arr, '0');
            for(j=0;j<k;j++){
                st=new StringTokenizer(br.readLine());
                start[j]=Integer.parseInt(st.nextToken());
                stop[j]=Integer.parseInt(st.nextToken());
                arr[start[j]]=ar2[start[j]]='(';
                arr[stop[j]]=ar2[stop[j]]=')';
            }
            int count,x;
            for(j=0;j<k;j++){
                count=0;
                for(x=start[j];x<=stop[j];x++){
                    if(arr[x]=='(')
                        count++;
                    if(arr[x]==')')
                        count--;
                    if(arr[x]=='0' && count>0){
                        arr[x]=')';
                        count--;
                    }
                    if(arr[x]=='0' && count==0){
                        arr[x]='(';
                        count++;
                    }
                    /*if(count<0){
                        int y=x;
                        while(y>=start[j]){
                            if(ar2[x]=='0' && arr[x]=='(')
                                arr[x]=')';
                            if(ar2[x]=='0' && arr[x]==')')
                                arr[x]='(';
                            y--;
                        }
                    }*/
                }
            }
            for(j=0;j<n;j++){
                if(arr[j]=='0')
                    System.out.print('(');
                else
                    System.out.print(arr[j]);
            }
            System.out.println();
        }
    }
}
