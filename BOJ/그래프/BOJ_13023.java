package BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 이 문제에서 주어진 사람의 수 만큼 a-b-c-d-e-f-g-... 를 만족하는 것을 구하는게 아닌
// a-b-c-d-e 를 만족하는 관계가 있는지만 확인하면됨
// 0-1-2-3-0 과 같은 관계도 a-b-c-d-e를 만족하는 관계임

// 즉, 모든 노드들을 연결시켜놓고 1~n까지 시작점으로 잡고 깊이 탐색했을대 깊이가 5가 되면 됨

public class BOJ_13023 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static Integer n;
    static int res = 0;
    public static void dfs(int num){

        int cnt=0;
        for (boolean b: visited){
            if (b==true){
                cnt+=1;
            }
        }

        if (cnt==5){
            res = 5;
            return;
        }

        for(int i : list[num]){
            if(visited[i]==false){
                visited[i]=true;
                dfs(i);
                visited[i]=false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st;

        st = new StringTokenizer(line, " ");
        n = Integer.valueOf(st.nextToken());
        Integer m = Integer.valueOf(st.nextToken());

        // 자바에서 인접리스트를 구현하는 방법
        list = new ArrayList[n];
        for (int i=0; i<n; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            list[i] = tmp;
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

//        for (ArrayList<Integer> integers : list) {
//            System.out.println(integers);
//        }

        for(int i=0; i<n; i++){
            visited = new boolean[n];
            visited[i]=true;
            dfs(i);

            if (res == 5){
                System.out.println(1);
                System.exit(0);
            }
        }
        System.out.println(0);
    }
}
