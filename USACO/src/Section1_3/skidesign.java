package Section1_3;
/*
ID: bsahoon1
LANG: JAVA
TASK: skidesign
*/
import java.io.*;
import java.util.*;

public class skidesign {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("skidesign.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        int n=Integer.parseInt(br.readLine());
        int[] iheight=new int[n];
        int[] fheight=new int[n];
        int i,j,cost=0,mincost=Integer.MAX_VALUE;
        for(i=0;i<n;i++){
            iheight[i]=Integer.parseInt(br.readLine());
            fheight[i]=iheight[i];
        }
        Arrays.sort(iheight);
        Arrays.sort(fheight);
        for(i=iheight[0];i<=iheight[n-1];i++){
            //System.out.println(i);
            if(iheight[n-1]-iheight[0]<17){
                cost=0;
                break;
            }
            j=0;
            cost=0;
            while(iheight[j]<i){
                //System.out.print(iheight[j] + " ");
                fheight[j]=i;
                cost=cost+(int)Math.pow(fheight[j]-iheight[j],2);
                j++;
            }
            //System.out.println();
            j=n-1;
            while(iheight[j]>i+17){
                //System.out.print(iheight[j] + " ");
                fheight[j]=i+17;
                cost=cost+(int)Math.pow(fheight[j]-iheight[j],2);
                j--;
            }
            //System.out.println();
            //System.out.println(cost+" "+mincost);
            if(cost<mincost)
                mincost=cost;
        }
        System.out.println(mincost);
    }
}
