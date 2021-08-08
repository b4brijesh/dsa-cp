package june15Long;

import java.io.*;
import java.util.*;

public class CHSTR {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int i,j,k,n,q,cnt,cnt2,len,ki;
        long sum;
        String s;
        String[] arr;
        long[] arr2;
        for(i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine().trim());
            n=Integer.parseInt(st.nextToken());
            q=Integer.parseInt(st.nextToken());
            s=br.readLine().trim();
            len=n*(n+1)/2;
            arr=new String[len];
            cnt=0;
            for(j=1;j<=n;j++){
                for(k=0;k<n-j+1;k++){
                    arr[cnt++]=s.substring(k,k+j);
                }
            }
            Arrays.sort(arr);
            Vector<Integer> v=new Vector<>();
            cnt2=0;
            for(j=1;j<len;j++){
                if(arr[j].equals(arr[j-1]))
                    cnt2++;
                else {
                    if(cnt2>0)
                        v.add(cnt2+1);
                    cnt2 = 0;
                }
            }
            if(cnt2>0)
                v.add(cnt2+1);

            arr2=new long[len];
            Arrays.fill(arr2,-1);
            for(j=1;j<=q;j++){
                ki=Integer.parseInt(br.readLine().trim());
                if(ki>len)
                    System.out.println(0);
                else if(ki==1)
                    System.out.println(len);
                else{
                    if(arr2[ki-1]!=-1) {
                        System.out.println(arr2[ki - 1]);
                        continue;
                    }
                    sum=0;
                    for(k=0;k<v.size();k++) {
                        if(v.elementAt(k)==ki)
                            sum=1;
                        if (v.elementAt(k) > ki)
                            sum = (sum + choose(v.elementAt(k), ki)) % 1000000007;
                    }
                    arr2[ki-1]=sum;
                    System.out.println(sum);
                }
            }
        }
    }
    static long choose(int n,int m){
        if(n==m)
            return 1;
        if(m==0)
            return 1;
        else
            return (choose(n-1,m-1)*n/m)%1000000007;
    }
}
