package march16Challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by Brijesh on 14-03-2016.
 */
public class HBIRD {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        int[][] arr=new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++)
                arr[i][j]=Integer.parseInt(st.nextToken());
        }
        int[] queries=new int[q];
        for(int i=0;i<q;i++)
            queries[i]=Integer.parseInt(br.readLine());
        int[][] rowcum=new int[n][m];
        int[][] colcum=new int[n][m];
        for(int i=0;i<n;i++){
            rowcum[i][0]=arr[i][0];
            for(int j=1;j<m;j++)
                rowcum[i][j]=rowcum[i][j-1]+arr[i][j];
        }
        for(int i=0;i<m;i++){
            colcum[0][i]=arr[0][i];
            for(int j=1;j<n;j++)
                colcum[j][i]=colcum[j-1][i]+arr[j][i];
        }
        int[][] ridiag=new int[n][m];
        int[][] lediag=new int[n][m];
        for(int i=0;i<n;i++)
            ridiag[i][0]=arr[i][0];
        for(int i=0;i<m;i++)
            ridiag[0][i]=arr[0][i];
        for(int i=1;i<n;i++)
            for(int j=1;j<m;j++)
                ridiag[i][j]=ridiag[i-1][j-1]+arr[i][j];
        for(int i=0;i<m;i++)
            lediag[0][i]=arr[0][i];
        for(int i=0;i<n;i++)
            lediag[i][m-1]=arr[i][m-1];
        for(int i=1;i<n;i++)
            for(int j=m-2;j>=0;j--)
                lediag[i][j]=lediag[i-1][j+1]+arr[i][j];
        Vector<Integer> v1=new Vector<Integer>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int k=1;
                while((i-k)>=0 && (j-k)>=0){
                    int x,y,z;
                    if(i-k==0)
                        y=colcum[i][j];
                    else y=colcum[i][j]-colcum[i-k-1][j];
                    if(j-k==0)
                        x=rowcum[i][j];
                    else x=rowcum[i][j]-rowcum[i][j-k-1];
                    z=lediag[i][j-k]-lediag[i-k][j]-arr[i][j-k];
                    int sum=x+y+z-arr[i][j];
                    v1.add(sum);
                    k++;
                }//1
                k=1;
                while((i-k)>=0 && (j+k)<m){
                    int x,y,z;
                    x=rowcum[i][j+k]-rowcum[i][j];
                    if(i-k==0)
                        y=colcum[i][j];
                    else y=colcum[i][j]-colcum[i-k-1][j];
                    z=ridiag[i][j+k]-ridiag[i-k][j]-arr[i][j+k];
                    int sum=x+y+z;
                    v1.add(sum);
                    k++;
                }//2
                k=1;
                while((i+k)<n && (j+k)<m){
                    int x,y,z;
                    x=rowcum[i][j+k]-rowcum[i][j];
                    y=colcum[i+k][j]-colcum[i][j];
                    z=lediag[i+k][j]-lediag[i][j+k]-arr[i+k][j];
                    int sum=x+y+z+arr[i][j];
                    v1.add(sum);
                    k++;
                }//3
                k=1;
                while((i+k)<n && (j-k)>=0){
                    int x,y,z;
                    if(j-k==0)
                        x=rowcum[i][j];
                    else x=rowcum[i][j]-rowcum[i][j-k-1];
                    y=colcum[i+k][j]-colcum[i][j];
                    z=ridiag[i+k][j]-ridiag[i][j-k]-arr[i+k][j];
                    int sum=x+y+z;
                    v1.add(sum);
                    k++;
                }//4
                k=1;
                while((i+k)<n && (j-k)>=0 && (j+k)<m){
                    int x,y,z;
                    x=lediag[i+k][j-k]-lediag[i][j];
                    y=ridiag[i+k][j+k]-ridiag[i][j]+arr[i][j];
                    z=rowcum[i+k][j+k]-rowcum[i+k][j-k]-arr[i+k][j+k];
                    int sum=x+y+z;
                    v1.add(sum);
                    k++;
                    //System.out.println("in5");
                }//5
                k=1;
                while((i-k)>=0 && (j-k)>=0 && (j+k)<m){
                    int x,y,z;
                    x=lediag[i][j]-lediag[i-k][j-k];
                    y=ridiag[i][j]-ridiag[i-k][j+k]-arr[i][j];
                    z=rowcum[i-k][j+k]-rowcum[i-k][j-k]+arr[i-k][j-k];
                    int sum=x+y+z;
                    v1.add(sum);
                    k++;
                    //System.out.println("in6");
                }//6
                k=1;
                while((i-k)>=0 && (i+k)<n && (j+k)<m){
                    int x,y,z;
                    x=lediag[i][j]-lediag[i-k][j+k];
                    y=ridiag[i+k][j+k]-ridiag[i][j]-arr[i][j];
                    z=colcum[i+k][j+k]-colcum[i-k][j+k]+arr[i-k][j+k]-arr[i+k][j+k];
                    int sum=x+y+z;
                    v1.add(sum);
                    k++;
                    //System.out.println("in7");
                }//7
                k=1;
                while((i-k)>=0 && (i+k)<n && (j-k)>=0){
                    int x,y,z;
                    x=lediag[i+k][j-k]-lediag[i][j];
                    y=ridiag[i][j]-ridiag[i-k][j-k];
                    z=colcum[i+k][j-k]-colcum[i-k][j-k]+arr[i-k][j-k]-arr[i+k][j-k];
                    int sum=x+y+z;
                    v1.add(sum);
                    k++;
                    //System.out.println("in8");
                }//8
            }
        }
        for(int i=0;i< v1.size();i++)
            System.out.println(v1.elementAt(i));
        Collections.sort(v1);
        for(int i=0;i<v1.size();i++){
            if(v1.elementAt(i)!=0)
                break;
            else v1.removeElementAt(i);
        }
        //Vector<Integer> v2=new Vector<>();
        long[] v2=new long[v1.size()];
        long s2=(long)v1.elementAt(0);
        //v2.add(s2);
        v2[0]=s2;
        for(int i=1;i<v1.size();i++){
            s2+=v1.elementAt(i);
            //v2.add(s2);
            v2[i]=s2;
        }
        //Arrays.sort(v2);
        System.out.println();
        for(int i=0;i<q;i++){
            int qu=queries[i];
            int index=Arrays.binarySearch(v2,qu);
            if(index>=0)
                System.out.println(index+1);
            else System.out.println(-index-1);
        }
    }
}
