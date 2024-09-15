package programmers.level2;

import java.util.*;
class 최솟값_만들기
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        // 하나는 앞에서 하나는 뒤에서 곱한다.
        for (int i=0; i<A.length; i++){
            answer+=A[i]*B[A.length-1-i];
        }
        return answer;
    }
}