package apac17B;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 28-08-2016.
 */
public class WatsonAndIntervals {
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("F://A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new FileReader("F://C-small-practice.in"));
        //BufferedReader br = new BufferedReader(new FileReader("F://A-large.in"));
        BufferedWriter bw=new BufferedWriter(new FileWriter(new File("F://zzoutput.txt")));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int L1=Integer.parseInt(st.nextToken());
            int R1=Integer.parseInt(st.nextToken());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            int C1=Integer.parseInt(st.nextToken());
            int C2=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());

            int xi=L1,yi=R1;
            ArrayList<Interval> list=new ArrayList<>();
            list.add(new Interval(true,xi));
            list.add(new Interval(false,yi));
            //System.out.println("x,y="+xi+" "+yi);
            int oxi=xi,oyi=yi;
            for(int j=2;j<=N;j++){
                xi=((A*oxi)+(B*oyi)+C1)%M;
                yi=((A*oyi)+(B*oxi)+C2)%M;
                xi=(int)((((long)A*(long)oxi)+((long)B*(long)oyi)+(long)C1)%(long)M);
                yi=(int)((((long)A*(long)oyi)+((long)B*oxi)+(long)C2)%(long)M);
                BigInteger M1=BigInteger.valueOf((long)A*(long)oxi);
                BigInteger M2=BigInteger.valueOf((long)B*(long)oyi);
                BigInteger M3=BigInteger.valueOf((long)A*(long)oyi);
                BigInteger M4=BigInteger.valueOf((long)B*(long)oxi);
                BigInteger M5=BigInteger.valueOf((long)C1);
                BigInteger M6=BigInteger.valueOf((long)C2);
                BigInteger M7=BigInteger.valueOf((long)M);
                xi=M1.add(M2).add(M5).mod(M7).intValue();
                yi=M3.add(M4).add(M6).mod(M7).intValue();
                //System.out.println("x,y="+xi+" "+yi);
                list.add(new Interval(true,Math.min(xi,yi)));
                list.add(new Interval(false,Math.max(xi,yi)));
                oxi=xi;oyi=yi;
            }
            Collections.sort(list);
            int op_count=0,cl_count=0,rem,to_sub=0,max_sub=0,cut_len=0,old_rem=0,last_cl_index=-1;
            for(int j=0;j<list.size();j++){
                //System.out.println(list.get(j).opening+" "+ list.get(j).location);
                if(list.get(j).opening) op_count++;
                if(!list.get(j).opening) cl_count++;
                rem=op_count-cl_count;
                //System.out.println("rem="+rem);
                if(rem==1 && old_rem>1){
                    int interval;
                    if(list.get(j+1).opening)
                        interval=(list.get(j+1).location-list.get(j).location)-1;
                    else interval=(list.get(j+1).location-list.get(j).location);
                    to_sub=to_sub+interval;
                    //System.out.println("ere"+to_sub);
                }
                if(rem==0){
                    max_sub=Math.max(max_sub,to_sub);
                    to_sub=0;
                    if(list.get(j-1).opening){
                        if(last_cl_index<0 || list.get(last_cl_index).location!=list.get(j-1).location)
                            max_sub=Math.max(max_sub,(list.get(j).location-list.get(j-1).location)+1);
                        else
                            max_sub=Math.max(max_sub,(list.get(j).location-list.get(last_cl_index).location));
                    }
                    if(j!=(list.size()-1))
                        cut_len+=(list.get(j+1).location-list.get(j).location)-1;
                    //System.out.println("cu="+cut_len);
                    last_cl_index=j;
                }
                old_rem=rem;
            }
            //System.out.println("sub="+max_sub);
            /*if(max_sub==0){
                for(int j=0;j<list.size();j++){
                    if(list.get(j).opening){
                        int interval=list.get(j+1).location-list.get(j).location+1;
                        max_sub=Math.max(max_sub,interval);
                    }
                }
                //System.out.println("sub="+max_sub);
            }*/
            //System.out.println("cu="+cut_len);
            int tot_interval=((list.get(list.size()-1).location-list.get(0).location)-cut_len)+1;
            //System.out.println("tot="+tot_interval);
            System.out.println(tot_interval-max_sub);
            bw.write("Case #"+i+": "+(tot_interval-max_sub)+"\n");
        }
        bw.flush();
        bw.close();
    }
    static class Interval implements Comparable<Interval>{
        boolean opening;
        int location;
        Interval(boolean opening,int location){this.opening=opening;this.location=location;}

        @Override
        public int compareTo(Interval o) {
            if(this.location==o.location){
                if(this.opening && !o.opening) return -1;
                else if(this.opening && o.opening) return 0;
                else if(!this.opening && !o.opening) return 0;
                else return 1;
            }else return this.location-o.location;
        }
    }
}
