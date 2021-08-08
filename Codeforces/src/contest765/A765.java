package contest765;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 14-02-2017.
 */
public class A765 {
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
        int n=Integer.parseInt(br.readLine());
        LinkedList<String> list=new LinkedList<>();
        String home=br.readLine().trim();
        for (int i=1;i<=n;i++) {
            list.add(br.readLine());
        }
        boolean ptd=false;
        while (!list.isEmpty()) {
            String f=list.getFirst();
            list.removeFirst();
            String src=f.substring(0,3);
            String des=f.substring(5,8);
            String search=des+"->"+src;
            //System.out.println(search);
            ListIterator<String> it=list.listIterator();
            boolean found=false;
            while (it.hasNext()) {
                if (it.next().equals(search)) {
                    found=true;
                    list.remove(search);
                    break;
                }
            }
            if (!found) {
                System.out.println("contest");
                ptd=true;
                break;
            }
        }
        if (!ptd) System.out.println("home");

        System.exit(0);
    }
}
