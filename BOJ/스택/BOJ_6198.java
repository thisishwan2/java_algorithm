package BOJ.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// i번째 건물을 볼 수 있는 다른 건물의 수를 구하는 문제이다.
public class BOJ_6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long ans=0;
        Stack<Integer> s = new Stack<>();
        // i번째 건물을 볼수 있는 건물의 수 구하기 (높이가 더 큰 건물만 스택 삽입)
        for (int i=0; i<n; i++){
            int h = Integer.parseInt(br.readLine());
            while (!s.isEmpty()){
                // 스택에 있는 건물과 i번째 건물의 높이 비교
                if (s.peek()<=h){
                    // 스택의 건물이 i건물과 높이가 같거나 작으면 삭제
                    s.pop();
                }
                else break;
            }
            // i번째 건물을 볼 수 있는(큰) 건물의 수
            ans+=s.size();
            s.add(h);
        }
        System.out.println(ans);
    }
}
