package main.lv1;

import java.util.HashSet;
import java.util.Set;

public class PasswordOnlyTow {
    public static void main(String[] args) {
        PasswordOnlyTow pro = new PasswordOnlyTow();
        pro.solution("klmnopqrstuvwxyz", "abcdefghij", 20);
    }

    public String solution(String s, String skip, int index) {
        String answer = "";
        Set<Character> skipChar = new HashSet<>();
        for(int i =0; i<skip.length(); i++){
            skipChar.add(skip.charAt(i));
        }
        for(int i=0; i<s.length(); i++){
            char spell = s.charAt(i);
            int moving = index;
            for(int j =1; j<= moving;){
                char a = (char) (spell + 1 );
                if(skipChar.contains(a)){
                    j--;
                }
                spell = a ;
                if(spell >'z'){
                    spell ='a';
                    moving = index-j;
                    if(moving == 0){
                        moving =1;
                    }
                    j = 0;
                    continue;
                }
                j++;
            }
            answer += spell;
        }
        System.out.println(answer);
        return answer;
    }
}
