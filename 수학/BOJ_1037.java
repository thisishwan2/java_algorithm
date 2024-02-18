package 수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 본 문제는 특정 수((우리가 구하려는)의 약수를 전부 준다 -> 본인은 전부 준다고 생각을 못함(문제를 똑바로 안읽음..)
// 따라서 약수의 쌍을 곱하면 우리가 구하고자하는 값이 나옴
public class BOJ_1037 {

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n_cnt = Integer.parseInt(br.readLine()); // Integer.valueOf 대신 기본형을 사용
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] num = new int[n_cnt]; // 기본형 배열 사용

        for (int i = 0; i < n_cnt; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num); // 배열 정렬

        // 최소값과 최대값을 곱함
        System.out.println(num[0] * num[n_cnt - 1]);
    }

    public static void main(String[] args) throws Exception {
        new BOJ_1037().solution();
    }
}
