package classical;

import java.io.*;
public class CANDY {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int i,s,avg,dev;
        int arr[];
        while(n!=-1){
            s=0;
            arr=new int[n];
            for(i=0;i<n;i++) {
                arr[i] = Integer.parseInt(br.readLine());
                s = s + arr[i];
            }
            if((s%n)!=0)
                System.out.println("-1");
            else {
                dev=0;
                avg = s / n;
                for(i=0;i<n;i++)
                    dev=dev+Math.abs(avg-arr[i]);
                System.out.println(dev/2);
            }
            n=Integer.parseInt(br.readLine());
        }
    }
}
