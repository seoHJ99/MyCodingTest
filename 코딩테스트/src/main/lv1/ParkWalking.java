package main.lv1;

public class ParkWalking {
    public static void main(String[] args) {
        ParkWalking solution = new ParkWalking();
        String[] park = {"SOO", "OOO", "XOO"};
        String[] routes = {"S 1","E 1", "W 2", "S 1", "W 1"};
        solution.solution(park, routes);
    }
    public int[] solution(String[] park, String[] routes) {
        int x =0;
        int y =0;
        int height = park.length-1;
        int width = park[0].length()-1;
        String[][] map = new String[height+1][width+1];
        for(int i =0; i<park.length; i++){
            if (park[i].contains("S")) {
                x = park[i].indexOf("S");
                y = i;
            }
            map[i] = park[i].split("");
        }
        loop1:for(int i =0; i<routes.length; i++){
            String way = routes[i].substring(0, 1);
            int distance = Integer.parseInt(routes[i].substring(2));
            if(way.equals("N")){
                int newY = y - distance;
                if(newY <0){
                    continue loop1;
                }else {
                    for(int j=y; j>=newY; j--){
                        if(map[j][x].equals("X")){
                            continue loop1;
                        }
                    }
                    y=newY;
                }
            }if(way.equals("S")){
                int newY = y + distance;
                if(newY >height){
                    continue loop1;
                }else {
                    for(int j=y; j<=newY; j++){
                        if(map[j][x].equals("X")){
                            continue loop1;
                        }
                    }
                    y=newY;
                }
            }if(way.equals("W")){
                int newX = x - distance;
                if(newX <0){
                    continue loop1;
                }else {
                    for(int j=x; j>=newX; j--){
                        if(map[y][j].equals("X")){
                            continue loop1;
                        }
                    }
                    x=newX;
                }
            }if(way.equals("E")){
                int newX = x + distance;
                if(newX >width){
                    continue loop1;
                }else {
                    for(int j=x; j<=newX; j++){
                        if(map[y][j].equals("X")){
                            continue loop1;
                        }
                    }
                    x=newX;
                }
            }
        }
        System.out.println("y,x: " + y +","+ x);
        int a [] = {y,x};
        return a;
    }
}
