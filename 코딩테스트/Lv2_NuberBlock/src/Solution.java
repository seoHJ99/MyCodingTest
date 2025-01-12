import java.util.Arrays;

class Solution {

    // 1. 소수는 무조건 1
    // 2. 첫번째는 무조건 0
    // 3. 나머지 숫자는 자기 자신을 제외한 최대 약수

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(1000000000-9, 1000000000);
        System.out.println(Arrays.toString(answer));
    }

    public int[] solution(long begin, long end) {
        long l = end - begin + 1;
        int[] answer = new int[(int) l];
        for (long i = begin - 1; i < end; i++) {
            answer[(int) (i - begin +1)] = getNum(begin + i);
        }
        return answer;
    }

    public int getNum(long index) {
        if (checkPrimeNumber(index)) {
            return 1;
        }
        for (long i = index - 1; i > 0; i--) {
            if (index % i == 0) {
                return (int) i;
            }
        }
        return 0;
    }

    public boolean checkPrimeNumber(long index) {
        int count = 0;
        for (int i = 1; i <= index; i++) {
            if (index % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            return true;
        }
        return false;
    }
}