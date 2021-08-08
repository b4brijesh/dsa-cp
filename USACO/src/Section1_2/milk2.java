package Section1_2;
/*
ID: bsahoon1
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;
public class milk2 {
    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st;
        int i;
        class milkT implements Comparator<milkT>,Comparable<milkT>{
            int startT,stopT;
            milkT(){
                startT=0;
                stopT=0;
            }
            public int compare(milkT f1,milkT f2){
                return f1.startT-f2.startT;
            }
            public int compareTo(milkT f1){
                return this.startT-f1.startT;
            }
        }
        milkT arr[]=new milkT[n];
        for(i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            arr[i]=new milkT();
            arr[i].startT=Integer.parseInt(st.nextToken());
            arr[i].stopT=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int maxCont=arr[0].stopT-arr[0].startT,maxIdle=0,min=arr[0].startT,max=arr[0].stopT;
        for(i=1;i<n;i++){
            if(arr[i].startT<=Math.max(max,arr[i-1].stopT))
                max=Math.max(max,arr[i].stopT);
            else{
                maxCont=Math.max(maxCont,max-min);
                maxIdle=Math.max(maxIdle,arr[i].startT-max);
                min=arr[i].startT;
                max=arr[i].stopT;
            }
        }
        //System.out.println(maxCont+" "+maxIdle);
        out.println(maxCont+" "+maxIdle);
        out.close();
    }
}
