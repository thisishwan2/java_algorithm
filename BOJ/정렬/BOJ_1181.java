package BOJ.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> wordSet = new HashSet<>();

        for (int i=0; i<n; i++){
            String word = br.readLine();
            wordSet.add(word);
        }

        List<String> tmp = new ArrayList<>(wordSet);

        Collections.sort(tmp, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if (a.length() == b.length()) {
                    return a.compareTo(b);
                }
                else{
                    return a.length()-b.length();
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String line : tmp) {
            sb.append(line).append('\n');
        }

        System.out.println(sb);

    }
}
