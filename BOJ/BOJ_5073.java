package BOJ;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true){
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a==0 && b==0 && c==0) {
                break;
            }

            if(a>=b+c || b>=a+c || c>=a+b){
                sb.append("Invalid").append('\n');
            }
            else if (a==b && b==c){
                sb.append("Equilateral").append('\n');
            }
            else if(a!=b && b!=c && a!=c){
                sb.append("Scalene").append('\n');
            }
            else{
                sb.append("Isosceles").append('\n');
            }
        }

        System.out.println(sb);
        br.close();
    }
}

