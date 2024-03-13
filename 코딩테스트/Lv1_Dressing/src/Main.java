public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] bandage = {2, 2, 1};
        int health = 10;
        int[][] attacks = {{1, 4}, {5, 5}, {12, 2}};
        solution.solution(bandage, health, attacks);
    }
}