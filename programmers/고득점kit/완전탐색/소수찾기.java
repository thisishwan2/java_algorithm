package programmers.고득점kit.완전탐색;
import java.util.*;
public class 소수찾기 {
    static HashSet<Integer> set = new HashSet<>();

    public boolean isPrime(int n){
        int half = (int) Math.sqrt(n)+1;
        for(int i=2; i<=half; i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }

    public void dfs(String tmp, int[] visited, int n, String[] nums, int now){

        if(tmp.length()==n){
            return;
        }

        for(int i=0; i<n; i++){
            if(visited[i]==0 && i!=now){
                visited[i]=1;
                String newTmp=tmp+nums[i];
                int num = Integer.valueOf(newTmp);
                if(num==2){
                    set.add(num);
                }
                else if (num>2 && isPrime(num)){
                    // System.out.println(num);
                    set.add(num);
                }
                dfs(newTmp, visited, n, nums, i);
                visited[i]=0;
            }
        }
    }


    public int solution(String numbers) {
        int answer = 0;

        String[] nums = new String[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            nums[i] = String.valueOf(numbers.charAt(i));
        }

        int[] visited = new int[numbers.length()];

        dfs("",visited, numbers.length(), nums, -1);
        // System.out.println(set.size());
        return set.size();
    }
}
