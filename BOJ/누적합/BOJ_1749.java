package BOJ.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_1749{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][m+1];

        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<m+1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // arr를 누적합 배열로 만든다.
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                arr[i][j] = arr[i][j]+arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
            }
        }

        // 이제 모든 부분 행렬에 대해 탐색하며 정수의 최대 합을 구한다.
        // 4중 for문
        long ans = Long.MIN_VALUE;
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                for(int a=i; a<n+1; a++){
                    for(int b=j; b<m+1; b++){
                        ans = Math.max(ans, arr[a][b]-arr[i-1][b]-arr[a][j-1]+arr[i-1][j-1]);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}