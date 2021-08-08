package march16Challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 12-03-2016.
 */
public class SEATSTR2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long[] fact=new long[100001];
        fact[0]=1;
        for(int i=1;i<=100000;i++)
            fact[i]=(fact[i-1]*(long)i)%1000000007L;

        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            String s=br.readLine().trim();
            long[] arr=new long[26];
            Arrays.fill(arr,0L);
            for(int j=0;j<s.length();j++){
                char c=s.charAt(j);
                arr[c-97]++;
            }
            long perms=fact[s.length()];
            for(int j=0;j<26;j++)
                //System.out.println("inv fact j"+j+"="+inverse(fact[arr[j]])+" "+arr[j]);
                perms=(perms*inverse(fact[(int)arr[j]]))%1000000007L;
            //System.out.println(perms);
            long sim=1L;
            long pr2=0L;
            for(int j=0;j<26;j++)
                for(int k=j+1;k<26;k++)
                    pr2=(pr2+((arr[j]*arr[k])%1000000007L))%1000000007L;
            sim=(sim+pr2)%1000000007L;
            //System.out.println(sim);
            long pr3=0L;
            for(int j=0;j<26;j++)
                for(int k=j+1;k<26;k++)
                    for(int l=k+1;l<26;l++)
                        //pr3+=(arr[j]*arr[k]*arr[l])%1000000007L;
                        pr3=(pr3+((((arr[j]*arr[k])%1000000007L)*arr[l])%1000000007L))%1000000007L;
            sim=(sim+((2L*pr3)%1000000007L))%1000000007L;
            //System.out.println(sim);
            long pr4=0L;
            for(int j=0;j<26;j++)
                for(int k=j+1;k<26;k++)
                    for(int l=k+1;l<26;l++)
                        for(int m=l+1;m<26;m++)
                            //pr4+=(arr[j]*arr[k]*arr[l]*arr[m])%1000000007L;
                            pr4=(pr4+((((((arr[j]*arr[k])%1000000007L)
                                    *arr[l])%1000000007L)*arr[m])%1000000007L))%1000000007L;
            sim=(sim+((3L*pr4)%1000000007L))%1000000007L;
            //System.out.println(sim);

            long[] ar2=new long[26];
            for(int j=0;j<26;j++)
                ar2[j]=((arr[j]*(arr[j]-1))/2L)%1000000007L;
            long pr5=0L;
            for(int j=0;j<26;j++)
                for(int k=j+1;k<26;k++)
                    for(int l=k+1;l<26;l++){
                        /*pr5+=(ar2[j]*arr[k]*arr[l])%1000000007L;
                        pr5+=(arr[j]*ar2[k]*arr[l])%1000000007L;
                        pr5+=(arr[j]*arr[k]*ar2[l])%1000000007L;*/
                        pr5=(pr5+((((ar2[j]*arr[k])%1000000007L)*arr[l])%1000000007L))%1000000007L;
                        pr5=(pr5+((((arr[j]*ar2[k])%1000000007L)*arr[l])%1000000007L))%1000000007L;
                        pr5=(pr5+((((arr[j]*arr[k])%1000000007L)*ar2[l])%1000000007L))%1000000007L;
                    }
            sim=(sim+((2L*pr5)%1000000007L))%1000000007L;
            //System.out.println(sim);

            long pr6=0L;
            for(int j=0;j<26;j++)
                for(int k=j+1;k<26;k++)
                    pr6=(pr6+((ar2[j]*ar2[k])%1000000007L))%1000000007L;
            sim=(sim+pr6)%1000000007L;
            //System.out.println(sim);

            long nonsim=perms-sim;
            if(nonsim<0)
                nonsim+=1000000007;
            long res=(nonsim*perms)%1000000007L;
            //System.out.println(perms+" "+sim);
            System.out.println(res);
        }
    }
    static long inverse(long x){
        //find x^p-2 % p
        //System.out.println("x="+x);
        long n=1000000005L,y=1L;
        while(n>1){
            if(n%2==0){
                x=(x*x)%1000000007L;
                n=n/2;
                //System.out.println(x);
            }
            else {
                y=(x*y)%1000000007L;
                //System.out.println(y);
                x=(x*x)%1000000007L;
                n=n/2;
                //System.out.println(x);
            }
        }
        return (x*y)%1000000007L;
    }
}
