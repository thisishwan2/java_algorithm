package programmers.level2;

import java.util.*;

public class 점프와_순간_이동 {
    static int[] next;
    public int solution(int n) {
        int ans = 0;

        // n에서 0이될때까지
        while (n!=0){

            while (n%2==0){
                n=n/2;
            }
            n-=1;
            ans+=1;
        }
        return ans;
    }
}
