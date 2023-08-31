package main.lv2;

public class NumberTransfer {

    public static void main(String[] args) {
        int x = 2;
        int y = 9;
        int n = 1;
        solution(x, y, n);
    }
    public static int solution(int x, int y, int n) {
        int answer =0 ;
        int gap = y-x;
        for(int i =0; i<gap/n; i++){
            int temp = x + i*n;
            if(y/temp%6 == 0){
                int tempAnswer = i + (y/temp)/3*2;
                answer = tempAnswer;
                break;
            } else if( y/temp%3 == 0 ){
                int tempAnswer = i + (y/temp)/3;
                if(i == 0){
                    answer = tempAnswer;
                }
                if(answer != 0 && tempAnswer < answer){
                    answer = tempAnswer;
                }
                break;
            } else if (y/temp % 2 == 0) {
                int tempAnswer = i + (y/temp)/2;
                if(i == 0){
                    answer = tempAnswer;
                }
                if(answer != 0 && tempAnswer < answer){
                    answer = tempAnswer;
                }
                break;
            }else {
                answer = -1;
            }
        }
        for(int i =0; i<=gap/n; i++){
            if(gap%n == 0){
                int tempAnswer = gap/n;
                if(answer == -1 || tempAnswer<answer){
                    answer =tempAnswer;
                }
            }
        }
        if(answer == 0){
            answer = -1;
        }

        System.out.println(answer);
        return answer;
    }
}
