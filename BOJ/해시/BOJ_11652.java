package BOJ.해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

public class BOJ_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            long num = Long.parseLong(br.readLine());
            if (map.containsKey(num)){
                Integer v = map.get(num);
                map.put(num, v+1);
            }else {
                map.putIfAbsent(num, 1);
            }
        }

        int ans = 0;
        long resNum = Long.MAX_VALUE;

        Set<Long> keys = map.keySet();
        for (Long key : keys) {
            Integer val = map.get(key);
            if (val>ans){
                ans=val;
                resNum=key;
            }else if (val == ans && key<resNum){
                resNum=key;
            }

        }
        System.out.println(resNum);
    }
}
