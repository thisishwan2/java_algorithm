package programmers.level2;

class 예상_대진표
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        /*
        더 쉬운 풀이
        // a와 b가 서로 만날 때까지 반복
        while (a != b) {
            round++;
            // 각 플레이어는 다음 라운드로 갈 때 번호를 갱신함
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return round;

        */

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=i+1;
        }

        int round = 0;
        while (true){
            round+=1;
            int tmp[] = new int[arr.length/2];
            for(int i=0; i<arr.length; i+=2){
                // A,B 만남
                if ((a == arr[i]) && (b == arr[i+1]) || (b == arr[i]) && (a == arr[i+1])){
                    return round;
                }
                // A만 있음
                else if((a == arr[i]) || a == arr[i+1]){
                    tmp[i/2] = a;
                }
                // B만 있음
                else if((b == arr[i]) || b == arr[i+1]){
                    tmp[i/2] = b;
                }
                else{
                    tmp[i/2] = arr[i];
                }
            }

            // 배열 업데이트
            arr = tmp;
        }
    }
}
