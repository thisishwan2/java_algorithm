package programmers.고득점kit.깊이_너비_우선탐색;

import java.util.*;

public class 아이템_줍기 {

    public static void main(String[] args) {
        아이템_줍기 아이템_줍기 = new 아이템_줍기();
        아이템_줍기.solution(new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}},	1,	3,	7,	8);
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        // 좌표계(2배 늘릴것 까지 고려해서 100*100으로(-1: 내부, 0은 빈공간, 1은 테두리(이동가능한 경로))
        int[][] board = new int[101][101];

        for(int[] recCoordi : rectangle){

            // 좌표 스케일 업 (2배)
            int y1=recCoordi[0]*2;
            int x1=recCoordi[1]*2;
            int y2=recCoordi[2]*2;
            int x2=recCoordi[3]*2;

            for(int i=x1; i<x2+1; i++){
                for(int j=y1; j<y2+1; j++){
                    // 테두리가 아닌 내부의 경우 -1로 처리
                    if((x1<i && i<x2) && (y1<j &&j<y2)){
                        board[i][j]=-1;
                    }

                    // 다른 직사각형 내부가 아니면서 테두리인 경우 1로 처리
                    else if(board[i][j]!=-1){
                        board[i][j]=1;
                    }
                }
            }
        }

        // Arrays.stream(board).forEach(row -> {
        //     System.out.println(Arrays.toString(row));
        // });

        // 시작 좌표와 도달 좌표를 2배처리
        characterX = characterX*2;
        characterY = characterY*2;
        itemX = itemX*2;
        itemY = itemY*2;

        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};

        // 테두리 경로 탐색
        int dist = 0;
        int[][] visited = new int[101][101];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterY, characterX, 0});
        visited[characterY][characterX] = 1;

        while (!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0]; int y = poll[1]; int cnt = poll[2];

            if(x==itemY && y==itemX){
                return cnt/2;
            }

            for(int d = 0; d<4; d++){
                int nx = x+dx[d];
                int ny = y+dy[d];

                if(0<=nx && nx<101 && 0<=ny && ny<101){
                    if(board[nx][ny]==1 && visited[nx][ny]==0){ // 다음 칸이 테두리고 방문하지 않음
                        visited[nx][ny]=1;
                        q.add(new int[]{nx,ny,cnt+1});
                    }
                }
            }
        }


        return answer;
    }
}
