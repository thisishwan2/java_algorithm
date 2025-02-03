package programmers.고득점kit.동적계획법;

import java.util.*;

public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[n][m];

        // 물웅덩이 위치 설정
        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        dp[0][0] = 1; // 시작점

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0; // 물웅덩이는 지나갈 수 없음
                    continue;
                }

                // 위에서 내려오는애
                if (i > 0) dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                // 왼쪽에서 오는애
                if (j > 0) dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
            }
        }

        return dp[n - 1][m - 1];
    }
}
