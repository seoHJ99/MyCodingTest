package main.lv1;

import java.util.ArrayList;
import java.util.List;

public class MakingHamburger {
    public static void main(String[] args) {
        int[] a = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        MakingHamburger makingHamburger = new MakingHamburger();
        makingHamburger.solution(a);
    }
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i =0; i<ingredient.length; i++){
            list.add(ingredient[i]);
        }
        for(int i =0; i<list.size()-3; i++){
            if(list.get(i) == 1 && list.get(i+1) == 2 && list.get(i+2) == 3 && list.get(i+3) == 1 ){
                answer++;
                for(int j=0; j<4; j++){
                    list.remove(i);
                }
                i=i-2;
            }
        }
        System.out.println(answer);
        return answer;
//            String str="";
//            for (int i=0; i<ingredient.length-2; i++){
//                if(ingredient[i]==1 && ingredient[i+1]==2 && ingredient[i+2]==3){
//                    for(int j=0; j<ingredient.length; j++) {
//                        str += ingredient[j];
//                    }
//                }
//            }
//            int a = str.length();
//            for(int i=0; i<ingredient.length; i++) {
//                if (str.contains("1231")) {
//                    str = str.replace("1231", "");
//                    answer++;
//                }
//            }
    }
}
