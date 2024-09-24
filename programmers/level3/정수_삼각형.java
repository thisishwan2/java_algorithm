package programmers.level3;

import java.util.*;
class 정수_삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int h = triangle.length;

        int[][] dp = new int[h][];

        // 각 행의 크기 지정
        for (int i = 0; i < h; i++) {
            dp[i] = new int[i + 1]; // i+1 크기의 배열 생성
        }


        // 마지막 줄만 triangle 값으로 채운다.
        for(int i=0; i<triangle[h-1].length; i++){
            dp[h-1][i] = triangle[h-1][i];
        }

        for(int i=h-1; i>0; i--){
            for(int j=0; j<triangle[i].length; j++){
                if (j==0){ // 처음에는 윗칸의 0번 인덱스만 확인
                    dp[i-1][j] = Math.max(triangle[i-1][j]+dp[i][j], dp[i-1][j]);
                }
                else if(j==triangle[i].length-1){// 마지막은 윗칸의 마지막 인덱스만 확인
                    dp[i-1][j-1] = Math.max(triangle[i-1][j-1]+dp[i][j], dp[i-1][j-1]);
                }
                else{
                    dp[i-1][j-1] = Math.max(triangle[i-1][j-1]+dp[i][j], dp[i-1][j-1]);
                    dp[i-1][j] = Math.max(triangle[i-1][j]+dp[i][j], dp[i-1][j]);
                }
            }
        }

        // for (int i=0; i<dp.length; i++){
        //     for(int j=0; j<dp[i].length; j++){
        //         System.out.print(dp[i][j]);
        //     }
        //     System.out.println();
        // }

        return dp[0][0];
    }
}