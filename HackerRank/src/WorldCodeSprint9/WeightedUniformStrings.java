package WorldCodeSprint9;

        import java.io.*;
        import java.util.*;

/**
 * Created by Brijesh on 28-01-2017.
 */
public class WeightedUniformStrings {
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
        String s=br.readLine();
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[s.length()];
        HashSet<Integer> set=new HashSet<>();
        arr[0]=s.charAt(0)-'a'+1;
        set.add(s.charAt(0)-'a'+1);
        for (int i=1;i<s.length();i++){
            if (s.charAt(i)==s.charAt(i-1)) {
                set.add(arr[i-1]+(s.charAt(i)-'a'+1));
                arr[i]=arr[i-1]+(s.charAt(i)-'a'+1);
            } else {
                set.add(s.charAt(i)-'a'+1);
                arr[i]=s.charAt(i)-'a'+1;
            }
        }
        for (int i=0;i<n;i++)
            if (set.contains(Integer.parseInt(br.readLine())))
                System.out.println("Yes");
            else System.out.println("No");

        System.exit(0);
    }
}
