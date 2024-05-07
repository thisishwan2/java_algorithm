package BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 방문할 수 있는 정점이 여러개면 정점 번호가 작은것 부터 먼저 방문
public class BOJ_1260 {

    static ArrayList<Integer>[] arr;
    static Queue<Integer> q;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int n;
    static int m;

    public static void bfs(int start){
        q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()){
            Integer num = q.poll();
            sb.append(num).append(" ");

            for (Integer i : arr[num]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

        sb.append("\n");
        System.out.println(sb);
    }

    public static void dfs(int start){
        visited[start] = true;
        sb.append(start).append(" ");
        for (int next : arr[start]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        for (int i=0; i<n+1; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            arr[i] = tmp;
        }

        for (int i =0; i<m; i++){
            line = br.readLine();
            st = new StringTokenizer(line, " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for(int i =0; i<arr.length; i++){
            Collections.sort(arr[i]);
        }

        ArrayList<Integer> tmp = new ArrayList<>();
        visited = new boolean[arr.length];
        visited[v]=true;
        tmp.add(v);
        dfs(v);
        sb.append("\n");
        visited = new boolean[arr.length];
        bfs(v);





    }

    public static void print(){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
