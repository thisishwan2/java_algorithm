package programmers.level1;

public class 문자열_내_p와_y의_개수 {
    boolean solution(String s) {
        boolean answer = false;

        int p =0;
        int y =0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == 'p' || s.charAt(i) == 'P'){
                p++;
            }
            else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y'){
                y++;
            }
        }

        if (p==y){
            answer = true;
        }

        return answer;
    }
}
