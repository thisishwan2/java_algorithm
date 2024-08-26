package BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] tree = new int[n];
        st = new StringTokenizer(br.readLine());
        int max_num = 0;
        for(int i=0; i<n; i++){
            tree[i] = Integer.parseInt(st.nextToken());
            max_num = Math.max(max_num, tree[i]);
        }

        int start = 0;
        int end = max_num;

        // 적어도 m 미터의 나무를 가져간다 => 딱 m미터를 가져가거나, m미터보다 더 가져가는 경우
        // ex: 적어도 4미터를 가져가야 하는데, 나무가 20, 16 이 있는 경우 15를 높이로 설정하면 6미터를 가져감.
        // 따라서, m미터를 초과하는 높이를 구해야한다.
        // upper bound
        while (start<end){
            int mid = (start+end)/2;

            int cut = 0;
            for (int i : tree) {
                if (i-mid>0){
                    cut+=(i-mid);
                }
            }

            // 잘려 나온 길이가 m미터보다 작으면 더 많이 잘라야하므로 자르는 높이를 낮춰야함
            if (cut<m){
                end=mid;
            }
            // 잘려 나온 길이가 m미터보다 크거나 같으면 높이를 더 높힌다.
            // 이때 같은 경우에도 높이는 이유는 높혔을때, m미터보다 적게 나온다면, end가 줄어들 것이고,
            // 결국 마지막에 start-1을 해주면 다시 m미터가 되기 때문이다.
            else if(cut>=m){
                start = mid+1;
            }
        }
        System.out.println(start-1);
    }
}
