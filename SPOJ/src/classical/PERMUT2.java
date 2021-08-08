package classical;

import  java.io.*;
import java.util.*;
public class PERMUT2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int i,arr[];
        boolean flag;
        while(n!=0){
            flag=false;
            arr=new int[n+1];
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(i=1;i<=n;i++)
                arr[i]=Integer.parseInt(st.nextToken());
            for(i=1;i<=n;i++){
                if(arr[arr[i]]!=i) {
                    flag=true;
                    System.out.println("not ambiguous");
                    break;
                }
            }
            if(flag==false)
                System.out.println("ambiguous");
            n=Integer.parseInt(br.readLine());
        }
    }
}
