package BOJ.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String [] guitar = new String[n];
        for(int i=0; i<n; i++){
            guitar[i]= br.readLine();
        }

        // 정렬 기준
        // 길이가 짧은 것이 우선
        // 길이가 같으면 A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은것이 먼저(숫자만 합)
        // 위의 조건으로 비교 불가한 경우 사전순. 숫자가 알파벳보다 사전순으로 작음
        Arrays.sort(guitar, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() < s2.length()) {
                    return -1; // s1이 길이가 더 짧으니 우선순위가 높다
                } else if (s1.length() == s2.length()) { // 길이가 같으면 숫자를 합한다.
                    int s1_num = 0;
                    int s2_num = 0;
                    for (int i = 0; i < s1.length(); i++) {
                        if (s1.charAt(i) >= '0' && s1.charAt(i) <= '9') { // 아스키 코드 상으로 0~9사이값인지를 비교
                            s1_num += Integer.parseInt(String.valueOf(s1.charAt(i)));
                        }
                    }

                    for (int i = 0; i < s2.length(); i++) {
                        if (s2.charAt(i) >= '0' && s2.charAt(i) <= '9') {
                            s2_num += Integer.parseInt(String.valueOf(s2.charAt(i)));
                        }
                    }

                    if (s1_num < s2_num) {
                        return -1;
                    } else if (s1_num == s2_num) {
                        return s1.compareTo(s2); // 사전순 비교
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i< guitar.length; i++){
            String res = guitar[i];
            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }
}
