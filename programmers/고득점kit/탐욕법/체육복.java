package programmers.고득점kit.탐욕법;

import java.util.*;

public class 체육복 {

    public int solution1(int n, int[] lost, int[] reserve) {

        // set은 contains 의 시간복잡도가 o(1)
        HashSet<Integer> lostSet = new HashSet<>();
        HashSet<Integer> reserveSet = new HashSet<>();

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌 체육복 확인
        for(int l : reserve){
            reserveSet.add(l);
        }

        // 도난당한 체육복 확인
        for(int l : lost){
            // 자신의 체육복을 도난당했다면
            if(reserveSet.contains(l)){
                reserveSet.remove(l);
            }
            else{
                lostSet.add(l);
            }
        }

        // 체육수업을 들을 수 있는지 확인
        for(Integer l: reserveSet){
            if(lostSet.contains(l-1)){
                lostSet.remove(l-1);
            }else if(lostSet.contains(l+1)){
                lostSet.remove(l+1);
            }
        }

        return n-lostSet.size();
    }


    public int solution2(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int lostNum = lost.length;

        Arrays.sort(reserve);
        Arrays.sort(lost);

        // array -> List
        List<Integer> lst = new ArrayList<>();
        for(int i=0; i<lost.length; i++){
            lst.add(lost[i]);
        }

        List<Integer> candidate = new ArrayList<>();
        for(int i=0; i<reserve.length; i++){
            candidate.add(reserve[i]);
        }

        // 여분의 체육복이 있는 학생이 자신의 체육복을 도난당했는지 확인
        for(int i=0; i<reserve.length; i++){
            if (lst.contains(reserve[i])){ // 자기 자신의 체육복이 도난당했으면
                lst.remove(new Integer(reserve[i])); // 래퍼 클래스로 감싼 값을 인자로 전달해야함
                candidate.remove(new Integer(reserve[i]));
            }
        }

        for(Integer num: candidate){
            if (lst.contains(num-1)){
                lst.remove(new Integer(num-1)); // num-1 과정에서 int 타입으로 오토 언박싱 발생
                continue;
            }
            else if (lst.contains(num+1)) {
                lst.remove(new Integer(num+1));
                continue;
            }
        }

        return n-lst.size();
    }
}

class Main{
    public static void main(String[] args) {
        체육복 체육복 = new 체육복();
        int res = 체육복.solution2(5, new int[]{2, 4}, new int[]{1, 3, 5});
        System.out.println(res);
    }
}
