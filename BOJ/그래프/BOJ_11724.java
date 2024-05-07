package BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724 {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static int cnt = 0;

    public static void dfs(int start){
        visited[start] = true;
        for(int num: arr[start]){
            if (!visited[num]){
                dfs(num);
            }
        }

    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];

        arr = new ArrayList[n+1];

        for (int i =0; i<n+1; i++){
            arr[i]=new ArrayList<>();
        }

        for (int i =0; i<m; i++){
            line = br.readLine();
            st = new StringTokenizer(line, " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u].add(v);
            arr[v].add(u);
        }

//        for (ArrayList<Integer> integers : arr) {
//            System.out.println(integers.toString());
//        }

        for(int i=1; i<n+1; i++){
            if(!visited[i]){
                dfs(i);
                cnt+=1;
            }
        }
        System.out.println(cnt);
    }
}
