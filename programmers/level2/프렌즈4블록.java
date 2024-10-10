package programmers.level2;

import java.util.*;
class 프렌즈4블록 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        // List로 변환
        List<List<String>> arr = new ArrayList<>();

        for(int i=0; i<m; i++){
            List<String> row = new ArrayList<>();
            for(int j=0; j<n; j++){
                row.add(String.valueOf(board[i].charAt(j)));
            }
            arr.add(row);
        }

        while(true){
            int[][] visited = new int[m][n];
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    if (arr.get(i).get(j).equals("")){
                        continue;
                    }
                    String a = arr.get(i).get(j);
                    String b = arr.get(i).get(j+1);
                    String c = arr.get(i+1).get(j);
                    String d = arr.get(i+1).get(j+1);

                    if (a.equals(b) && b.equals(c) && c.equals(d)){
                        visited[i][j]=1;
                        visited[i][j+1]=1;
                        visited[i+1][j]=1;
                        visited[i+1][j+1]=1;
                    }
                }
            }

            int cnt=0;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if (visited[i][j]==1){
                        cnt+=1;
                        arr.get(i).set(j, "");
                    }
                }
            }

            if (cnt==0){
                break;
            }else{
                answer+=cnt;

                for (int j=0; j<n; j++){
                    for (int i=m-1; i>=0; i--){
                        if (arr.get(i).get(j).equals("")){
                            continue;
                        }else{// 현재칸이 비워져있지 않다면
                            int row = i;
                            int nrow = i+1;
                            // 밑에칸이 비어있으면,
                            if(nrow<m && arr.get(nrow).get(j).equals("")){
                                while (nrow<m && arr.get(nrow).get(j).equals("")){ // 비어있을때 까지 진행
                                    arr.get(nrow).set(j,arr.get(row).get(j));
                                    arr.get(row).set(j,"");
                                    row+=1;
                                    nrow+=1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}