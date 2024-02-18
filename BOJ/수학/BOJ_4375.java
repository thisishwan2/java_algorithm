package BOJ.수학;

import java.io.*;
import java.math.BigInteger;

// 본 문제의 핵심은 BigInteger 타입을 알고 활용할 수 있냐를 확인하는 문제이다.
// String, Integer, Long 형의 경우 111111111111111111 과 같이 큰 수에 대해 표현이 어렵기 때문에 BigInteger를 이용한다
public class BOJ_4375 {
    private void solution_1() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); bw는 int를 바로 출력할 수 없고 "String+ + data 이런식으로 하기에는 연산이 느리다. 또 String.valueOf를 쓰면 지저분하다.
//        따라서 더 쉬운방식으로 출력값을 모은다음 출력하는 방식을 쓸수 있다.(StringBuilder)
        StringBuilder sb = new StringBuilder();

        String a;

        // 참고로 br.readLine에 null을 넣고 싶으면 cmd+d 를 하면 된다.
        while ((a = bf.readLine()) != null){
            BigInteger num =  new BigInteger(a);
            BigInteger valAns = BigInteger.ZERO;
            while (true){
                valAns = valAns.multiply(BigInteger.TEN).add(BigInteger.ONE); // 10 곱하고 1을 더하면 11,111,1111 과 같이 된다.

                if (valAns.mod(num).equals(BigInteger.ZERO)){
                    sb.append(valAns.toString().length()).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    // BigInteger를 안쓰고, 수학적으로 풀었다.
    // 매 loop마다 n으로 나눠주면서 값의 크기를 작게 유지했다.(n으로 나눠줘도 되는 이유는 어차피 나머지는 계속 유지가 되기 때문이다.)
    private void solution_2() throws Exception{
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a;
        while ((a = bf.readLine()) != null){
            int n = Integer.parseInt(a);
            int base = 1;
            int cnt = 1;
            while ((base=base%n) != 0) {
                cnt++;
                base = base * 10 + 1;
            }
//            System.out.println(cnt); System.out.println은 느리기 때문에 BufferWriter를 쓰자.
            bw.write(String.valueOf(cnt)); // bw는 int를 바로 출력할 수 없다.
            bw.newLine(); //이게 한줄 뛰기

        }
        bw.flush(); // flush를 해서 출력을 해준다.
    }
    public static void main(String[] args) throws Exception {
//        new BOJ.수학.BOJ_4375().solution_1();
        new BOJ_4375().solution_2();
    }
}
