package main.lv1;

import java.util.HashMap;
import java.util.Map;

public class RunCompetition {
    public static void main(String[] args) {
        String[] players  = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        RunCompetition runCompetition = new RunCompetition();
        runCompetition.solution(players, callings);
    }

    public String[] solution(String[] players, String[] callings) {
        String[] answer;
//        Map<Integer, String> orderMap = new HashMap<>();
//        for(int i =0; i<players.length; i++){
//            orderMap.put(i, players[i]);
//        }
        for(int i =0; i<callings.length; i++){
            String outrun = callings[i];
            for(int j =0; j<players.length; j++){
                String name = players[j];
                if(name.equals(outrun)){
                    String outranMan = players[j-1];
                    players[j-1] = outrun;
                    players[j]=outranMan;
                }
            }
        }
        answer = players;
        return answer;
    }

}
