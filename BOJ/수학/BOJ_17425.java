package BOJ.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 아이디어는 주어진 숫자 하나씩 돌아가면서 해당 숫자보다 작은 모든 자연수의 모든 약수를 구하고 그 약수들의 합을 더하는것은 비효율적이다.
// 또한 그렇게 for문을 돌릴시 시간 복잡도 또한 터질것이다,
// 따라서 DP처럼 배열 두개를 만들고(fx, gx) 문제를 푼다.
public class BOJ_17425 {

    private void solution() throws Exception{

        // 누적 합이 int 범위를 넘을 수 있음 따라서 long으로
        long[] gx = new long[1000001];
        long[] fx = new long[1000001];
        Arrays.fill(fx, 1);

        // 시간복잡도가 nlogn이다 왜냐면 두번째 for문에서는 i*j 이므로 logn으로 줄어들기 때문이다.
        // 따라서 이문제의 복잡도는 nlogn으로 1억초를 넘지 않는다.
        for(int i=2; i<fx.length; i++){
            for (int j=1; i*j<fx.length; j++){
                fx[i*j]+=i;
            }
        }

        for (int i=1; i< gx.length; i++){
            gx[i]=gx[i-1]+fx[i];
        }

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(bf.readLine());
            sb.append(gx[num]);
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception {
        new BOJ_17425().solution();
    }
}


