package programmers.level2;

import java.util.*;
class 튜플 {
    public int[] solution(String s) {
        s = s.substring(1,s.length()-1);
        String[] str = s.split("\\},\\{");
        str[0]=str[0].substring(1,str[0].length());
        str[str.length-1]=str[str.length-1].substring(0,str[str.length-1].length()-1);

        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return a.length()-b.length();
            }
        });

        // for(String a: str){
        //     System.out.println(a);
        // }

        int[] answer = new int[str.length];

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<str.length; i++){
            String[] tmp = str[i].split(",");
            for (String a : tmp){
                int num = Integer.parseInt(a);
                if (!set.contains(num)){
                    answer[i] = num;
                    set.add(num);
                }
            }
        }

        return answer;
    }
}