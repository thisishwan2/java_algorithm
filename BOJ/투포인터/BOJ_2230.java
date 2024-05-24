package BOJ.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2230 {
    static int n;
    static int m;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i]= Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // 수열에서 2개의 수를 골랐을때, 차이가 m 이상이면서, 최소인 경우
        // nC2 의 경우 존재
        int start = 0;
        int end = 0;

        while (start != arr.length-1 && end != arr.length){
            int abs = Math.abs(arr[start]-arr[end]);

            if (abs>=m){
                answer = Math.min(answer, abs);

                start+=1;
            }
            else{
                end+=1;
            }
        }
        System.out.println(answer);
    }
}
