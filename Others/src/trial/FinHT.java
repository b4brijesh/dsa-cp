package trial;

import java.io.*;
//import java.util.*;
public class FinHT {
    static double D;//D=2+squareOf(ml)
    static int n;//No. of grid points
    static double converge;//Max. difference value criterion (epsilon) between successive iterations
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter value of D=(2+(mL)*(mL))");
        D=Double.parseDouble(br.readLine());
        System.out.println("Enter number of grid points (excluding first point at origin)");
        n=Integer.parseInt(br.readLine());
        System.out.println("For G_S enter max convergence value");
        converge=Double.parseDouble(br.readLine());
        tdma();
        gaussSeidel();
    }

    static void gaussSeidel()
    {
        System.out.println();
        double a[][]=new double[n][n];
        double b[]=new double[n];
        double theta[]=new double[n];
        double y[]=new double[n];
        double s;
        int i,j,k;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(i==j)
                    a[i][j]=D;
                else if((i-1)==j)
                    a[i][j]=-1;
                else if((i+1)==j)
                    a[i][j]=-1;
                else
                    a[i][j]=0;
            }
        }
        a[n-1][n-2]=-2;
        for(i=0;i<n;i++){
            b[i]=0;
        }
        b[0]=1;
        for(i=0;i<n;i++)
            theta[i]=b[i];
        double max_diff;
        int count=0;
        do
        {
            max_diff=0.0;
            for(k=0;k<n;k++)
                max_diff=Math.max(Math.abs(y[k]-theta[k]),max_diff);
            for(i=0;i<n;i++)
                y[i]=theta[i];
            for(i=0;i<n;i++)
            {
                s=0.0;
                for(j=0;j<n;j++)
                {
                    if(j!=i)
                        s=s+(a[i][j]*theta[j]);
                }
                theta[i]=(b[i]-s)/a[i][i];
            }
            count++;
        }
        while(max_diff>converge);
        System.out.println("Solving By G_S method for Temperature Difference:");
        System.out.println("Temperature at [0] = 1");
        for(i=0;i<n;i++){
            System.out.println("Temperature at ["+(i+1)+"] = "+theta[i]);
        }
        System.out.println("No. of iterations = "+count);
    }

    static void tdma(){
        System.out.println();
        double a[]=new double[n+1];
        double b[]=new double[n+1];
        double c[]=new double[n+1];
        double d[]=new double[n+1];
        int i;
        for(i=1;i<=n;i++){
            a[i]=-1;
            b[i]=D;
            c[i]=-1;
            d[i]=0;
        }
        a[n]=-2;
        d[1]=1;
        double beta[]=new double[n+1];
        double gamma[]=new double[n+1];
        double theta[]=new double[n+1];
        beta[1]=b[1];
        gamma[1]=d[1]/beta[1];
        for(i=2;i<=n;i++){
            beta[i]=b[i]-((a[i]*c[i-1])/beta[i-1]);
            gamma[i]=(d[i]-(a[i]*gamma[i-1]))/beta[i];
        }
        theta[n]=gamma[n];
        for(i=n-1;i>=1;i--){
            theta[i]=gamma[i]-((c[i]*theta[i+1])/beta[i]);
        }
        System.out.println("By TDMA method");
        System.out.println("theta[0] = 1");
        for(i=1;i<=n;i++){
            System.out.println("theta["+i+"] = "+theta[i]);
        }
    }
}
