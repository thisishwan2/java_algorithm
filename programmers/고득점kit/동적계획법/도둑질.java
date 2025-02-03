package programmers.고득점kit.동적계획법;

public class 도둑질 {
    public int solution(int[] money) {
        int answer = 0;

        // 그림과 같이 홀수개일때는 1,2,3,1,5 앞에서 부터 처리하면 1,3,5가 정답으로 나옴
        // 첫번째 집을 고려하고 마지막 집을 빼는 경우
        // 첫번째 집을 빼고, 마지막 집을 고려하는 경우 를 나눠서 구하고 더 큰값을 찾는다.

        int[] dp1 = new int[money.length];
        dp1[0]=money[0]; // 첫번째 집을 턴다.
        dp1[1]=Math.max(money[0],money[1]); // 두번째와 첫번째 집중 더 큰 값을 찾는다.
        for(int i=2; i<money.length-1; i++){ // 마지막 집을 털지 않기 때문에 -1 만큼 for문을 돈다.
            dp1[i] = Math.max(dp1[i-2]+money[i], dp1[i-1]);
        }

        int[] dp2 = new int[money.length];
        dp2[0]=0; // 첫번째 집을 털지 않는다.
        dp2[1]=money[1]; // 두번째 집을 턴다.
        for(int i=2; i<money.length; i++){ // 마지막 집까지 for문을 돈다.
            dp2[i] = Math.max(dp2[i-2]+money[i], dp2[i-1]);
        }

        // System.out.println(dp1[money.length-2]);
        // System.out.println(dp2[money.length-2]);
        answer = Math.max(dp1[money.length-2], dp2[money.length-1]);
        return answer;
    }
}
