package BOJ.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr [] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i =0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;

        int count = 0;

        while(end != arr.length){
            int total = 0;
            for (int j =start; j<=end; j++){
                total += arr[j];
            }

            if (total == m){
                count+=1;
                start+=1;
            } else if (total<m) {
                end+=1;
            }else{
                start+=1;
            }
        }

        System.out.println(count);

    }
}
