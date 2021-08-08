package GraphAlgos;

import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Brijesh on 19-01-2017.
 */
public class Traversal {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<=NUM_OF_NODES; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        //example below
        int root=0;//or 1
        dfs(root);

        System.exit(0);
    }
    static int NUM_OF_NODES=0;
    static ArrayList<ArrayList<Integer>> adjacencyList=new ArrayList<>();
    static boolean[] visited,covered;

    static void dfs(int start_node) {
        Stack<Integer> stack=new Stack<>();
        stack.push(start_node);
        int top;
        while (!stack.empty()) {
            top=stack.peek();
            stack.pop();
            if (!visited[top]) {
                //check for termination
                visited[top]=true;
                ArrayList<Integer> list=adjacencyList.get(top);
                for (int i=0; i<list.size(); i++) {
                    if (!visited[list.get(i)]) {
                        visited[list.get(i)] = true;
                        stack.add(list.get(i));
                    }
                }
            }
        }
    }

    static void recursiveDfs(int node) {
        visited[node]=true;
        ArrayList<Integer> list=adjacencyList.get(node);
        for (int i=0; i<list.size(); i++) {
            if (!visited[list.get(i)]) {
                recursiveDfs(list.get(i));
            }
        }
    }

    static void bfs(int start_node) {
        Queue<Integer> que = new LinkedList<>();
        visited[start_node] = true;
        que.add(start_node);
        int front;
        while (!que.isEmpty()) {
            front=que.peek();
            que.remove();
            ArrayList<Integer> list = adjacencyList.get(front);
            for (int i=0; i<list.size(); i++) {
                if (!visited[list.get(i)]) {
                    visited[list.get(i)] = true;
                    que.add(list.get(i));
                }
            }
        }
    }
}
