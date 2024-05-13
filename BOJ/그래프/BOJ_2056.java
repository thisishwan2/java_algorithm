package BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2056 {

    public static void topologicalSorting(int n, ArrayList<ArrayList<Integer>>arr, int[] indegree, int[] time){
        Queue<Integer> queue = new LinkedList<>();
        int [] res = new int[n+1];

        // 결과에 미리 각 작업의 시간을 넣음(dp처럼 결과를 더해가면서 바꾸기 위해 time과 똑같은 배열을 만드는것)
        for (int i = 0; i <= n; i++){
            res[i] = time[i];

            // indegree가 0인 작업을 큐에 넣음(위상 정렬의 시작점. 문제에서는 1번 작업)
            if (indegree[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int now  = queue.poll();

            ArrayList<Integer> nodes = arr.get(now);

            for (Integer next : nodes) {
                indegree[next] --;
                // 기존에 입력된 다음 작업의 시간과 다음작업에 현재 노드의 시간과 다음 노드의 작업시간의 크기 비교
                res[next] = Math.max(res[next], time[next]+res[now]);

                // 새로 indegree가 0이 된 작업을 큐에 넣음
                if (indegree[next] == 0){
                    queue.add(next);
                }
            }
        }
        int ans = 0;
        for (int r : res) {
            ans = Math.max(ans, r);
        }

        System.out.println(ans);
    }


    public static void main(String[] args) throws IOException {
//        dp();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        int[] indegree = new int[n + 1]; // i번째 노드의 선행 노드의 수(위상 정렬로 풀이)
        int[] time = new int[n + 1]; // i번째 노드의 작업에 걸리는 시간

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int workCnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < workCnt; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                arr.get(tmp).add(i); // 인접행렬 2번째 작업의 선행작업이 1이면 arr.get(2).add(1) 즉, 2에 1을 넣는다.
                indegree[i]++;
            }
        }

//        for (ArrayList<Integer> integers : arr) {
//            for (Integer integer : integers) {
//                System.out.print(integer+" ");
//            }
//            System.out.println();
//        }
        topologicalSorting(n, arr, indegree, time);
    }

    // dp를 이용한 풀이법
    public static void dp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int dp[] = new int[n+1];

        for (int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            dp[i] = time;

            for (int j =0; j<count; j++){
                int num = Integer.parseInt(st.nextToken());

                dp[i] = Math.max(dp[i], dp[num] + time);

            }
        }
//        System.out.println(dp);
        int ans = 0 ;
        for (int i : dp) {
            ans = Math.max(ans,i);
        }
        System.out.println(ans);
    }
}
