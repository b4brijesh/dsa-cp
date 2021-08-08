package classical;

import java.io.*;
public class PALIN {
    //NZEC
    static int arr[];
    static int len;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int i,j;
        String str;
        boolean flag;
        for(i=1;i<=t;i++){
            flag=true;
            str=br.readLine().trim();
            len=str.length();
            arr=new int[len+2];
            arr[0]=0;
            arr[len+1]=-1;
            for(j=1;j<=len;j++)
                arr[j]=Integer.parseInt(String.valueOf(str.charAt(j-1)));
            int mid=(len+1)/2;
            for(j=1;j<mid;j++){
                if(arr[j]!=arr[len-j+1])
                    flag=false;
            }
            if(flag==true)
                increase(0);
            if(arr[0]!=0){
                len++;
                for(j=len;j>0;j--)
                    arr[j]=arr[j-1];
                arr[0]=0;
            }
            for(j=1;j<=mid;j++){
                if(arr[j]>arr[len-j+1])
                    arr[len-j+1]=arr[j];
                if(arr[j]<arr[len-j+1]){
                    increase(j);
                    arr[len-j+1]=arr[j];
                }
            }
            for(j=1;j<=len;j++)
                System.out.print(arr[j]);
            System.out.println();
        }
    }
    static void increase(int j){
        if(arr[len-j]!=9) {
            arr[len-j]++;
        }
        else{
            arr[len-j]=0;
            increase(j+1);
        }
    }
}