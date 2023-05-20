package main;

public class Programmers_Lv1_PasswordBetweenOnlyTwo {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(8,4, new int[]{1,2,3,5});
    }
}

// section의 배열에서, 현재 요소와 바로 뒤의 요소가 m보다 크면 나누기가 의미가 없어짐.
class Solution {
    public int solution(String s , String skip, int index) {
        // s를 전부 1개씩 잘라서 숫자로 변환
        // skip도 마찬가지
        // s 개별적으로 index만큼 숫자를 더하고, 그 값이 skip에 존재하면 건너뛰고 다음 숫자
        // 만약 26을 넘어가게 되면 다시 1로
        int sLength = s.length();
        int sNumber[] = new int[sLength];
        for(int i=0; i<sLength; i++){
            sNumber[i] = s.charAt(i) - 96;
        }
        int skipLength = skip.length();
        int skipNumber[] = new int[skipLength];
        for(int i=0; i<skipLength; i++){
            skipNumber[i] = skip.charAt(i) - 96;
        }
        int newSnumber[] = new int[sLength];
        for(int i=0; i<sLength; i++){
            int plusNum = 0;
            for(int j=0; j<skipLength; j++){
                if( sNumber[i] < skipNumber[j] && skipNumber[j] <= sNumber[i]){
                    plusNum++;
                }
            }
            index =+ plusNum;
            newSnumber[i] =
        }


        return answer;
    }
}