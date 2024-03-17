import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

class Solution implements Comparator{

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        solution.solution(plans);
    }
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        List<List<String>> planList = new ArrayList<>(Arrays.stream(plans).map(element -> Arrays.stream(element).collect(Collectors.toList())).collect(Collectors.toList()));
        Stack<String> stop = new Stack<>();
        planList.sort(new Solution());
        for (int i =0; i<planList.size(); i++) {
            if(i<planList.size()-1){
                LocalTime nowWorkStartTime = LocalTime.parse(planList.get(i).get(1));
                LocalTime nextWorkStartTime = LocalTime.parse(planList.get(i+1).get(1));
                Duration betweenTime = Duration.between( nowWorkStartTime, nextWorkStartTime );
                Duration workingTime = Duration.of(Long.parseLong(planList.get(i).get(2)), ChronoUnit.MINUTES);
                System.out.println(planList.get(i).get(0));
                System.out.println(betweenTime);
                System.out.println(workingTime);
                int result = betweenTime.compareTo(workingTime);
                System.out.println(result);
                System.out.println("---------");

                if(result<0){
                    stop.push(planList.get(i).get(0));
                }else {
                    answer.add(planList.get(i).get(0));
                }
            }else {
                answer.add(planList.get(i).get(0));
            }
        }
        while (!stop.isEmpty()){
            answer.add(stop.pop());
        }

        for (String s : answer) {
            System.out.println(s);
        }
        String arr[] = answer.toArray(new String[answer.size()]);

        return arr;
    }

    @Override
    public int compare(Object o1, Object o2) {
        List<String> list1 = (List<String>)o1;
        List<String> list2 = (List<String>)o2;
        if(LocalTime.parse(list1.get(1)).isBefore(LocalTime.parse(list2.get(1)))){
            return -1;
        }else {
            return 1;
        }
    }


}