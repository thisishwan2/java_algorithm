package programmers.level2;
import java.util.*;
class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize==0){
            return cities.length*5;
        }

        for(int i=0; i<cities.length; i++){
            cities[i] = cities[i].toUpperCase();
        }

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<cities.length; i++){
            if (map.size()<cacheSize){
                if (map.get(cities[i]) == null){
                    answer+=5;
                }else{
                    answer+=1;
                }
                map.put(cities[i], i);
            }else{

                if (!(map.get(cities[i]) == null)){
                    map.put(cities[i], i);
                    answer+=1;
                    continue;
                }

                int min = 1000000;
                String out = "";
                for (String key: map.keySet()){
                    if (map.get(key)<min){
                        min = map.get(key);
                        out = key;
                    }
                }

                if (out == cities[i]){
                    answer+=1;
                    map.put(cities[i], i);
                }else{
                    answer+=5;
                    map.remove(out);
                    map.put(cities[i], i);
                }
            }
        }

        return answer;
    }
}
