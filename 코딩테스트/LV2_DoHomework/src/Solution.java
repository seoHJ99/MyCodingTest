import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

class Solution implements Comparator {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] plans = {{"0", "00:00", "10"}, {"1", "00:05", "10"}, {"2", "00:10", "40"}, {"3", "00:20", "10"},
                {"4", "00:25", "10"}, {"5", "01:10", "5"}, {"6", "01:30", "10"}};
        solution.solution(plans);
    }

    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        List<List<String>> planList = new ArrayList<>(Arrays.stream(plans).map(element -> Arrays.stream(element).collect(Collectors.toList())).collect(Collectors.toList()));
        Stack<List> stop = new Stack<>();
        Collections.sort(planList, new Solution());

        for (int i = 0; i < planList.size(); i++) {
            if (i < planList.size() - 1) {
                LocalTime nowWorkStartTime = LocalTime.parse(planList.get(i).get(1));
                LocalTime nextWorkStartTime = LocalTime.parse(planList.get(i + 1).get(1));
                Duration betweenTime = Duration.between(nowWorkStartTime, nextWorkStartTime);
                Duration workingTime = Duration.of(Long.parseLong(planList.get(i).get(2)), ChronoUnit.MINUTES);
                int canDoWork = betweenTime.compareTo(workingTime);

                if (canDoWork < 0) {
                    List work = new ArrayList<>();
                    work.add(planList.get(i).get(0));
                    work.add(workingTime.minus(betweenTime));
                    stop.push(work);
                } else if (canDoWork == 0) {
                    answer.add(planList.get(i).get(0));
                } else {
                    boolean stopSign = false;
                    Duration leftBetweenTime = betweenTime.minus(workingTime);
                    Duration freeTime = leftBetweenTime;

                    answer.add(planList.get(i).get(0));
                    while (stopSign == false) {
                        if(freeTime.isZero()){
                            break;
                        }
                        if (!stop.isEmpty()) {
                            List stopWorking = stop.pop();
                            Duration leftWorkingTime = (Duration) stopWorking.get(1);
                            Duration leftTime = leftWorkingTime.minus(leftBetweenTime);
                            if (!leftTime.isNegative()) {
                                freeTime= freeTime.minus(leftWorkingTime);
                                if (leftTime.isZero()) {
                                    answer.add(stopWorking.get(0).toString());
                                } else {
                                    stopWorking.set(1, leftTime.abs());
                                    stop.push(stopWorking);
                                }
                                stopSign = true;
                            } else {
                                freeTime=freeTime.minus(leftWorkingTime);
                                if(freeTime.isNegative()){
                                    stopWorking.set(1,leftBetweenTime.minus(freeTime));
                                    stop.push(stopWorking);
                                }else {
                                    stopWorking.set(1,leftBetweenTime.minus(freeTime));
                                    answer.add(stopWorking.get(0).toString());
                                }
                            }
                        } else if (stop.isEmpty()) {
                            stopSign = true;
                        }
                    }
                }
            } else {
                answer.add(planList.get(i).get(0));
                while (true) {
                    if (stop.isEmpty()) {
                        break;
                    }
                    List pop = stop.pop();
                    answer.add((String) pop.get(0));
                }
            }
        }

        for (String list : answer) {
            System.out.println(list);
        }

        String arr[] = answer.toArray(new String[answer.size()]);
        return arr;
    }

    @Override
    public int compare(Object o1, Object o2) {
        List<String> list1 = (List<String>) o1;
        List<String> list2 = (List<String>) o2;
        if (LocalTime.parse(list1.get(1)).isBefore(LocalTime.parse(list2.get(1)))) {
            return -1;
        } else {
            return 1;
        }
    }
}