package march17Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 11-03-2017.
 */
public class SCHEDULE {
    static int e09$7=1000000007;
    static double e_06=0.000001;
    static long INF=1000000000000000L;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    static String d_loc2="C:\\Users\\Brijesh\\Downloads\\";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        while (t-->0) {
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            String s=br.readLine();
            /*if (s.length()==1) {
                System.out.println(1);
                continue;
            }*/
            boolean ptd=false;
            int l=k;

            int c3=0,c4=0;
            //even_idx = 1 case
            for (int i=0;i<n;i++) {
                if (i%2==0) {
                    if (s.charAt(i)=='0') c3++;
                } else {
                    if (s.charAt(i)=='1') c3++;
                }
            }
            //odd_idx = 1 case
            for (int i=0;i<s.length();i++) {
                if (i%2==0) {
                    if (s.charAt(i)=='1') c4++;
                } else {
                    if (s.charAt(i)=='0') c4++;
                }
            }
            int min2=Math.min(c3,c4);
            if (min2<=l) {
                ptd=true;
                System.out.println(1);
            }
            ArrayList<Integer> blocks=new ArrayList<>();
            char ch=s.charAt(0);
            int count=1;
            for (int i=1;i<s.length();i++) {
                char ch2=s.charAt(i);
                if (ch2!=ch) {
                    blocks.add(count);
                    count=1;
                } else count++;
                ch=ch2;
            }
            blocks.add(count);
            PriorityQueue<Block> pq = new PriorityQueue<>(new Comparator<Block>() {
                @Override
                public int compare(Block o1, Block o2) {
                    return o2.max_part_len-o1.max_part_len;
                }
            });
            for (int i=0;i<blocks.size();i++) {
                if (blocks.get(i)!=1)
                    pq.add(new Block(blocks.get(i),1,blocks.get(i)));
            }

            if (!ptd) {
                while (k-->0) {
                    Block b = pq.poll();
                    if (b==null) {
                        ptd=true;
                        System.out.println(2);
                        break;
                    }
                    if (b.max_part_len==1) {
                        pq.offer(b);
                        break;
                    }
                    /*if (b.len==2 && b.parts==1) {
                        ptd=true;
                        System.out.println(2);
                        break;
                    }*/
                    int p=b.parts;
                    int rem=b.len-p;
                    double r=rem,pt=p+1,pt2=p+2;
                    int mpl=(int)Math.ceil(r/pt);
                    int mpl2=(int)Math.ceil(r/pt2);
                    if (mpl2==1) continue;
                    //System.out.println(r+" "+pt+" "+mpl);
                    Block bk=new Block(b.len,p+1,mpl);
                    pq.offer(bk);
                }
            }
            if (!ptd) {
                if (pq.peek()==null) System.out.println(2);
                else if (pq.peek().max_part_len!=1)
                    System.out.println(pq.peek().max_part_len);
                else System.out.println(2);
            }
        }

        System.exit(0);
    }
}
class Block {
    int len,parts,max_part_len;
    Block(int len,int parts,int max_part_len) {
        this.len=len;
        this.parts=parts;
        this.max_part_len=max_part_len;
    }
}
