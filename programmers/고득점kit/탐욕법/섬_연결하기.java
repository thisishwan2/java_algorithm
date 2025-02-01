package programmers.고득점kit.탐욕법;

import java.util.*;

public class 섬_연결하기 {
    public static void main(String[] args) {
        섬_연결하기 섬_연결하기 = new 섬_연결하기();
        섬_연결하기.solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}});
    }
    public int[] parent;

    // 각 원소의 부모 노드를 찾아서 하나의 부모 밑으로 합친다.
    public void union(int a, int b){
        a = find(a);
        b = find(b);

        // 부모가 다른경우에는 서로 연결해준다.
        if(a!=b){
            parent[b] = a;
        }
    }

    // 재귀를 통해 각 노드의 부모를 찾는다.
    public int find(int v){
        if(parent[v]==v) {
            return v;
        }
        else {
            return find(parent[v]);
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;

        // 초기화 과정
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
        }

        // 비용으로 정렬
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2]-o2[2];
            }
        });

        // kruskal - mst를 그리디하게 구하는 알고리즘
        for(int i=0; i<costs.length; i++){

            // 각자 부모가 다르면
            if(find(costs[i][0]) != find(costs[i][1])){
                union(costs[i][0], costs[i][1]); // 부모를 합친다.
                answer+=costs[i][2];
            }
        }

        return answer;
    }
}
