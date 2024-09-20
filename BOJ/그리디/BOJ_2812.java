package BOJ.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class BOJ_2812 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String num = br.readLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(String.valueOf(num.charAt(i)));
            arr[i] = tmp;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            while (list.size() != 0 && list.get(list.size() - 1) < arr[i] && k > 0) {
                list.remove(list.size() - 1);
                k -= 1;
            }
            list.add(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        if (k > 0) {
            list = list.subList(0, list.size() - k);
            for (Integer i : list) {
                sb.append(i);
            }

        } else {
            for (Integer i : list) {
                sb.append(i);
            }
        }

        System.out.println(sb);

    }
}
