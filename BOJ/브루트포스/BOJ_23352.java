package BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BOJ_23352 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int loadLength = 0;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0) {
                    int[][] visited = new int[n][m];
                    int len = 0;
                    int end = 0;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j, 1});
                    visited[i][j] = 1;

                    while (!q.isEmpty()) {
                        int[] ele = q.poll();
                        int x = ele[0];
                        int y = ele[1];
                        int cnt = ele[2];

                        if (cnt > len) {
                            len = cnt;
                            end = arr[x][y];
                        } else if (cnt == len) {
                            end = Math.max(end, arr[x][y]);
                        }

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                                if (visited[nx][ny] == 0 && arr[nx][ny] != 0) {
                                    q.add(new int[]{nx, ny, cnt + 1});
                                    visited[nx][ny] = 1;
                                }
                            }
                        }
                    }
                    if (len > loadLength) {
                        loadLength = len;
                        ans = arr[i][j] + end;
                    } else if (len == loadLength) {
                        ans = Math.max(ans, arr[i][j] + end);
                    }
                }
            }
        }

        System.out.println(ans);

    }
}
