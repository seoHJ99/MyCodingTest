import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int weekday =0;
        int days = 30;
        int[][] calendar = new int[6][7];
        int start = 0;
        if(weekday !=0){
            calendar[0][weekday-1] = 1;
            start =weekday-1;
        }else {
            calendar[0][6] = 1;
            start = 6;
        }
        int day =1;
        for(int i =0; i<6; i++){
            for(int j=0; j<7; j++){
                if(i == 0){
                    if(j <= start){
                        continue;
                    }
                    calendar[i][j] = ++day;
                }else {
                    if(day >= days){
                        continue;
                    }
                    calendar[i][j] = ++day;
                }
            }
        }

        List<String> cc = new ArrayList<>(List.of("cc", "aa"));
        System.out.println(cc);
    }
}

