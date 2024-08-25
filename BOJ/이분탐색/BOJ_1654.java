package BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lan = new int[k];
        long max = 0;
        for (int i=0; i<k; i++){
            lan[i]= Integer.parseInt(br.readLine());
            max = Math.max(max, lan[i]);
        }

        max++;
        // n개의 랜선을 만들 수 있는 랜선의 길이가 여러개 있을때, 가장 큰 값을 구하는것은
        // n개를 초과하는 값에서 -1을 한것. 즉, upperBound로 풀 수 있다.
        long start = 0; // 시작점은 아무것도 안자르는 0이 될 수 잇다.
        long end = max; // 이때, end를 최대길이+1을 해주지 않으면 0으로 나누는 것에 대한 에러가 난다.

        while (start<end){

            // 범위가 큰 경우에는 이렇게 해야 된다.
            long mid = (start+(end-start)/2);

            int lanCnt = 0;
            for (int i : lan) {
                lanCnt+=i/mid;
            }

            // 랜선 수가 타겟값보다 크거나 같으면
            if (lanCnt>=n){
                start=mid+1;
            }else if (lanCnt<n){ // 랜선 수가 타겟값보다 작으면
                end=mid;
            }
        }

        System.out.println(start-1);
    }
}
