package BOJ.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15683 {
    static int minimum = (int) 1e9;
    // 상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n =0;
    static int m =0;
    static int[] candidate;
    static int[][] arr;
    static ArrayList<int[]> lst;
    static int [][] copyMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lst = new ArrayList<>();

        // 0은 빈칸, 1~5는 CCTV 번호, 6은 벽
        arr = new int[n][m];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0 && arr[i][j]!=6){
                    int[] tmp = {i,j,arr[i][j]};
                    lst.add(tmp); // cctv 좌표와 번호를 담는다.
                }
            }
        }

        // dfs 돌릴때, CCTV의 방향을 담을 배열
        candidate = new int[lst.size()];
        // CCTV의 모든 방향을 완전 탐색하는 순열 DFS
        permutation(0,lst.size());

        System.out.println(minimum);
    }

    // dfs로 각 cctv가 가지는 방향을 설정한다.
    static void permutation(int depth, int r){

        // 모든 CCTV 방향을 설정했으면
        if (depth == r){

            // 깊은 복사로 배열을 새 배열을 만든다.(해당 배열에 감시 처리를 진행할것)
            copyMap = new int[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    copyMap[i][j] = arr[i][j];
                }
            }

            // 각 CCTV가 보는 방향에 맞게 감시처리를 한다.
            for (int i=0; i<r; i++){
                direction(lst.get(i), candidate[i]);
            }

            // 사각 지대 구한다.
            int cnt=0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if (copyMap[i][j]==0){
                        cnt+=1;
                    }
                }
            }
            minimum = Math.min(minimum, cnt);
            return;
        }

        // 4가지 방향중 하나를 선택
        for(int i=0; i<4; i++){
            candidate[depth]=i; // CCTV 방향 설정
            permutation(depth+1, r);
        }
    }

    // 각 CCTV의 번호와 방향을 맞게 감시한다.
    static void direction(int[] cctvInfo, int d){
        int cctvNum = cctvInfo[2];
        int x = cctvInfo[0];
        int y = cctvInfo[1];

        // CCTV 번호마다 방향처리해줘야하는 게 다르다
        if (cctvNum==1){
            watch(x,y,d);
        }else if (cctvNum==2){
            if (d==0 || d==1){
                watch(x,y,0);
                watch(x,y,1);
            } else {
                watch(x,y,2);
                watch(x,y,3);
            }
        }else if (cctvNum==3){
            if (d==0){
                watch(x,y,0);
                watch(x,y,3);
            }else if(d==1){
                watch(x,y,1);
                watch(x,y,2);
            } else if(d==2){
                watch(x,y,2);
                watch(x,y,0);
            } else if(d==3){
                watch(x,y,3);
                watch(x,y,1);
            }
        }else if (cctvNum==4){
            if (d==0){
                // 좌상우
                watch(x,y,2);
                watch(x,y,0);
                watch(x,y,3);
            }else if(d==1){
                // 좌하우
                watch(x,y,2);
                watch(x,y,1);
                watch(x,y,3);
            }else if(d==2){
                // 하좌상
                watch(x,y,1);
                watch(x,y,2);
                watch(x,y,0);
            }else if(d==3){
                // 상우하
                watch(x,y,0);
                watch(x,y,3);
                watch(x,y,1);
            }

        }else if (cctvNum==5) {
            watch(x,y,0);
            watch(x,y,1);
            watch(x,y,2);
            watch(x,y,3);
        }
    }

    // 해당 방향으로 감시처리를 한다.
    static void watch(int x, int y, int d){

        while (true){
            int nx=x+dx[d];
            int ny=y+dy[d];

            if (0<=nx && nx<n && 0<=ny && ny<m && copyMap[nx][ny]!=6){
                copyMap[nx][ny]=-1;
                x=nx;
                y=ny;
            }
            // 조건에 부합하지 않으면 탈출
            else{
                break;
            }
        }
    }
}

