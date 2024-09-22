package BOJ.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class BOJ_13549 {

    static int n;
    static int k;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dp = new int[100001];
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static void bfs(){
        q.add(new int[]{n, 0});
        dp[n] = 0;

        while (!q.isEmpty()){
            int[] poll = q.poll();

            if (poll[0] == k){
                continue;
            }

            for(int i=0; i<3; i++){
                if (i==0){
                    if (poll[0]+1<=100000 && dp[poll[0]+1]>poll[1]+1){
                        dp[poll[0]+1] = poll[1]+1;
                        q.add(new int[]{poll[0]+1, poll[1]+1});
                    }
                }else if (i==1){
                    if (poll[0]-1>=0 && dp[poll[0]-1]>poll[1]+1){
                        dp[poll[0]-1] = poll[1]+1;
                        q.add(new int[]{poll[0]-1, poll[1]+1});
                    }
                }else if (i==2){
                    if (poll[0]*2<=100000 && dp[poll[0]*2]>poll[1]){
                        dp[poll[0]*2] = poll[1];
                        q.add(new int[]{poll[0]*2, poll[1]});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(dp, 100001);
        bfs();
        System.out.println(dp[k]);
//
//        System.out.println(pq.peek());
//        System.out.println(pq.size());

    }
}