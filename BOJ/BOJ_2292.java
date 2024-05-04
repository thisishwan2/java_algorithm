package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2292 {
    // 1, 6, 12, 18 즉 6씩 불어남 1+6+12+18
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 1;
        int start = 1;
        int turn = 1;
        int answer = 1;

        if (n == 1) {
            System.out.println(answer);
        } else {
            while (true) {

                int tmp = start + 6 * turn;
                cnt += 1;

                if (start < n && n <= tmp) {
                    System.out.println(cnt);
                    break;
                } else {
                    start = tmp;
                    turn += 1;
                }
            }
        }
    }
}
