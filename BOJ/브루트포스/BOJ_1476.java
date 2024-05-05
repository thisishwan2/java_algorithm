package BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line = br.readLine();
        st = new StringTokenizer(line, " ");

        int e = Integer.parseInt(st.nextToken()); // 지구(1~15)
        int s = Integer.parseInt(st.nextToken()); // 태양(1~28)
        int m = Integer.parseInt(st.nextToken()); // 달(1~19)

        // 1년은 1 1 1로 나타냄. 1년이 지날때 마다 세수는 1씩 증가. 어떤 수가 범위를 넘어가는 경우 1이 됨.
        // 15년은 15 15 15로 나타내지만 16년이 되면 1 16 16 이 된다.

        int year = 1;
        int test_e=1;
        int test_s=1;
        int test_m=1;

        while (true){

            if (test_e == e && test_s==s && test_m==m){
                System.out.println(year);
                System.exit(0);
            }

            year+=1;

            if(test_e+1==16){
                test_e=1;
            }else{
                test_e+=1;
            }

            if(test_s+1==29){
                test_s=1;
            }else{
                test_s+=1;
            }

            if(test_m+1==20){
                test_m=1;
            }else{
                test_m+=1;
            }
        }
    }
}
