package main.lv1;

public class CleanDesktop {
    class Solution {
        public int[] solution(String[] wallpaper) {
            int[] answer = new int[4];
            int firstX = 50;
            int lastX = 0;
            int firstY = 50;
            int lastY = 0;
            for(int i =0; i<wallpaper.length; i++){
                if(wallpaper[i].indexOf("#") < firstY && wallpaper[i].contains("#")){
                    firstY = wallpaper[i].indexOf("#");
                }
                if(wallpaper[i].contains("#") && firstX == 50){
                    firstX = i;
                }
                if(wallpaper[i].lastIndexOf("#") > lastY){
                    lastY = wallpaper[i].lastIndexOf("#");
                }
                if(wallpaper[i].contains("#")){
                    lastX = i;
                }
            }
            answer[0] = firstX;
            answer[1] = firstY;
            answer[2] = lastX+1;
            answer[3] = lastY+1;
            return answer;
        }
    }
}
