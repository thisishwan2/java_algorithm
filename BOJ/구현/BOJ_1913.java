package BOJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1913 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int [][] arr = new int[n][n];

        int x = n/2, y = n/2;
        int dir = 0;
        arr[x][y] = 1;

        int ans_x = 0;
        int ans_y = 0;

        while (true){
            if (arr[x][y] == target){
                ans_x = x+1;
                ans_y = y+1;
            }

            if (arr[x][y] == n*n){
                break;
            }

            // 현재 방향으로 한칸 이동
            int nx = x+dx[dir];
            int ny = y+dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
            arr[nx][ny] = arr[x][y]+1;

            // 오른쪽이 빈칸이면 방향을 현재방향의 오른족으로 바꿈
            int n_dir = (dir+1)%4;

            int nnx = nx+dx[n_dir];
            int nny = ny+dy[n_dir];

            if (nnx >= 0 && nny >= 0 && nnx < n && nny < n && arr[nnx][nny] == 0) {
                dir = n_dir;
            }

            x=nx;
            y=ny;
        }

        StringBuilder sb = new StringBuilder();

        for (int[] ints : arr) {
            for (int num : ints) {
                sb.append(num + " ");
            }
            sb.append("\n");
        }
        sb.append(ans_x+ " " + ans_y);

        System.out.println(sb);
    }

}
