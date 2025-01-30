package programmers.고득점kit.탐욕법;

public class 큰_수_만들기 {
    public static void main(String[] args) {
        큰_수_만들기 큰_수_만들기 = new 큰_수_만들기();
        System.out.println(큰_수_만들기.solution("1924", 2)); // answer: 56
    }

    // 문제 풀이법
    // n 길이를 갖는 number에서 k개의 숫자를 빼서 가장 큰 수를 만들기 위해서는 총 n-k 길이를 가지는 결과가 나와야함
    // 이는 k+1의 길이를 가지는 문자열을 0번 인덱스부터 i+k인덱스가 마지막 문자가 될때까지 탐색하면서 가장 큰 수를 하나씩 뽑으면 된다.
    // 1231234 n=7 k=3 이라고 했을때,
    // 1231, 2312, 3123, 1234 이렇게 4개의 문자열에서 각각 max 값을 뽑으면 3,2,3,4가 된다.(1231에서 3을 뽑으면 2312는 3다음인 12 중에서 max를 뽑음)
    // 따라서 n-k번 0번 인덱스부터 i+k까지의 범위의 문자열에서 가장 큰 수를 찾는다.

    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        int index = 0; // 매 탐색에서 찾은 max+1의 값

        // 전체길이 - k 번 반복
        for(int i=0; i<number.length() - k; i++){
            char max = 0; // 아스키 코드 순서로 비교하는게 효율적이기 때문에 char로 둔다.

            // i부터 i+k 범위까지 중 가장 큰 수를 찾는다.
            // 단, index부터 시작한다.
            for(int j=index; j<=i+k; j++){
                if(max<number.charAt(j)){
                    max = number.charAt(j);
                    index = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
