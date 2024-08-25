package BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10816 {

    static int upperBound(int target, int[] card){
        int start = 0;
        int end = card.length;

        while (start<end){
            int mid = (start+end)/2;

            if (target>=card[mid]){
                start=mid+1;
            }
            else if (target<card[mid]){
                end=mid;
            }
        }
        return end;
    }

    static int lowerBound(int target, int[] card){
        int start = 0;
        int end = card.length-1;

        while (start<=end){
            int mid = (start+end)/2;

            if (target>card[mid]){
                start=mid+1;
            }
            else if (target<=card[mid]){
                end=mid-1;
            }
        }
        return start;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] card = new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            card[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        st=new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int target = Integer.parseInt(st.nextToken());

            // lowerbound: findNum 이상의 값이 처음 나오는 위치
            // upperbound: findNum 초과하는 수가 처음 나오는 위치
            // 두 값을 구해서 빼주면 몇개 가지고 있는지를 알 수 있다.

            int upper = upperBound(target, card);
            int lower = lowerBound(target, card);

            sb.append(upper-lower).append(" ");

        }
        System.out.println(sb);
    }
}
