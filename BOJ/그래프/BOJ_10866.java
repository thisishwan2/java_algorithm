package BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();

        StringTokenizer st;
        Integer num=0;
        for (int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();

            if (cmd.equals("push_front")){
                num = Integer.parseInt(st.nextToken());
                dq.addFirst(num);
            }
            else if(cmd.equals("push_back")){
                num = Integer.parseInt(st.nextToken());
                dq.addLast(num);
            }
            else if(cmd.equals("pop_front")){
                num = dq.pollFirst();
                if (num==null){
                    System.out.println(-1);
                }else{
                    System.out.println(num);
                }
            }else if(cmd.equals("pop_back")){
                num = dq.pollLast();
                if (num==null){
                    System.out.println(-1);
                }else{
                    System.out.println(num);
                }
            }else if(cmd.equals("size")){
                System.out.println(dq.size());
            }else if(cmd.equals("empty")){
                if (dq.isEmpty()){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            } else if (cmd.equals("front")) {
                num = dq.peekFirst();
                if (num==null){
                    System.out.println(-1);
                }
                else {
                    System.out.println(num);
                }
            } else if (cmd.equals("back")) {
                num = dq.peekLast();
                if (num==null){
                    System.out.println(-1);
                }
                else {
                    System.out.println(num);
                }
            }
        }
    }
}
