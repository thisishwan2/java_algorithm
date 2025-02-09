package programmers.고득점kit.깊이_너비_우선탐색;

public class 타겟_넘버 {

    public static void main(String[] args) {
        타겟_넘버 타겟_넘버 = new 타겟_넘버();
        타겟_넘버.solution(new int[]{4, 1, 2, 1},4);
    }
    static int answer = 0;

    public void dfs(int[] numbers, int depth, int target, int sum){

        // 합이 타겟이고, n개까지 다 더하고 뺀 경우
        if(depth == numbers.length) {
            if (target == sum) {
                answer += 1;
            }
        }else {
            dfs(numbers, depth+1, target, sum+numbers[depth]);
            dfs(numbers, depth+1, target, sum-numbers[depth]);

        }
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);

        return answer;
    }
}
