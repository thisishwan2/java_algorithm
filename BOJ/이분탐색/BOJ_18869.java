package BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18869 {
    static int bs(int[] sorted, int target){
        // 정렬된 sorted 배열에서 target 값의 인덱스를 찾는다.
        int start = 0;
        int end = sorted.length-1;

        int result = 0;
        while (start<=end) {
            int mid = (start + end) / 2;

            if (sorted[mid] > target) {
                end = mid - 1;
            } else if (sorted[mid] < target) {
                start = mid + 1;
            } else {
                result=mid;
                break;
            }
        }

        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        int[][] zips = new int[m][n];

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                arr[j]= Integer.parseInt(st.nextToken());
            }

            // 중복을 제거하여 오름차순으로 정렬
            int[] sorted = Arrays.stream(arr).distinct().sorted().toArray();

            for (int j=0; j<n; j++){
                zips[i][j] = bs(sorted, arr[j]);
            }
        }
        int cnt = 0;
        // 1번 행성부터 n번까지 비교.
        for (int i=0; i<m; i++){
            for (int j=i+1; j<m; j++){
                // 배열이 완전 동일한지를 비교
                if (Arrays.equals(zips[i],zips[j])){
                    cnt+=1;
                }
            }
        }
        System.out.println(cnt);
    }
}
