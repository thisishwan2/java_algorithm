package BOJ.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_12851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int n = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int k = Integer.parseInt(st.nextToken()); // 동생 위치

        int time = 100000;
        int count = 0;

        int[] move = {1, -1, 2};

        Queue<int[]> q = new LinkedList<>();
        int[] start = {n, 0};
        q.add(start);

        // 방문처리(최단 시간안에 방문한 것을 기록) => 만약 a라는 위치에 도착하는 경우가 여러가지 인데, 큐는 시간 순서대로 수행하기 때문에 방문 배열의 값보다 작거나 같은 경우에만 큐에 넣을 수 있다.
        int [] visited = new int[100001];
        for (int i = 0; i < visited.length; i++) {
            visited[i]=Integer.MAX_VALUE;
        }

        visited[n] = 0;

        // 탈출 조건
        boolean flag = false;

        while (!q.isEmpty()) {
            int limit = q.size();
            for (int i = 0; i < limit; i++) {

                int[] poll = q.poll();
                int now = poll[0];
                int t = poll[1];

                if (now == k) {
                    time = t;
                    count += 1;
                    flag = true;
                    continue;
                }

                for (int j = 0; j < 3; j++) {
                    int next;
                    if (j == 2) {
                        next = now * move[j];

                    } else {
                        next = now + move[j];
                    }
                    if (0 <= next && next <= 100000) {
                        if (visited[next]>=t+1) {
                            q.add(new int[]{next, t + 1});
                            visited[next] = t+1;
                        }
                    }
                }
            }

            if (flag == true) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(time).append("\n").append(count);
        System.out.println(sb);
    }
}
