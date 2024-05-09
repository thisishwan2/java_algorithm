package BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17089 {

    static boolean[][] arr;
    static int [] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr =  new boolean[n+1][n+1];
        cnt = new int[n+1];
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b]=true;
            arr[b][a]=true;

            cnt[a]++;
            cnt[b]++;
        }

        int ans = Integer.MAX_VALUE;
        for (int a = 1; a<=n; a++){
            for(int b = a+1; b<=n; b++){
                if(!arr[a][b]){
                    continue;
                }
                for(int c = b+1; c<=n; c++){
                    if (!arr[a][c] || !arr[b][c]){
                        continue;
                    }
                    int sum = cnt[a] + cnt[b] + cnt[c] - 6;
                    ans = Math.min(ans, sum);
                }
            }
        }


        if (ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }
    }
}
