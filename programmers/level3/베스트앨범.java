package programmers.level3;

import java.util.*;
class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, List<int[]>> genre_dict =  new HashMap<>();
        Map<String, Integer> play_dict =  new HashMap<>();

        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int playCount = plays[i];

            // key가 존재하지 않으면 map에 저장
            genre_dict.putIfAbsent(genre, new ArrayList<>());
            // 고유 번호와 재생 수를 저장
            genre_dict.get(genre).add(new int[]{i, playCount});

            // 토탈 음악 재생횟수
            play_dict.put(genre, play_dict.getOrDefault(genre, 0) + playCount);
        }

        // play_dict의 value 기준으로 정렬해서 key 순서를 구한다.
        List<Object[]> order = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : play_dict.entrySet()){
            order.add(new Object[]{entry.getKey(), entry.getValue()});
        }

        Collections.sort(order, new Comparator<Object[]>(){
            @Override
            public int compare(Object[] o1, Object[] o2){
                return (int)o2[1] - (int)o1[1];
            }
        });

        List<Integer> answer = new ArrayList<>();
        // 전체 재생횟수가 큰 수에 해당하는
        for (int i=0; i<order.size(); i++){
            String g = String.valueOf(order.get(i)[0]);
            // 장르별로 genre_dict value를 얻는다.
            List<int[]> lst = genre_dict.get(g);

            // 재생 수가 크고, 고유번호가 낮은 순으로 정렬해서 상위 2개를 뽑는다.
            Collections.sort(lst, new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2){
                    if (o1[1] == o2[1]){ // 재생수가 같으면
                        return o1[0]-o2[0];
                    }else{
                        return o2[1]-o1[1];
                    }
                }
            });

            answer.add(lst.get(0)[0]);
            if (lst.size()>1){
                answer.add(lst.get(1)[0]);
            }
        }
        // list를 배열로
        int[] ans = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            ans[i]=answer.get(i);
        }

        return ans;
    }
}