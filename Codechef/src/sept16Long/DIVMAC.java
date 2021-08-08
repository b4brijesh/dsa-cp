package sept16Long;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 08-09-2016.
 */
public class DIVMAC {
    static ArrayList<Integer> tree;
    static int[] A, lprime_div;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        lprime_div = new int[1000001];
        Arrays.fill(lprime_div, 0);
        lprime_div[0] = -1;
        lprime_div[1] = 1;
        for (int i = 2; i < lprime_div.length; i++) {
            if (lprime_div[i] == 0) {
                lprime_div[i] = i;
                int j = 2, k = j * i;
                while (k <= 1000000) {
                    if (lprime_div[k] == 0) lprime_div[k] = i;
                    k = (++j) * i;
                }
            }
        }
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            A = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                A[j] = Integer.parseInt(st.nextToken());
            //build a segment tree from this array
            tree = new ArrayList<>(1000000);
            for (int j = 0; j < 10 * n; j++)
                tree.add(j, 0);
            build_segtree(1, 0, n - 1);
            int left, right, k, l, type, L, R, val;
            boolean printed = false;
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                type = Integer.parseInt(st.nextToken());
                L = Integer.parseInt(st.nextToken());
                R = Integer.parseInt(st.nextToken());
                //System.out.println("t="+type);
                //System.out.println(Arrays.toString(A));
                if (type == 1) {//query
                    val = get(1, 0, n - 1, L - 1, R - 1);//query segtree
                    //System.out.print(val+" ");
                    sb.append(val + " ");
                    printed = true;
                } else {//update
                    //update(1,0,n-1,L-1,R-1);
                    for (k = L - 1; k <= R - 1; ) {
                        left = k;
                        for (l = left; l <= R - 1; l++) {
                            if (A[l] != 1) {
                                left = l;
                                break;
                            }
                        }
                        if (l == R) break;
                        right = left;
                        for (l = right; l <= R - 1; l++) {
                            if (A[l] == 1) {
                                right = l - 1;
                                break;
                            }
                            if (l == R - 1)
                                right = R - 1;
                        }
                        update(1, 0, n - 1, left, right);
                        k = right + 1;
                    }
                }
            }
            //System.out.println();
            if (printed)
                sb.append("\n");
        }
        System.out.print(sb);
    }

    static void build_segtree(int node, int start, int end) {
        if (start == end) {
            tree.set(node, lprime_div[A[start]]);
        } else {
            int mid = (start + end) / 2;
            build_segtree(2 * node, start, mid);
            build_segtree(2 * node + 1, mid + 1, end);
            tree.set(node, Math.max(tree.get(2 * node), tree.get(2 * node + 1)));
        }
    }

    static void update(int node, int start, int end, int l, int r) {
        if (start > end || start > r || end < l)
            return;
        if (start == end) {
            A[start] = A[start] / lprime_div[A[start]];
            tree.set(node, lprime_div[A[start]]);
            //A[start]=A[start]/lprime_div[A[start]];
            return;
        }
        int mid = (start + end) / 2;
        update(2 * node, start, mid, l, r);
        update(2 * node + 1, mid + 1, end, l, r);
        tree.set(node, Math.max(tree.get(2 * node), tree.get(2 * node + 1)));
    }

    static int get(int node, int start, int end, int l, int r) {
        if (r < start || end < l)
            return 0;
        if (l <= start && r >= end)
            return tree.get(node);
        int mid = (start + end) / 2;
        int m1 = get(2 * node, start, mid, l, r);
        int m2 = get(2 * node + 1, mid + 1, end, l, r);
        return Math.max(m1, m2);
    }
}
