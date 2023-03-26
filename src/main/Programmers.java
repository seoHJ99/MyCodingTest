package main;

public class Programmers {
    // 총 벽 길이 : n미터
    // 1미터 단위로 구역을 나눔.
    // 구역의 왼쪽부터 번호를 붙임
    // m미터 룰러로 칠함.
    // section: 다시 칠할 구역 번호
    // 룰러로 몇번을 칠해야 하는가?
    // 칠하지 않기로 한 곳을 다시 칠해도 됨
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(8,4, new int[]{2,3,6});
    }
}

// section의 배열에서, 현재 요소와 바로 뒤의 요소가 m보다 크면 나누기가 의미가 없어짐.
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int now = 0;
        int next = 0;
        for(int i =0; i<section.length-1; i++){
            if(m >1) {
                now = section[i];
                    next = section[i + 1];
                int distance = next - now + 1;
                if (distance <= m) {
                    answer += distance / m;
                    if (distance % m > 0) {
                        answer++;
                    }
                }
            }else {
                answer = section.length;
            }
        }
        System.out.println(answer);
        return answer;
    }
}