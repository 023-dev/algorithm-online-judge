import java.util.*;

class Solution {
    
    static class Song {
        int id;
        int play;
        
        Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 총 재생 수
        Map<String, Integer> genrePlayCount = new HashMap<>();
        
        // 2. 장르별 노래 목록
        Map<String, List<Song>> genreSongs = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);
            
            genreSongs.putIfAbsent(genre, new ArrayList<>());
            genreSongs.get(genre).add(new Song(i, play));
        }
        
        // 3. 장르를 총 재생 수 기준으로 정렬
        List<String> genreOrder = new ArrayList<>(genrePlayCount.keySet());
        genreOrder.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));
        
        List<Integer> result = new ArrayList<>();
        
        // 4. 각 장르에서 노래를 정렬 후 최대 2개 선택
        for (String genre : genreOrder) {
            List<Song> songs = genreSongs.get(genre);
            
            songs.sort((a, b) -> {
                if (b.play == a.play) {
                    return a.id - b.id; // 고유번호 오름차순
                }
                return b.play - a.play; // 재생 수 내림차순
            });
            
            result.add(songs.get(0).id);
            if (songs.size() > 1) {
                result.add(songs.get(1).id);
            }
        }
        
        // 5. List<Integer> -> int[]
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}