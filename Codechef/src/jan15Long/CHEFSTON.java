package jan15Long;
import java.util.*;
import java.io.*;

public class CHEFSTON
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		StringTokenizer st;
		int i,n,k,j,a[],b[];
		long pr,maxpr;
		for(i=1;i<=cases;i++){
		    maxpr=0;
		    st=new StringTokenizer(br.readLine());
		    n=Integer.parseInt(st.nextToken());
		    k=Integer.parseInt(st.nextToken());
		    a=new int[n];
		    b=new int[n];
		    st=new StringTokenizer(br.readLine());
		    for(j=0;j<n;j++)
		        a[j]=Integer.parseInt(st.nextToken());
		    st=new StringTokenizer(br.readLine());
		    for(j=0;j<n;j++)
		        b[j]=Integer.parseInt(st.nextToken());
		    for(j=0;j<n;j++){
		        pr=((long)k/(long)a[j])*(long)b[j];
		        if(pr>maxpr)
		        maxpr=pr;
		    }
		    System.out.println(maxpr);
		}
	}
}
