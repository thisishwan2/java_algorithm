package BOJ.브루트포스;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

// 일곱 난쟁이 키의 합이 100이 되야함.
// 결국 완탐해야되는 것인데, 100이란 조건이 있으니 백트래킹으로 풀어보자.
public class BOJ_2309 {

    static boolean[] isUsed;
    static int[] heights;
    static StringBuilder sb;
    private void back(ArrayList<Integer> list){

        if(list.size()==7){
            if (list.stream().mapToInt(Integer::intValue).sum()==100){
                for (Integer i : list) {
                    sb.append(i).append("\n");
                }
                System.out.println(sb);
                System.exit(0);
            }
            return;
        }

        for (int i=0; i<9 ;i++){
            if (!isUsed[i]){
                isUsed[i]=true;
                list.add(heights[i]);
                back(list);
                list.remove((Integer) heights[i]); // 여기서 Integer 타입변환 없음 오류 그 이유는 heights는 int 타입 즉 원시 타입이고, List는 래퍼 타입이므로 변환이 필요/ 추가로 알게된건 int가 더 작은 값임 따라서 코테에서는 int 를 쓰는게 무리가 없음
                isUsed[i]=false;
            }
        }
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        heights = new int[9];
        isUsed = new boolean[9];

        for (int i=0; i<9; i++){
            int height = Integer.parseInt(br.readLine());
            heights[i]=height;
        }

        Arrays.sort(heights);
        ArrayList<Integer> list = new ArrayList<>();
        back(list);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new BOJ_2309().solution();
    }
}
