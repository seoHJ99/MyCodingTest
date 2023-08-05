package main.lv2;

public class NumberTransfer {

    public static void main(String[] args) {
        int x = 45;
        int y = 150;
        int n = 5;
        solution(x, y, n);
    }
    public static int solution(int x, int y, int n) {
        int answer =0 ;
        // x가 n의 배수인지
        // x+(n*임의의 횟수)가 2나 3의 배수인지
        // x가 2나 3의 배수인지
        int gap = y-x;
        if(y%x == 0 && y%3 == 0){
           answer = y/x/3;
        }else if(y%x == 0 && x%2 == 0 ){
            int temp = y / x / 2;
                answer = temp;
        }
        if (gap >= n && gap%n == 0) {
            int temp =  gap/n;
            if(answer != 0 && temp<answer) {
                answer = temp;
            }else if(answer == 0){
                answer = temp;
            }
        }
        if (y%2 ==0 || y%3==0) {
            int count =0;
            if(gap % 2 == 0){
                count = gap / 2;
            } else if (gap % 3 ==0) {
                count = gap / 3;
            }
            int temp =0;
            for(int i = 1; i<=count; i++){
                if(y/(x + (i*n)%2) == 0){
                    int multipleCount = y/(x + (i*n) / 2);
                    temp = i + multipleCount;
                    break;
                } else if (y/(x + (i*n)) %3 == 0) {
                    int multipleCount = y/(x + (i*n)) / 3;
                    temp = i + multipleCount;
                    break;
                }
            }
            if(answer != 0 && temp<answer) {
                answer = temp;
            }else if(answer == 0){
                answer = temp;
            }
        }
        if(answer ==0)  {
            answer = -1;
        }
        System.out.println(answer);
        return answer;
    }
}
