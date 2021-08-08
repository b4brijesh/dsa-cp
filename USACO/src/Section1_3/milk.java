package Section1_3;
/*
ID: bsahoon1
LANG: JAVA
TASK: milk
*/
import java.io.*;
import java.util.*;

public class milk {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("palsquare.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int i;
        class milkman implements Comparable<milkman>{
            int units=0;
            int cost=0;
            @Override
            public int compareTo(milkman o) {
                return this.cost-o.cost;
            }
        }
        milkman[] milkmans=new milkman[m];
        for(i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            milkmans[i]=new milkman();
            milkmans[i].cost=Integer.parseInt(st.nextToken());
            milkmans[i].units=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(milkmans);
        int bought=0,cost=0;
        i=0;
        while(bought<n){
            if(milkmans[i].units<=(n-bought)){
                bought=bought+milkmans[i].units;
                cost=cost+(milkmans[i].units*milkmans[i].cost);
                //System.out.println(cost);
            }
            else{
                cost=cost+((n-bought)*milkmans[i].cost);
                bought=bought+(n-bought);
                //System.out.println(cost);
            }
            i++;
        }
        System.out.println(cost);
    }
}
