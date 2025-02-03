package programmers.고득점kit.동적계획법;

import java.util.*;

public class 정수_삼각형 {
    /*
        7, x, x, x, x
        3, 8, x, x, x
        8, 1, 0, x, x
        2, 7, 4, 4, x
        4, 5, 2, 6, 5
    */
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];

        for(int i=0; i<triangle.length; i++){
            if(i==0){
                dp[0][0]=triangle[0][0];
                continue;
            }
            for(int j=0; j<triangle[i].length; j++){
                if(j==0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]+triangle[i][j]);
                }else if(j==triangle[i].length-1){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+triangle[i][j]);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1]+triangle[i][j], dp[i-1][j]+triangle[i][j]);
                }
            }
        }

        for(int i=0; i<triangle[triangle.length-1].length; i++){
            answer = Math.max(answer, dp[triangle.length-1][i]);
            // System.out.println(dp[triangle.length-1][i]);
        }


        return answer;
    }
}
