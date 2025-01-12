package programmers.고득점kit.정렬;

import java.util.*;

class H_Index {
    public int solution(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);

        // 0, 1, 3, 5, 6
        int answer = 0;
        for(int i=0; i<n; i++){
            // citations 내에 값(인용 횟수)이 i 이상인 것의 갯수가 i개 이상이어야 함
            // 남은 논문의 개수(n개부터 1개씩 줄어나감)
            int h = n-i;

            // 현재 비교 논문의 인용된 횟수가 남은 논문의 개수보다 크거나 같으면 정답
            if (citations[i]>=h){
                answer = h;
                break;
            }
        }

        return answer;
    }
}