package classical;

import java.io.*;
import java.util.*;

public class CFATHER {
    //WA
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int i,j=0,k=0;
        int a=Integer.parseInt(br.readLine());
        int arr[]=new int[n-1];
        for(i=0;i<n-1;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i]>=a)
                j++;
            else
                k++;
        }
        int high[]=new int[j];
        int low[]=new int[k];
        int h=j,l=k;
        j=k=0;
        for(i=0;i<n-1;i++) {
            if (arr[i] >= a)
                high[j++] = arr[i];
            else
                low[k++]=arr[i];
        }
        Arrays.sort(high);
        Arrays.sort(low);
        j=h-1;
        k=l-1;
        int max=0;
        while(j>=0){
            if(k<0){
                System.out.println("impossible");
                break;
            }
            int hdiff=high[j]-a+1;
            int ldiff=a-low[k]-1;
            if(hdiff<ldiff) {
                low[k] += hdiff;
                max=Math.max(max,hdiff);
                j--;
            }
            else if(hdiff==ldiff){
                max=Math.max(max,hdiff);
                j--;
                k--;
            }
            else{
                high[j]-=ldiff;
                max=Math.max(max,ldiff);
                k--;
            }
        }
        if(k>=0)
            System.out.println(max);
    }
}
