package programmers.level2;

import java.util.*;
class 다음_큰_숫자 {
    public int solution(int n) {
        int answer = 0;
        int oneCnt = 0;
        String nbin = Integer.toBinaryString(n);
        for (int i=0; i<nbin.length(); i++){
            if (nbin.charAt(i) == '1'){
                oneCnt+=1;
            }
        }


        int origin = n;
        while (true){
            n+=1;

            String bin = Integer.toBinaryString(n);

            int cnt = 0;
            for (int i=0; i<bin.length(); i++){
                if (bin.charAt(i) == '1'){
                    cnt+=1;
                }
            }

            if (oneCnt == cnt){
                answer = n;
                break;
            }
        }

        return answer;
    }
}
