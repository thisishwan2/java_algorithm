package BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


// 본 문제는 교환이 딱 한번만 이뤄졌을때, 먹을 수 있는 사탕의 최대 개수를 찾는 것이다.(조건에 없어서 적음)
// 결국 주어진 n의 최대 크기가 50이기 때문에 2중 for문 이상 사용이 가능하고, 진짜 완탐을 하는 거였다.
// 중요한건 2개의 같은 행의 요소를 swap하면 그 두 요소의 열을 확인하고, 행도 한번 확인해야한다.
// 열도 같은 원리
public class BOJ_3085 {
    private static int ans = 1;
    private static int n;
    private static String[][] array;

    // 행 체크
    private void chkRow(int x){ // 파라미터는 행 인덱스
        int now_alpha_cnt = 1;

        String nowAlpha = array[x][0];
        for(int i=1; i<n; i++){
            if(nowAlpha.equals(array[x][i])){
                now_alpha_cnt++;
            }else {
                nowAlpha=array[x][i];
                ans = Math.max(ans, now_alpha_cnt);
                now_alpha_cnt=1;
            }
        }
        ans = Math.max(ans, now_alpha_cnt);
    }

    // 열 체크
    private void chkCol(int x){
        int now_alpha_cnt = 1;
        String nowAlpha = array[0][x];
        for (int i=1; i<n; i++){
            if(nowAlpha.equals(array[i][x])){
                now_alpha_cnt++;
            }else {
                nowAlpha = array[i][x];
                ans = Math.max(ans, now_alpha_cnt);
                now_alpha_cnt=1;
            }
        }
        ans = Math.max(ans, now_alpha_cnt);
    }

    // swap
    private void swap(int x_1, int y_1, int x_2, int y_2){
        String tmp = array[x_1][y_1];
        array[x_1][y_1] = array[x_2][y_2];
        array[x_2][y_2] = tmp;
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new String[n][n];
        for (int i =0; i<n; i++) {
            String line = br.readLine();
            for (int j=0; j<n; j++){
                array[i][j]= String.valueOf(line.charAt(j));
            }
        }

        // 시작전 전체 확인
        for (int i=0; i<n; i++){
            chkCol(i);
            chkRow(i);
        }


        for (int i =0; i<n; i++) {
            for (int j=0; j<n; j++){
                if (j+1<n){ // 열이 넘지 않을때(열 스왑)
                    swap(i,j,i,j+1);
                    chkCol(j);
                    chkCol(j+1);
                    chkRow(i);
                    swap(i,j,i,j+1);
                }
                if (i+1<n){ // 행이 넘지 않을때(행 스왑)
                    swap(i,j,i+1,j);
                    chkRow(i);
                    chkRow(i+1);
                    chkCol(i);
                    swap(i,j,i+1,j);
                }
            }
        }
        System.out.println(ans);

    }
    public static void main(String[] args) throws IOException {
        new BOJ_3085().solution();
    }
}
