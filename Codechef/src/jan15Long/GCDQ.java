package jan15Long;
import java.util.*;
import java.io.*;

public class GCDQ
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		StringTokenizer st;
		int i,n,q,j,a[],l,r;
		for(i=1;i<=cases;i++){
		    st=new StringTokenizer(br.readLine());
		    n=Integer.parseInt(st.nextToken());
		    q=Integer.parseInt(st.nextToken());
		    a=new int[n];
		    st=new StringTokenizer(br.readLine());
		    for(j=0;j<n;j++)
		        a[j]=Integer.parseInt(st.nextToken());
		    for(j=0;j<q;j++){
		    	st=new StringTokenizer(br.readLine());
		        l=Integer.parseInt(st.nextToken());
		        r=Integer.parseInt(st.nextToken());
		        gcd(a,n,l-1,r-1);
		    }
		}
	}
	static void gcd(int a[],int n,int l,int r){
	    int i,divr,divd,rem,gcd;
	    if(l>0)
	    	gcd=a[0];
	    else gcd=a[r+1];
	    for(i=0;i<n;i++){
	        if((i>=l)&&(i<=r))
	            continue;
	        divr=Math.min(a[i],gcd);
	        divd=Math.max(a[i],gcd);
	        rem=divd%divr;
	        while(rem>0){
	            divd=divr;
	            divr=rem;
	            rem=divd%divr;
	        }
	        gcd=divr;
	    }
	    System.out.println(gcd);
	}
}
