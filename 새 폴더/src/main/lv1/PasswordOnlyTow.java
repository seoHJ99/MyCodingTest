package main.lv1;

public class PasswordOnlyTow {
    public static void main(String[] args) {
        PasswordOnlyTow pro = new PasswordOnlyTow();
        pro.solution("aukks", "wbqd", 5);
    }

    public String solution(String s, String skip, int index) {
        String answer = "";
        int[] alphabet = new int[26];
        for(int i =0; i<26; i++){
            alphabet[i] = 'a'+i;
        }
        for(int i =0; i<skip.length(); i++){
            int start = skip.charAt(i);
            for(int j = start; j<='z'; j++){
                if(j + index >'z'){
                    alphabet[j - 'a'] = alphabet[j-'a'] +index;
                    alphabet[j - 'a' - 1] = alphabet[j-'a'];
                }else {
                    alphabet[j - 'a'] = j + index;
                }
            }
        }
        for(int a : alphabet){
            System.out.print(Character.toString(a));
        }
        System.out.println();
        for(int i =0; i<s.length(); i++){
            int spell = alphabet[ s.charAt(i)-'a'];
            if(spell<='z'){
                answer += Character.toString(spell);
            }else {
                answer += Character.toString(spell - 26);
            }
        }
        System.out.println(answer);
        return answer;
    }
}
