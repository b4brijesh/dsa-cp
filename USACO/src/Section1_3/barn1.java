package Section1_3;
/*
ID: bsahoon1
LANG: JAVA
TASK: milk
*/
import java.io.*;
import java.util.*;
public class barn1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("palsquare.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int[] cows=new int[c];
        int i;
        for(i=0;i<c;i++)
            cows[i]=Integer.parseInt(br.readLine());
        Arrays.sort(cows);
        int[] gaps=new int[c-1];
        for(i=0;i<c-1;i++)
            gaps[i]=cows[i+1]-cows[i];
        Arrays.sort(gaps);
        int covered=cows[c-1]-cows[0]+1;
        for(i=0;i<m-1;i++){
            covered=covered-(gaps[c-2-i]-1);
            if(covered<=c)
                break;
        }
        System.out.println(covered);
    }
}
