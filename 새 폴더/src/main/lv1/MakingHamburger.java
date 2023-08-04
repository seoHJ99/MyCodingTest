package main.lv1;

import java.util.ArrayList;
import java.util.List;

public class MakingHamburger {
    public static void main(String[] args) {
        int[] a = {2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 3, 1, 3, 1};
        MakingHamburger makingHamburger = new MakingHamburger();
        makingHamburger.solution(a);
    }
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int i : ingredient) {
            list.add(i);
        }
        for(int i =0; i<list.size()-3;){
            if(list.get(i)==1 && list.get(i+1) == 2 && list.get(i+2) == 3 && list.get(i+3) == 1){
                answer++;
                list.remove(i + 3);
                list.remove(i + 2);
                list.remove(i + 1);
                list.remove(i);
                if(i>3) {
                    i -= 4;
                }else {
                    i = 0;
                }
            }else {
                i++;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
