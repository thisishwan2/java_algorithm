package programmers.고득점kit.완전탐색;

import java.util.*;

public class 모음사전 {
    static HashSet<String> set = new HashSet<>();

    public void dfs(String str, String[] alpha, int n){
        if(str.length() == n){
            return;
        }
        for(int i=0; i<alpha.length; i++){
            String newStr = str+ alpha[i];
            set.add(newStr);
            dfs(newStr, alpha, n);
        }
    }

    public int solution(String word) {
        int answer = 0;

        // 모든 경우 구해서 sort
        String[] alpha = new String[]{"A","E","I","O","U"};
        int n = word.length();
        dfs("",alpha,5);

        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);

        answer = ans.indexOf(word)+1;

        return answer;
    }
}
