package trial;

import java.io.*;
public class Heat2D {

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //Grid size
        System.out.println("Enter no. of grid points along any axis(excluding outer one(s))");
        int nx;//actual no. of points-1
        int ny=nx=Integer.parseInt(br.readLine());//actual no. of points-1
        double A[][]=new double[nx*ny+1][nx*ny+1];
        double theta[]=new double[nx*ny+1];
        double C[]=new double[nx*ny+1];
        double converge;
        double delX=1/Math.pow(nx,2);
        System.out.println("Enter convergence value");
        converge=Double.parseDouble(br.readLine());
        int r=nx*ny+1;
        //initialize coefficient matrix and constant vector with zeros
        int i,j;
        for(i=0;i<(nx*ny+1);i++)
            for(j=0;j<(nx*ny+1);j++)
                A[i][j]=0;
        for(i=0;i<(nx*ny+1);i++)
            C[i]=(delX*delX);
        // inner nodes
        int n,m;
        for (n=2;n<=(nx-1);n++){
            for (m=2;m<=(ny-1);m++){
                i = (n-1)*ny + m;
                A[i][i+ny] = -1;
                A[i][i-ny] = -1;
                A[i][i+1] = -1;
                A[i][i-1] = -1;
                A[i][i] = 4;
            }
        }
        //Edge nodes
        // bottom
        for (m=2;m<=(nx-1);m++){
            i = (m-1)*ny + 1;
            A[i][i+ny] = -1;
            A[i][i-ny] = -1;
            A[i][i+1] = -2;
            A[i][i] = 4;
        }
        //left:
        for (n=2;n<=(nx-1);n++){
            i = n;
            A[i][i+ny] = -2;
            A[i][i+1] = -1;
            A[i][i-1] = -1;
            A[i][i] = 4;
        }
        //right:
        for (n=2;n<=(ny-1);n++){
            i = (ny-1)*nx + n;
            A[i][i+1] = -1;
            A[i][i-1] = -1;
            A[i][i-nx] = -1;
            A[i][i] = 4;
        }
        //top:
        for (m = 2;m<=(nx-1);m++){
            i = (m-1)*nx + nx;
            A[i][i-nx] = -1;
            A[i][i+nx] = -1;
            A[i][i-1] = -1;
            A[i][i] = 4;
        }
        // Corners
        //bottom left (i=1):
        i=1;
        A[i][nx+i] = -2;
        A[i][2] = -2;
        A[i][1] = 4;
        //top left:
        i = nx;
        A[i][i+nx] = -2;
        A[i][i-1] = -1;
        A[i][i] = 4;
        //bottom right:
        i = (ny-1)*nx + 1;
        A[i][i+1] = -2;
        A[i][i] = 4;
        A[i][i-nx] = -1;
        //top right:
        i = nx*ny;
        A[i][i-1] = -1;
        A[i][i] = 4;
        A[i][i-nx] = -1;
        gaussSeidel(A,theta,C,r,converge);
    }

    static void gaussSeidel(double A[][],double theta[],double C[],int n,double converge){
        int i,j,k;
        double y[]=new double[n];
        double s;
        for(i=1;i<n;i++)
            theta[i]=C[i];
        double max_diff;
        int count=0;
        do
        {
            max_diff=0.0;
            for(k=1;k<n;k++)
                max_diff=Math.max(Math.abs(y[k]-theta[k]),max_diff);
            for(i=1;i<n;i++)
                y[i]=theta[i];
            for(i=1;i<n;i++)
            {
                s=0.0;
                for(j=1;j<n;j++)
                {
                    if(j!=i)
                        s=s+(A[i][j]*theta[j]);
                }
                theta[i]=(C[i]-s)/A[i][i];
            }
            count++;
        }
        while(max_diff>converge);
        System.out.println("Solving By G_S method for Temperature Difference:");
        for(i=1;i<n;i++){
            System.out.println("Temperature at ["+i+"] = "+theta[i]);
        }
        System.out.println("Values of temperature at outer edge points=0.0");
        System.out.println("No. of iterations = "+count);
    }
}
