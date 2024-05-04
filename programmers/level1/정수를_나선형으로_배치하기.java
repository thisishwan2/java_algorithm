package programmers.level1;

import java.util.LinkedList;
import java.util.Queue;

public class 정수를_나선형으로_배치하기 {

    int [] dx = {0,1,0,-1};
    int [] dy = {1,0,-1,0};

    public int[][] solution(int n) {
        int size = n;
        int[][] answer = new int[size][size];
        Queue<int[]> q = new LinkedList<>();

        // bfs
        int x=0;
        int y=0;
        int num=1;
        int dir = 0;

        int [] now = {x,y};

        q.add(now);
        while(!q.isEmpty()){
            int[] poll = q.poll();
            x=poll[0];
            y=poll[1];

            answer[x][y] = num;
            num++;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 다음칸이 비어 있는 경우
            if (0<=nx && nx<n && 0<=ny && ny<n && answer[nx][ny]==0) {
                // 다음칸을 큐에 담는다.
                q.add(new int[]{nx, ny});
            }
            else{
                dir+=1;
                if (dir>=4){
                    dir=0;
                }

                nx = x + dx[dir];
                ny = y + dy[dir];
                if (0<=nx && nx<n && 0<=ny && ny<n && answer[nx][ny]==0) {
                    // 다음칸을 큐에 담는다.
                    q.add(new int[]{nx, ny});
                }
            }

        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        정수를_나선형으로_배치하기 a = new 정수를_나선형으로_배치하기();
        a.solution(4);
    }
}



