package programmers.level2;

import java.util.*;
class k진수에서_소수_개수_구하기 {
    public int solution(int n, int k) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        // 10진수가 0이 될때까지

        // 11 = 8+2+1 = 1011
        while (n>0){
            int tmp = n%k;
            sb.append(tmp);
            n=n/k;
        }

        // 리버스
        String res = sb.reverse().toString();

        // 1111111111 와 같이 int를 넘는 수의 경우 고려
        String[] str= res.split("0");

        for(String s: str){
            if (s.equals("")){
                continue;
            }

            long num = Long.valueOf(s);

            if (num==1){
                continue;
            }

            // 소수 판별
            int sqrtNum = (int) Math.floor(Math.sqrt(num));

            boolean flag = true;
            for(int i=2; i<=sqrtNum; i++){
                if (num%i==0){
                    flag=false;
                    break;
                }
            }
            if (flag){
                answer+=1;
            }
        }

        return answer;
    }
}