import java.util.HashMap;
import java.util.Map;

class Solution {
    int continuousTime = -1;

    public int solution(int[] bandage, int health, int[][] attacks) {
        int oneSecondRecoverPoint = bandage[1];
        int extraRecoverPoint = bandage[2];
        int fullRecoverTime = bandage[0];
        int fullTime = 0;
        int maxHealth = health;

        Map<Integer, Integer> damageMap = new HashMap<>();
        for (int[] attack : attacks) {
            damageMap.put(attack[0], attack[1]);
            fullTime = attack[0];
        }

        for(int i =0; i<fullTime+1; i++){
            if(damageMap.get(i) != null){
                continuousTime = 0;
                health = health - damageMap.get(i);
            }else {
                health = health + oneSecondRecoverPoint;
                continuousTime++;
                if(continuousTime == fullRecoverTime){
                    health += extraRecoverPoint;
                    continuousTime = 0;
                }
            }
            if(health >maxHealth){
                health = maxHealth;
            }
            if(health <=0){
                health = -1;
                break;
            }
        }
        return health;
    }
}