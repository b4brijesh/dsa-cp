package march17Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Brijesh on 13-03-2017.
 */
public class PSHTBRTH {
    static int e09$7 = 1000000007;
    static double e_06 = 0.000001;
    static long INF = 1000000000000000L;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc = "/home/brijesh/Downloads/";
    static String d_loc2 = "C:\\Users\\Brijesh\\Downloads\\";

    public static void main(String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //Find grundy numbers of all matrix configs
        grundy = new int[65536];
        Arrays.fill(grundy, -1);
        grundy[0] = 0;
        for (int i = 1; i < 65536; i++) {
            int gn = findGrundyNum(i);
            grundy[i] = gn;
        }

        int t = Integer.parseInt(br.readLine());
        tree = new ArrayList<>(1000000);
        for (int j = 0; j < 1000000; j++)
            tree.add(j, 0);
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            A = new int[n];
            for (int i = 0; i < n; i++) {
                String a = br.readLine(), b = br.readLine();
                String c = br.readLine(), d = br.readLine();
                br.readLine();
                String str = a.trim() + b.trim() + c.trim() + d.trim();
                int num = Integer.parseInt(str, 2);
                //System.out.println(num);
                A[i]=grundy[num];
                //System.out.println(A[i]);
            }
            build_segtree(1, 0, n - 1);
            for (int i=0;i<m;i++) {
                st = new StringTokenizer(br.readLine());
                int type = Integer.parseInt(st.nextToken());
                if (type==1) {
                    int L = Integer.parseInt(st.nextToken());
                    int R = Integer.parseInt(st.nextToken());
                    int val = get(1, 0, n - 1, L - 1, R - 1);
                    //System.out.println(val);
                    if (val!=0) System.out.println("Pishty");
                    else System.out.println("Lotsy");
                } else {
                    int pos=Integer.parseInt(st.nextToken());
                    String a = br.readLine(), b = br.readLine();
                    String c = br.readLine(), d = br.readLine();
                    //br.readLine();
                    String str = a.trim() + b.trim() + c.trim() + d.trim();
                    int num = Integer.parseInt(str, 2);
                    update(1, 0, n - 1, pos-1, grundy[num]);
                }
            }
        }

        System.exit(0);
    }

    static int[] grundy;

    static int findGrundyNum(int n) {
        int[] rect = {1, 2, 3, 4, 6, 7, 8, 12, 14, 15,
                16, 17, 32, 34, 48, 51, 64, 68, 96, 102,
                112, 119, 128, 136, 192, 204, 224, 238, 240, 255,
                256, 272, 273, 512, 544, 546, 768, 816, 819, 1024,
                1088, 1092, 1536, 1632, 1638, 1792, 1904, 1911, 2048, 2176,
                2184, 3072, 3264, 3276, 3584, 3808, 3822, 3840, 4080, 4095,
                4096, 4352, 4368, 4369, 8192, 8704, 8736, 8738, 12288, 13056,
                13104, 13107, 16384, 17408, 17472, 17476, 24576, 26112, 26208, 26214,
                28672, 30464, 30576, 30583, 32768, 34816, 34944, 34952, 49152, 52224,
                52416, 52428, 57344, 60928, 61152, 61166, 61440, 65280, 65520, 65535
        };
        if (grundy[n] != -1) return grundy[n];
        //ArrayList<Integer> excluded = new ArrayList<>();
        boolean[] excluded=new boolean[65536];
        for (int i = 0; i < rect.length; i++) {
            if ((n & rect[i]) == rect[i]) {
                int next = n & ~rect[i];
                //excluded.add(findGrundyNum(next));
                excluded[findGrundyNum(next)]=true;
            }
        }
        int m = 0;
        while (excluded[m]) ++m;
        return m;
        /*Collections.sort(excluded);
        boolean found = false;
        int gn = -1;
        int i;
        for (i = 0; i < excluded.get(excluded.size() - 1); i++) {
            if (excluded.get(i) != i) {
                found = true;
                gn = i;
                break;
            }
        }
        if (!found) gn = i;
        return gn;*/
    }

    static int[] A;
    static ArrayList<Integer> tree;

    static void build_segtree(int node, int start, int end) {
        if (start == end) {
            tree.set(node, A[start]);
        } else {
            int mid = (start + end) / 2;
            build_segtree(2 * node, start, mid);
            build_segtree(2 * node + 1, mid + 1, end);
            tree.set(node, tree.get(2 * node)^tree.get(2 * node + 1));
        }
    }

    static void update(int node, int start, int end, int idx, int val) {
        if(start == end)
        {
            // Leaf node
            A[idx] = val;
            tree.set(node,val);
        } else {
            int mid = (start + end) / 2;
            if(start <= idx && idx <= mid) {
                // If idx is in the left child, recurse on the left child
                update(2*node, start, mid, idx, val);
            }
            else{
                // if idx is in the right child, recurse on the right child
                update(2*node+1, mid+1, end, idx, val);
            }
            // Internal node will have the sum of both of its children
            //tree[node] = tree[2*node] + tree[2*node+1];
            tree.set(node,tree.get(2 * node)^tree.get(2 * node + 1));
            //update(2 * node, start, mid, l, r);
            //update(2 * node + 1, mid + 1, end, l, r);
            //tree.set(node, Math.max(tree.get(2 * node), tree.get(2 * node + 1)));
        }
    }

    static int get(int node, int start, int end, int l, int r) {
        if (r < start || end < l)
            return 0;
        if (l <= start && r >= end)
            return tree.get(node);
        int mid = (start + end) / 2;
        int m1 = get(2 * node, start, mid, l, r);
        int m2 = get(2 * node + 1, mid + 1, end, l, r);
        return m1^m2;
    }
}
