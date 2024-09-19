package programmers.level2;

import java.util.*;
class 뉴스_클러스터링 {
    public int solution(String str1, String str2) {
        int answer = 0;

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> s = new HashSet<>();

        for(int i=0; i<str1.length()-1; i++){
            // 둘다 문자인 경우만
            if(65<=str1.charAt(i) && str1.charAt(i)<=90 && 65<=str1.charAt(i+1) && str1.charAt(i+1)<=90 ){
                map1.put(str1.substring(i,i+2), map1.getOrDefault(str1.substring(i,i+2), 0)+1);
                s.add(str1.substring(i,i+2));
            }
        }

        // for(String key : map1.keySet()){
        //     System.out.println(map1.get(key));
        // }

        for(int i=0; i<str2.length()-1; i++){
            // 둘다 문자인 경우만
            if(Character.isLetter(str2.charAt(i)) && Character.isLetter(str2.charAt(i+1))){
                map2.put(str2.substring(i,i+2), map2.getOrDefault(str2.substring(i,i+2), 0)+1);
                s.add(str2.substring(i,i+2));
            }
        }

        if (map1.size()==0 && map2.size()==0){
            return 65536;
        }

        int card = 0;
        int sum = 0;

        for(String key: s){

            // 교집합
            if(map1.get(key)!=null && map2.get(key)!=null){
                card+=Math.min(map1.get(key), map2.get(key));
                sum+=Math.max(map1.get(key), map2.get(key));
            }else{
                if (map1.get(key)!=null){
                    sum+=map1.get(key);
                }else if (map2.get(key)!=null){
                    sum+=map2.get(key);
                }
            }
        }

        answer = (int)Math.floor(((double) card/(double) sum)*65536);

        return answer;
    }
}
