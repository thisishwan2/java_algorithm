package BOJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_4920 {

    static int[][][] figure = { // 가장 왼쪽 위에 있는 점을 기준으로 좌표를 매긴다.
            // 1번
            {
                    {0, 0, 0, 0}, {0, 1, 2, 3}
            },
            {
                    {0, 1, 2, 3}, {0, 0, 0, 0}
            },

            // 2번
            {
                    {0, 0, 1, 1}, {0, 1, 1, 2}
            },
            {
                    {0, 1, 1, 2}, {0, 0, -1, -1}
            },

            // 3번
            {
                    {0, 0, 0, 1}, {0, 1, 2, 2}
            },
            {
                    {0, 1, 2, 2}, {0, 0, 0, -1}
            },
            {
                    {0, 1, 1, 1}, {0, 0, 1, 2}
            },
            {
                    {0, 0, 1, 2}, {0, 1, 0, 0}
            },

            // 4번
            {
                    {0, 0, 0, 1}, {0, 1, 2, 1}
            },
            {
                    {0, 1, 2, 1}, {0, 0, 0, -1}
            },
            {
                    {0, 1, 1, 1}, {0, -1, 0, 1}
            },
            {
                    {0, 1, 2, 1}, {0, 0, 0, 1}
            },

            // 5번
            {
                    {0, 0, 1, 1}, {0, 1, 0, 1}
            }
    };
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNum = 1;
        while ((n = Integer.parseInt(br.readLine().trim())) != 0) {

            ArrayList<Integer>[] list = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);
                ArrayList<Integer> arr = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    arr.add(Integer.parseInt(st.nextToken()));
                }
                list[i] = arr;
            }

            int total = Integer.MIN_VALUE;
            // 배열의 모든 부분을 순회하면서 figure을 모두 대입해봄
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = 0;
                    for (int k = 0; k < figure.length; k++) {
                        int[][] coor = figure[k]; // 좌표
                        int tmp = 0;
                        for (int l = 0; l < coor[0].length; l++) {
                            int x = coor[0][l];
                            int y = coor[1][l];

                            // 하나의 좌표라도 배열의 범위를 벗어난다면 그 figure은 넘어간다.
                            if (i + x < 0 || i + x >= n || j + y < 0 || j + y >= n) {
                                break;
                            }

                            tmp += list[x + i].get(y + j);
                        }
                        if (tmp > sum) {
                            sum = tmp;
                        }
                    }
                    if (total < sum) {
                        total = sum;
                    }
                }
            }
            System.out.println(caseNum + ". " + total);
            caseNum+=1;
        }
    }
}
