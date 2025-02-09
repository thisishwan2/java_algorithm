package programmers.고득점kit.깊이_너비_우선탐색;


import java.util.*;

class Node{
    String word;
    int count;
    int[] visited;

    public Node(String word, int count, int[] visited) {
        this.word = word;
        this.count = count;
        this.visited = Arrays.copyOf(visited, visited.length); // 깊은 복사
    }

}

class 단어_변환 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        int wordsLength = words[0].length();

        Queue<Node> q = new LinkedList<>();
        int[] visited = new int[words.length];
        q.add(new Node(begin, 0, visited));

        while(!q.isEmpty()){
            Node node = q.poll();
            String str = node.word;
            int cnt = node.count;
            int[] visit = node.visited;

            if(str.equals(target)){
                return cnt;
            }

            for(int i=0; i<words.length; i++){
                if(visit[i]==0){
                    int alphaCnt = 0;
                    for(int j=0; j<wordsLength; j++){
                        if(words[i].charAt(j) == str.charAt(j)){
                            alphaCnt+=1;
                        }
                    }

                    if(alphaCnt+1==wordsLength){
                        visit[i]=1;
                        q.add(new Node(words[i], cnt+1, visit));
                    }
                }
            }
        }
        return answer;
    }
}