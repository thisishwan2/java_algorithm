package programmers.level2;

import java.util.*;
class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        Map<Character,Integer> m = new HashMap<>();
        for(int i=0; i<skill.length(); i++){
            m.put(skill.charAt(i),1);
        }


        for(int i=0; i<skill_trees.length; i++){
            String tmp = "";
            for(int j=0; j<skill_trees[i].length(); j++){
                if (m.get(skill_trees[i].charAt(j))==null){
                    continue;
                }else{
                    tmp+=String.valueOf(skill_trees[i].charAt(j));
                }
            }

            // System.out.println(tmp);

            boolean flag=true;
            for(int j=0; j<tmp.length(); j++){

                String tmp1 = String.valueOf(skill.charAt(j));
                String tmp2 = String.valueOf(tmp.charAt(j));

                if(!tmp1.equals(tmp2)){
                    flag=false;
                    break;
                }
            }
            if (flag){
                // System.out.println("===");
                // System.out.println(tmp);
                answer+=1;
            }
        }

        return answer;
    }
}