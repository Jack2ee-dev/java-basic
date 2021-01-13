package algorithm.problems.programmers.catetories.hash.bestAlbum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAlbum {

    public static void main(String[] args) {
        String[] genres = {
            "classic", "pop", "classic", "classic", "pop"
        };
        int[] plays = {
            500, 600, 150, 800, 2500
        };
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(genres, plays)));
    }
}

class Solution {

    static class Song implements Comparable<Song> {

        int index;
        int playtime;
        String genre;

        public Song(int index, int playtime, String genre) {
            this.index = index;
            this.playtime = playtime;
            this.genre = genre;
        }

        @Override
        public int compareTo(Song o) {
            if (this.playtime == o.playtime) {
                return this.index - o.index;
            } else {
                return -(this.playtime - o.playtime);
            }
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        List<Song> songs = new ArrayList<>();
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, Integer> albumMap = new HashMap<>();
        List<Integer> bestAlbum = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            Song song = new Song(i, plays[i], genres[i]);
            songs.add(song);
            if (genreMap.containsKey(genres[i])) {
                genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);
            } else {
                genreMap.put(genres[i], plays[i]);
            }
        }

        songs.sort((o1, o2) -> {
            if (o1.genre.equals(o2.genre)) {
                return o1.compareTo(o2);
            } else {
                return -(genreMap.get(o1.genre) - genreMap.get(o2.genre));
            }
        });

        for (Song song : songs) {
            if (!albumMap.containsKey(song.genre)) {
                albumMap.put(song.genre, 1);
                bestAlbum.add(song.index);
            } else {
                int genreCnt = albumMap.get(song.genre);

                if (genreCnt >= 2) {
                    continue;
                }
                albumMap.put(song.genre, genreCnt + 1);
                bestAlbum.add(song.index);
            }
        }

        answer = new int[bestAlbum.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = bestAlbum.get(i);
        }
        return answer;
    }
}