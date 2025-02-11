package main.lv2;

public class Retry {
    public static void main(String[] args) {
        Retry retry = new Retry();
        retry.solution("JAZ");
    }

    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        int allUpDown = 0;
        for(int i =0; i<name.length(); i++){
            allUpDown += getUpDownCount(name, i);
            int nextIndex = getNext(name, i);
            if(nextIndex != -1){
            }
        }



        return answer;
    }

    private int getNext(String name, int index) {
        int result = -1;
        for(int i=index; i<name.length(); i++){
            if(name.charAt(i) != 'A'){
                return i;
            }
        }
        return result;
    }

    private int getUpDownCount(String name, int i) {
        int up = 'Z' - name.charAt(i) +1;
        int down = i - 'A';
        return Math.min(up, down);
    }
}
