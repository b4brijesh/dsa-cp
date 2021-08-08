package Section1_2;
/*
ID: bsahoon1
LANG: JAVA
TASK: transform
*/
import java.io.*;
import java.util.*;
public class transform {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("transform.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        int n = Integer.parseInt(br.readLine());
        String s;
        char[][] arr1=new char[n+1][n+1];
        char[][] arr2=new char[n+1][n+1];
        int i,j,l;
        for(i=1;i<=n;i++){
            s=br.readLine();
            for(j=1;j<=n;j++)
                arr1[i][j]=s.charAt(j-1);
        }
        for(i=1;i<=n;i++){
            s=br.readLine();
            for(j=1;j<=n;j++)
                arr2[i][j]=s.charAt(j-1);
        }
        if(r90(1,n,arr1,arr2))
            l=1;
        else if(r90(2,n,arr1,arr2))
            l=2;
        else if(r90(3,n,arr1,arr2))
            l=3;
        else if(reflect(n,arr1,arr2))
            l=4;
        else if(comb(n,arr1,arr2))
            l=5;
        else if(noChange(n,arr1,arr2))
            l=6;
        else
            l=7;
        System.out.println(l);
        //out.println(l);
        //out.close();
    }
    static boolean r90(int k,int n,char[][] arr1,char[][] arr2){
        int i,j,rn=0,cn=0;
        boolean flag=true;
        outer:for(i=1;i<=n;i++){
            if(k==1)
                cn=n-i+1;
            else if(k==2)
                rn=n-i+1;
            else if(k==3)
                cn=i;
            for(j=1;j<=n;j++){
                if(k==1)
                    rn=j;
                else if(k==2)
                    cn=n-j+1;
                else if(k==3)
                    rn=n-j+1;
                if(arr1[i][j]!=arr2[rn][cn]){
                    flag=false;
                    break outer;
                }
            }
        }
        return flag;
    }
    static boolean reflect(int n,char[][] arr1,char[][] arr2){
        int i,j;
        boolean flag=true;
        outer:for(i=1;i<=n;i++){
            for(j=1;j<=n;j++){
                if(arr1[i][j]!=arr2[i][n-j+1]){
                    flag=false;
                    break outer;
                }
            }
        }
        return flag;
    }
    static boolean comb(int n,char[][] arr1,char[][] arr2){
        int i,j,k,rn=0,cn=0;
        boolean flag=true;
        for(k=1;k<=3;k++){
            flag=true;
            for(i=1;i<=n;i++){
                if(k==1)
                    cn=n-i+1;
                else if(k==2)
                    rn=n-i+1;
                else if(k==3)
                    cn=i;
                for(j=1;j<=n;j++){
                    if(k==1)
                        rn=n-j+1;
                    else if(k==2)
                        cn=j;
                    else if(k==3)
                        rn=j;
                    if(arr1[i][j]!=arr2[rn][cn])
                        flag=false;
                }
            }
            if(flag)
                break;
        }
        return flag;
    }
    static boolean noChange(int n,char[][] arr1,char[][] arr2){
        int i,j;
        boolean flag=true;
        outer:for(i=1;i<=n;i++){
            for(j=1;j<=n;j++){
                if(arr1[i][j]!=arr2[i][j]){
                    flag=false;
                    break outer;
                }
            }
        }
        return flag;
    }
}
