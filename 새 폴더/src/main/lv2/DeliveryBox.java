package main.lv2;

import java.util.Stack;

public class DeliveryBox {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int sample[] = {5, 4, 3, 2, 1};
        solution.solution(sample);
    }
}

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int idx = 0;
        int nowOrder = order[answer];
        Stack<Integer> sideBelt = new Stack<>();
        for (int i = 0; i <= order.length; ) {
            i++;
            if(i == nowOrder){
                answer++;
                if(answer== order.length){
                    break;
                }
                nowOrder = order[answer];
                continue;
            }else if(!sideBelt.empty() && sideBelt.peek() == nowOrder){
                answer++;
                if(answer== order.length){
                    break;
                }
                nowOrder = order[answer];
                sideBelt.pop();
                i--;
                continue;
            }else {
                sideBelt.push(i);
            }
        }
        System.out.println(answer);
        return answer;
    }
}
