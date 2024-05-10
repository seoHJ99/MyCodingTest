class Solution {

    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};  //{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}
        Solution solution = new Solution();
        solution.solution(targets);
    }

    public int solution(int[][] targets) {
        int answer = 0;

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

        int[] destroyed = new int[targets.length];
        for(int i =0; i<targets.length; i++){
            if(destroyed[i] == -1){
                continue;
            }
            int[] destroyedIndex = destroy(targets);
        }


        return answer;
    }

    public int[] destroy(int[][] targets){
        int[] destroyedIndex = new int[targets.length];
        int shortestIndex = findShortestMissile(targets);
        destroyedIndex[shortestIndex] = -1;
        for(int i =0; i<targets.length; i++){
            boolean destroyed = destroyMissile(targets[i], targets[shortestIndex]);
            if(destroyed){
                destroyedIndex[i] = -1;
            }
        }
        return destroyedIndex;
    }

    public int findShortestMissile(int[][] targets) {
        int min = Integer.MAX_VALUE;
        int shortestIndex = 0;
        for (int i = 0; i < targets.length; i++) {
            if (targets[i][1] - targets[i][0] < min) {
                min = targets[i][1] - targets[i][0];
                shortestIndex = i;
            }
        }
        return shortestIndex;
    }

    public boolean destroyMissile(int[] missile, int[] shortest) {
        int start = shortest[0];
        int end = shortest[1];
        if (missile[0] >= start && missile[1] <= end) {
            return true;
        }
        return false;
    }
}