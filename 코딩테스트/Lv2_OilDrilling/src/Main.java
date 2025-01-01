import java.util.*;

class Solution {
    static int n, m;  // 가로 세로 길이
    static int[] oil;  // 시추관별 석유량. 해당 가로축으로 내려갔을때 얼마 나올지

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
        solution.solution(land);
    }

    public int solution(int[][] land) {
        int answer = 0;

        n = land.length;
        m = land[0].length;
        oil = new int[m];

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(land[i][j] == 1 && visited[i][j] == false){ // 해당 위치에 석유가 있고 방문 기록이 없을때만
                    getOilSize(land, visited, i, j);    
                }
            }
        }
        answer = Arrays.stream(oil).max().getAsInt();
        return answer;
    }

    public void getOilSize(int[][] land, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y}); // 현재 시작 위치 큐에 넣기.
        visited[x][y] = true;  // 해당 위치는 검사 완료됨

        int[] dx = {-1, 1, 0, 0};  // 좌우 이동
        int[] dy = {0, 0, -1, 1};  // 상하 이동

        // 석유 덩어리 개수
        int count = 1;
        Set<Integer> set = new HashSet<>();

        while (!queue.isEmpty()) {
            int[] now = queue.poll(); // 현재 위치 꺼내기
            set.add(now[1]); // 현재 검사한 x좌표 set 에 넣기

            for (int i = 0; i < 4; i++) { // 현재 위치에서 상하좌우 검사
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (!isInRange(nx, ny)) { // nx, ny 가 land 범위 내부인지 확인
                    continue;
                }

                // 방문 기록이 없는데 석유가 있는 경우
                if(land[nx][ny] == 1 && visited[nx][ny] == false){
                    queue.add(new int[]{nx, ny}); // 새롭게 현재 위치가 되어서 다시 상하좌우를 검사해야할 공간으로 큐에 넣음
                    visited[nx][ny] = true; // 방문 기록 남김
                    count +=1; // 해당 위치에서 캘 수 있는 석유량 +1
                }
            }
        }

        for(int index : set){ // 큐에 더이상 담긴 값이 없으면, 즉, 해당 x 좌표에서 접근 가능한 모든 석유를 다 탐색했으면, 구한 석유량을 담음
            oil[index] += count; // += 인 이유는, 해당 위치에서
        }
    }

    public boolean isInRange(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        return true;
    }
}

