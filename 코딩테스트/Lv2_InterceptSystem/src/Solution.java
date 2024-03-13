class Solution {

    public static void main(String[] args) {
        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};  //{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}
        Solution solution = new Solution();
        solution.solution(targets);
    }
    public int solution(int[][] targets) {
        int answer = 0;
        int [] missileSize = new int[targets.length];

        for(int i =0; i<targets.length; i++){

            for(int j =0; j< targets.length; j++){
                int size = findMissileSize(targets[j]);
                missileSize[j] = size;
                System.out.println("missileSize : " +missileSize[j]);
            }

            int shortestMissileIndex = findShortestMissileIndex(missileSize);
            if(shortestMissileIndex == -1){
                break;
            }
            answer++;

            int[] shortestMissile= targets[shortestMissileIndex];
            int start = shortestMissile[0];
            int end = shortestMissile[1];

            for(int j =0; j< targets.length; j++){
                int target[] = targets[j];
                if(start < target[1] && end > target[0] ){
                    targets[j][0] = 0;
                    targets[j][1] = 0;
                    targets[shortestMissileIndex] = new int[]{0, 0};
                }
//                System.out.println("answer : " + answer);
            }
            System.out.println("answer : " + answer);
        }
        return answer;
    }

    private int findShortestMissileIndex(int[] missileSize) {
        int index =-1;
        int min =Integer.MAX_VALUE;
        for( int i=0; i<missileSize.length; i++){
            if(missileSize[i] ==0){
                continue;
            }
            if(missileSize[i] < min){
                min = missileSize[i];
                index = i;
            }
        }
//        System.out.println("shortest Index : " +index);
        return index;
    }

    private int findMissileSize(int[] target) {
        return target[1] - target[0];
    }


}