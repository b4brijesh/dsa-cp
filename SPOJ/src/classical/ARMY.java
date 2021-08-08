package classical;

import java.io.*;
import java.util.*;

public class ARMY {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int i,j,k;
        StringTokenizer st;
        int nga[],nma[];
        //Vector<Integer> ngv=new Vector<Integer>();
        //Vector<Integer> nmv=new Vector<Integer>();
        for(i=1;i<=t;i++){
            br.readLine();
            st=new StringTokenizer(br.readLine());
            int ng=Integer.parseInt(st.nextToken());
            int nm=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
//            for(j=1;j<=ng;j++)
//                ngv.add(Integer.parseInt(st.nextToken()));
//            st=new StringTokenizer(br.readLine());
//            for(j=1;j<=nm;j++)
//                nmv.add(Integer.parseInt(st.nextToken()));
//            Collections.sort(ngv);
//            Collections.sort(nmv);
//            while(ngv.size()>0 && nmv.size()>0){
//                if(ngv.elementAt(0)>=nmv.elementAt(0))
//                    nmv.remove(0);
//                else
//                    ngv.remove(0);
//            }
//            if(ngv.size()>0)
//                System.out.println("Godzilla");
//            else
//                System.out.println("MechaGodzilla");
            nga=new int[ng];
            nma=new int[nm];
            for(j=0;j<ng;j++)
                nga[j]=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            for(k=0;k<nm;k++)
                nma[k]=Integer.parseInt(st.nextToken());
            Arrays.sort(nga);
            Arrays.sort(nma);
            j=k=0;
            while(j<ng && k<nm){
                if(nga[j]>=nma[k])
                    k++;
                else
                    j++;
            }
            if(j==ng)
                System.out.println("MechaGodzilla");
            else
                System.out.println("Godzilla");
        }
    }
}
