import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};  //{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}
        Solution solution = new Solution();
        solution.solution(targets);
    }

    // 풀이 정답 참조
    // 미사일 끝 위치를 기준으로 정렬
    // 미사일 뒤 꽁무니만 부수면 됨
    // 처음 요격기는 0에 위치
    // 만약 미사일 머리 위치가 요격기보다 뒤에 있다면, 즉, 파괴되지 않았다면 요격기가 요격
    // 요격은 미사일 꽁무니를 쏘는 방식으로 진행
    // 따라서 미사일 뒷 꽁무니로 요격기 배치. 요격 횟수 1회 증가.
    // 미사일 머리 위치 검사부터 미사일 횟수 반복
    // 겹치는 미사일을 중복으로 검사하지 않는 이유는 미사일 머리 위치를 검사하여 요격되지 않은 미사일만 요격하기 때문
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, ((o1, o2) -> o1[1] - o2[1]));

        int destroyer = 0;

        for (int i = 0; i < targets.length; i++) {
            if(targets[i][0] >= destroyer){
                destroyer = targets[i][1];
                answer++;
            }
        }

        return answer;
    }
}