package BOJ.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BOJ_1697 {
    static int n;
    static int k;
    static int[] dp = new int[100001];
    static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
        @Override
        public int compare(int[] a, int[] b){
            return a[1]-b[1];
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(dp, 100001);
        pq.add(new int[]{n,0});
        dp[n]=0;
        while (!pq.isEmpty()){
            int[] poll = pq.poll();

            if (poll[0] == k){
                System.out.println(poll[1]);
                System.exit(0);
            }

            for(int i=0; i<3; i++){
                if(i==0){
                    if(poll[0]+1<=100000 && dp[poll[0]+1]>poll[1]+1) { // 앞으로 1이동
                        pq.add(new int[]{poll[0] + 1, poll[1] + 1});
                        dp[poll[0] + 1] = poll[1] + 1;
                    }
                }else if(i==1){// 뒤로 1이동
                    if (poll[0]-1>=0 && dp[poll[0]-1]>poll[1]+1) {
                        pq.add(new int[]{poll[0] - 1, poll[1] + 1});
                        dp[poll[0]-1] = poll[1]+1;
                    }
                }else if(i==2){
                    if (poll[0]*2<=100000 && dp[poll[0]*2]>poll[1]+1){
                        pq.add(new int[]{poll[0] * 2, poll[1] + 1});
                        dp[poll[0]*2] = poll[1]+1;
                    }
                }

            }
        }
    }
}