package BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i =0; i<n;i++){
            map.putIfAbsent(Integer.parseInt(st.nextToken()), 1);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        line = br.readLine();
        st = new StringTokenizer(line);
        for (int i =0; i<m;i++){
            Integer res = map.get(Integer.parseInt(st.nextToken()));
            if (res==null){
                sb.append(0).append("\n");
            }else{
                sb.append(1).append("\n");
            }
        }
        System.out.println(sb);

    }
    static void bs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int[] arr = new int[n];
        for (int i =0; i<n;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        // 배열 정렬시
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        line = br.readLine();
        st = new StringTokenizer(line);
        StringBuilder sb = new StringBuilder();
        for (int i =0; i<m;i++){
            int ans = 0;
            int num = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = arr.length-1;
            while (left<=right){
                int mid = (left+right)/2;

                // 타겟값보다 mid가 크면,
                if (arr[mid]>num){
                    right = mid-1;
                }
                // 타겟값보다 mid가 작으면
                else if (arr[mid]<num){
                    left = mid+1;
                }
                else{
                    ans = 1;
                    break;
                }
            }

            if (ans==0){
                sb.append(0).append('\n');
            }else{
                sb.append(1).append('\n');
            }
        }
        System.out.println(sb);
    }
}
