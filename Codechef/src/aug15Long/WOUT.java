package aug15Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class WOUT {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int i,j,k,l,n,h;
        long count;
        for (i=1;i<=t;i++){
            long min=Long.MAX_VALUE;
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            h=Integer.parseInt(st.nextToken());
            int[] lo=new int[n];
            int[] hi=new int[n];
            for(j=0;j<n;j++){
                st=new StringTokenizer(br.readLine());
                lo[j]=Integer.parseInt(st.nextToken());
                hi[j]=Integer.parseInt(st.nextToken());
            }
            for(j=0;j<=n-h;j++){
                count=0;
                l=j+h-1;
                for(k=0;k<n;k++) {
                    if (j<lo[k]) {
                        if(l>hi[k])
                            count=count+(l-hi[k]+lo[k]-j);
                        else if(l<lo[k])
                            count=count+h;
                        else count=count+lo[k]-j;
                    }
                    else if(j>hi[k])
                        count=count+h;
                    else if(l>hi[k])
                        count=count+(l-hi[k]);
                    if (count>=min)
                        break;
                }
                min=Math.min(min,count);
            }
            System.out.println(min);
        }
    }
}
