package programmers.level2;

import java.util.*;
class 압축 {

    static Map<String, Integer> map = new HashMap<>();

    static {
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(String.valueOf(c), c - 'A' + 1);
        }
    }

    static int mapIndex = 27;


    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();

        String w = "";
        int idx = 0;
        while (idx<msg.length()){

            w = String.valueOf(msg.charAt(idx));

            // 마지막 글자의 경우에는 그냥 출력하고 끝낸다.
            if (idx==msg.length()-1){
                list.add(map.get(w));
                break;
            }

            int index = idx+1;
            String c = String.valueOf(msg.charAt(index));
            while (true){
                if (map.get(w+c)==null){ // w+c가 없는 문자면, map에 저장하고, w만 출력한다.
                    list.add(map.get(w));
                    map.put(w+c,mapIndex);
                    idx = index;
                    mapIndex+=1;
                    break;
                }else if(map.get(w+c)!=null && index == msg.length()-1){ // w+c를 했는데, 마지막 문자인 경우
                    list.add(map.get(w+c));
                    idx = index+1;
                    break;
                }else{// 있다면, w+c를 w로 업데이트 하고, c를 업데이트 해준다.
                    w=w+c;
                    index+=1;

                    if (index==msg.length()){
                        break;
                    }
                    c=String.valueOf(msg.charAt(index));
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
