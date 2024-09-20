package BOJ.정렬;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class BOJ_8979 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] info = new int[n][4];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int[] tmp = new int[4];
            for (int j=0; j<4; j++){
                tmp[j] = Integer.parseInt(st.nextToken());
            }
            info[i] = tmp;
        }

        Arrays.sort(info, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if (o1[1] == o2[1]){
                    if(o1[2] == o2[2]){
                        if(o1[3] == o2[3]){
                            return 1;
                        }else{
                            return o2[3]-o1[3];
                        }
                    }else {
                        return o2[2]-o1[2];
                    }
                }
                else{
                    return o2[1]-o1[1];
                }
            }
        });

        int rank = 1;
        int cnt = 1;

        int[] prev = new int[3];
        for(int i = 0; i<n; i++){
            if (i==0){
                prev[0]=info[i][1];
                prev[1]=info[i][2];
                prev[2]=info[i][3];
            }else{
                int[] tmp = new int[]{info[i][1],info[i][2],info[i][3]};
                if (!Arrays.equals(prev, tmp)){
                    prev=tmp;
                    rank+=cnt;
                    cnt=1;
                }else{
                    cnt+=1;
                }
            }

            if (info[i][0] == k){
                System.out.println(rank);
                System.exit(0);
            }
        }

    }
}
