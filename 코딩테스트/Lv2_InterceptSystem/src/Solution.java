import java.util.Arrays;
import java.util.Collections;

class Solution {

    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};  //{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}
        Solution solution = new Solution();
        solution.solution(targets);
    }


    // 무조건 모든 미사일을 통과해야 함
    // 먼저 가장 짧은 미사일의 범위를 통과 범위로 포함시킴
    // 그리고 그 중 가장 많은 교점이 생기는 부분을 통과?
    // 통과된 미사일들은 모두 제외
    // 그리고 그 다음으로 짧은 미사일로 넘어가는 식으로 구현

    /*
    1. for문을 돌면서 모든 미사일 순회
    2. 가장 짧은 미사일 구함
    3. 가장 짧은 미사일과 같은 x축 선상에 존재하는 미사일들 구함. 이상의 미사일들은 격추된 것으로 간주
    4. 격추된 미사일들의 인덱스 번호는 destroyed 에 저장.
    5. 다시 1로 돌아감. destroyed 가 다 찰때까지 반복
     */

    public int solution(int[][] targets) {
        int answer = 0;
        // 1. 짧은 순으로 미사일을 구함
        // 2. 해당 미사일이 파괴되었으면 건너뜀
        // 3. 아니면 해당 미사일과 겹치는 선상에 존재하는 미사일 모두 파괴
        // 4. 반복

        targets = sortAccordingToDistance(targets);

        boolean[] destroyed = new boolean[targets.length];
        for(int i =0; i<targets.length; i++){
            if(destroyed[i] == true){
                continue;
            }
            int [] shortest = targets[i];
            for(int j =0; j< targets.length; j++){

                if(destroyed[j]){
                    continue;
                }

                int start = shortest[0];
                int end = shortest[1];
                if(targets[j][0] <=start){
                    if(targets[j][1] >=end){
                        destroyed[j] = true;
                    } else if (targets[j][1] <end && targets[j][1] >start) {
                        destroyed[j] = true;
                    }
                }
            }
            answer++;
        }
        return answer;
    }



    public int[][] sortAccordingToDistance(int[][] targets){
        int distance[] = new int[targets.length];
        for(int i=0; i<targets.length; i++){
            distance[i] = targets[i][1] - targets[i][0];
        }

        for(int i =0; i<targets.length; i++){
            for(int j =i+1; j<targets.length; j++){
                if(distance[i] > distance[j]){
                    int temp = distance[i];
                    int[] tempTarget = targets[i];
                    distance[i] = distance[j];
                    distance[j] = temp;
                    targets[i] = targets[j];
                    targets[j] = tempTarget;
                }
            }
        }
        for(int[] j : targets){
            System.out.println(Arrays.toString(j));
        }
        return targets;
    }

}