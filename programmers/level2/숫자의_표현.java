package programmers.level2;

class 숫자의_표현 {
    // 투포인터
    public int solution(int n) {
        int answer = 0;

        int start = 0;
        int end = 0;

        int num = 0;

        if (n==1){
            return 1;
        }

        while (true){

            if (start == n){
                answer+=1;
                break;
            }

            if (num==n){
                answer+=1;
                end+=1;
                num+=end;
            }
            else if (num>n){
                num-=start;
                start+=1;
            }
            else if (num<n){
                end+=1;
                num+=end;
            }
        }

        return answer;
    }
}
