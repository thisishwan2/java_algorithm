package programmers.고득점kit.탐욕법;

public class 조이스틱 {
    public static void main(String[] args) {
        조이스틱 조이스틱 = new 조이스틱();
        System.out.println(조이스틱.solution("JEROEN")); // answer: 56
    }

    // ABCDEFGHIJKLMNOPQRSTUVWXYZ 26개
    // A 0/ B,Z 1/ C,Y 2/ D,X 3/ E,W 4/ F,V 5/ G,U 6/ H,T 7/ I,S 8/ J,R 9/ K,Q 10/ L,P 11/ M,O 12/ N 13

    // 조이스틱을 상하로 최소한 몇번 움직이는지
    public int cal(char c){
        int n = 13-Math.abs(13+65-c);
        return n;
    }

    public int solution(String name) {
        int answer = 0;
        int move = Integer.MAX_VALUE;

        // BBBBAABB 그냥 오른쪽으로 쭉 이동 = 7, 오른쪽으로 갔다가 왼쪽으로 빽 = 9, 왼쪽으로 갔다가 오른쪽으로 빽 = 7
        // BBBBAAAB 그냥 오른쪽으로 쭉 이동 = 7, 오른쪽으로 갔다가 왼쪽으로 빽 = 7, 왼쪽으로 갔다가 오른쪽으로 빽 = 5

        // 즉, 다음 글자가 A일때, 연속된 A응 만난다면 돌아가는게 더 빠른지를 확인한다.

        int n = name.length();
        for(int i=0; i<name.length(); i++){
            answer += cal(name.charAt(i));

            int index = i+1;
            // 다음 문자가 A이고, 연속된 A라면 연속된 A가 끝나는 인덱스를 찾는다.
            while(index<name.length() && name.charAt(index) == 'A'){
                index+=1;
            }

            // 이제 돌아가는게 더 빠른지 그대로 직진하는게 더 빠른지를 체크한다.
            move = Math.min(move, i*2+n-index);
            move = Math.min(move, i+(n-index)*2); // 처음부터 뒤로갔다오는 경우
        }

        return answer+move;
    }


}
