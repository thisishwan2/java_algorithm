package BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1107 {

    static ArrayList<Integer> button;
    static ArrayList<String> candidate = new ArrayList<>();

    public static void dfs(int size, ArrayList<Integer> arr){

        if(arr.size() == size){
            String tmp = "";
            for (Integer i : arr) {
                tmp+=i;
            }
            candidate.add(tmp);
            return;
        }

        for (int i = 0; i < button.size(); i++) {
            int num = button.get(i);
            arr.add(num);
            dfs(size, arr);
            arr.remove(arr.size() - 1); // 마지막 요소 제거로 변경
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 이동하고자 하는 채널
        int m = Integer.parseInt(br.readLine()); // 고장난 버튼 개수

        button = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            button.add(i);
        }

        if(m>0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < m; i++) {
                button.remove((Integer) Integer.parseInt(st.nextToken()));
            }
        }

//        System.out.println(button);

        int nowChannel = 100;

        // 100 채널이면
        if(n == nowChannel){
            System.out.println(0);
            System.exit(0);
        }

        // 100채널에서 무식하게 이동한 결과
        int res1 = Math.abs(n-nowChannel);

        // 눌러서 나오는 경우의 수를 모두 구한다.
        for (int i = 1; i< 7; i++){ // 500000이다. 예를 들어99999 일때 100000-1이 88888보다 더 빠르다.
            ArrayList<Integer> arr = new ArrayList<>();
            dfs(i, arr);
        }

        int min = (int) 1e9;
        for (String s : candidate) {
//            System.out.println(s);
            int i = s.length() + Math.abs(n - Integer.parseInt(s));
            min = Math.min(min, i);
        }

        min = Math.min(min, res1);

        System.out.println(min);
    }
}
