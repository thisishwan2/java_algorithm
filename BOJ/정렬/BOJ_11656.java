package BOJ.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BOJ_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        ArrayList<String> sArr = new ArrayList<>();
        String tmp="";
        for (int i=n-1; i>-1; i--){
           tmp = s.charAt(i)+tmp;
           sArr.add(tmp);
        }

        Collections.sort(sArr);
        for (String line : sArr) {
            System.out.println(line);
        }
    }
}
