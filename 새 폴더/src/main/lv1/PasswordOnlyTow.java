package main.lv1;

public class PasswordOnlyTow {
    public static void main(String[] args) {
        PasswordOnlyTow pro = new PasswordOnlyTow();
        pro.solution("ybcde", "az", 1);
    }

    public String solution(String s, String skip, int index) {
        String answer = "";
        int[] skipArr = new int[skip.length()];
        for (int i = 0; i < skip.length(); i++) {
            skipArr[i] = skip.charAt(i);
        }
        for (int i = 0; i < s.length(); i++) {
            int newIndex = index;
            int spell = s.charAt(i);
            for (int j = 0; j < skipArr.length; j++) {
                if (spell + newIndex > 'z') {
                    newIndex = 'z' - (spell+newIndex-1);
                    spell = 'a';
                }
                if (skipArr[j] > spell && spell + newIndex >= skipArr[j]) {
                    newIndex++;
                }
                if(j== skipArr.length-1){
                    answer += Character.toString(spell + newIndex);
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
}
