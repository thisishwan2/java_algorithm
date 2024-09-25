package programmers.level2;

import java.util.*;
class 방문_길이 {
    public int solution(String dirs) {
        int answer = 0;

        int[][] board = new int[11][11];
        int[][][] visited = new int[11][11][4];
        int sx = 5;
        int sy = 5;


        // 본 문제의 포인트는 방향을 따지는데, 이동한 방향의 반대방향도 방문 처리를 해주는게 포인트
        // 예를 들어서 5,5 -> 4,5 로 가면 5,5의 위로가는 방향과 4,5의 아래로 가는 방향을 방문 처리한다
        for (int i=0; i<dirs.length(); i++){
            char c = dirs.charAt(i);

            if (c=='U'){
                if(0<=sx-1) {
                    if (visited[sx][sy][0]==0){
                        visited[sx][sy][0]=1;
                        visited[sx-1][sy][2]=1;
                        answer+=1;
                    }
                    sx=sx-1;
                }

            }else if(c=='D'){
                if(sx+1<=10){
                    if (visited[sx][sy][2]==0){
                        visited[sx+1][sy][0]=1;
                        visited[sx][sy][2]=1;
                        answer+=1;
                    }
                    sx=sx+1;
                }

            }else if(c=='L'){
                if(0<=sy-1){
                    if (visited[sx][sy][3]==0){
                        visited[sx][sy][3]=1;
                        visited[sx][sy-1][1]=1;
                        answer+=1;
                    }
                    sy=sy-1;
                }

            }else if(c=='R'){
                if(sy+1<=10){
                    if (visited[sx][sy][1]==0){
                        visited[sx][sy+1][3]=1;
                        visited[sx][sy][1]=1;
                        answer+=1;
                    }
                    sy=sy+1;
                }

            }
        }

        return answer;
    }
}