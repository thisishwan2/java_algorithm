package BOJ.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        /*
        String str = bf.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int a = Integer.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());
        int c = Integer.valueOf(st.nextToken());
        */

        String[] line = bf.readLine().split(" ");
        int first = Integer.valueOf(line[0]);
        int second = Integer.valueOf(line[1]);
        int third = Integer.valueOf(line[2]);
        System.out.println((first+second)%third);
        System.out.println(((first%third)+(second%third))%third);
        System.out.println((first*second)%third);
        System.out.println(((first%third)*(second%third))%third);
    }
}
