package programmers.고득점kit.완전탐색;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int total = brown + yellow;

        for(int garo=brown; garo>=3; garo--){
            if((total%garo==0) && (total/garo>0)){
                int sero = total/garo;

                if((brown == 2*garo + (sero-2)*2) && ((garo-2)*(sero-2)==yellow)){
                    return new int[]{garo, sero};
                }
            }
        }
        return answer;
    }
}
