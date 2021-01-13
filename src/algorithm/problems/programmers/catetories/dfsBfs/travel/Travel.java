package algorithm.problems.programmers.catetories.dfsBfs.travel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Travel {

    public static void main(String[] args) {
        String[][] tickets = {
            {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"},
            {"ATL", "ICN"}, {"ATL", "SFO"}
        };
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(tickets)));
    }
}

class Solution {

    static class Ticket {

        String departure;
        String destination;
        boolean used = false;

        public Ticket(String departure, String destination) {
            this.departure = departure;
            this.destination = destination;
        }
    }

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        List<Ticket> routes = new ArrayList<>();
        for (String[] ticket : tickets) {
            routes.add(new Ticket(ticket[0], ticket[1]));
        }
        routes.sort((o1, o2) -> {
            if (o1.departure.equals("ICN") && o2.departure.equals("ICN")) {
                return o1.destination.compareTo(o2.destination);
            }
            return 1;
        });

        Queue<Ticket> q = new LinkedList<>();
        List<Ticket> route = new ArrayList<>();
        q.add(routes.get(0));
        route.add(routes.get(0));
        routes.get(0).used = true;

        while (!q.isEmpty()) {
            Ticket node = q.poll();
            for (int i = 0; i < tickets.length; i++) {
                if (!routes.get(i).used && routes.get(i).departure.equals(node.destination)) {
                    q.add(routes.get(i));
                    route.add(routes.get(i));
                    routes.get(i).used = true;
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = route.get(i).departure;
        }

        System.out.println(route.size());

        return answer;
    }
}