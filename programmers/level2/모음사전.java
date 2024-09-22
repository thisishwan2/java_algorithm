package programmers.level2;

import java.util.*;
class 모음사전 {

    static List<String> list = new ArrayList<>();
    static String target;
    static Map<Integer, String> m = Map.of(
            0, "A",
            1, "E",
            2, "I",
            3, "O",
            4, "U"
    );

    static void dfs(StringBuilder tmp){ // 성능을 위해 StringBuilder 사용

        String st = new String(tmp);
        list.add(st);

        if (tmp.length() == 5){
            return;
        }
        for(int i=0; i<5; i++){
            tmp.append(m.get(i));
            dfs(tmp);
            tmp.deleteCharAt(tmp.length()-1);
        }
    }

    public int solution(String word) {
        int answer = 0;
        target = word;
        dfs(new StringBuilder());
        answer = list.indexOf(target);
        return answer;
    }
}