package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_8979 {

    static int n;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // 등수를 알고싶은 국가

        for (int i=0; i<n; i++){
            line = br.readLine();
            st = new StringTokenizer(line);

            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            ArrayList<Integer> list = new ArrayList<>();
            list.add(num);
            list.add(gold);
            list.add(silver);
            list.add(bronze);

            arr.add(list);
        }

        arr.sort(Comparator.comparingInt((ArrayList<Integer> lst) -> lst.get(1))
                .thenComparingInt(lst -> lst.get(2))
                .thenComparingInt(lst -> lst.get(3))
                .reversed());

//        arr.forEach(System.out::println);

        int rank=1;
        for (ArrayList<Integer> integers : arr) {
            integers.add(rank);
            rank+=1;
        }

        ArrayList<Integer> before = arr.get(0);


        // 동점자 처리
        for (int i=1; i<n; i++){
            if (arr.get(i).subList(1,4).equals(before.subList(1,4))){
                arr.get(i).remove(4);
                arr.get(i).add(before.get(4));
            }else{
                before = arr.get(i);
            }
        }

        for (ArrayList<Integer> integers : arr) {
            if (integers.get(0).equals(k)){
                System.out.println(integers.get(4));
                System.exit(0);
            }
        }
    }
}

/*

2 2
1 1 0 0
2 0 0 0

5 4
1 4 0 0
2 3 0 0
3 2 0 0
4 1 0 0
5 0 0 0

 */