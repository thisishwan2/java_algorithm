package BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        StringTokenizer st;
        int last = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();

            if (cmd.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                q.add(num);
                last = num;
            }

            if (cmd.equals("pop")){
                Integer poll_num = q.poll();
                if (poll_num == null){
                    System.out.println(-1);
                }else {
                    System.out.println(poll_num);
                }
            }

            if(cmd.equals("size")){
                System.out.println(q.size());
            }

            if(cmd.equals("empty")){
                if (q.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }

            if(cmd.equals("front")){
                Integer peek_num = q.peek(); // 원시타입은 null과 비교가 불가함
                if (q.isEmpty()){
                    System.out.println(-1);
                }
                else{
                    System.out.println(peek_num);
                }
            }

            if(cmd.equals("back")){
                if (q.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(last);
                }
            }
        }
    }
}
