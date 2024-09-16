package programmers.level2;

import java.util.*;
class 귤_고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<tangerine.length; i++){
            if(map.get(tangerine[i])==null){
                map.put(tangerine[i], 1);
            }else{
                map.put(tangerine[i], map.get(tangerine[i])+1);
            }
        }

        // System.out.println(map.size());

        int n = map.size();
        List<int[]> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            int[] tmp = new int[]{key, val};
            res.add(tmp);
        }

        Collections.sort(res, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return b[1]-a[1];
            }
        });

        for(int i=0; i<n; i++){
            if (res.get(i)[1]<=k){
                answer+=1;
                k-=res.get(i)[1];
            }else{
                break;
            }
        }

        if (k!=0){
            answer+=1;
        }
        return answer;
    }
}