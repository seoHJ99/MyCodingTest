import java.util.*;

class ExpertOfSelfPlaying {
    public int solution(int[] cards) {
        int N = cards.length;
        boolean visited[] = new boolean [N];
        List<Integer> result = new ArrayList<>(); // 각 박스가 시작점이 될 때, 그룹의 개수를 담는 리스트
        for(int i=0;i<N;i++){ //  모든 박스 오픈
            Queue<Integer> queue = new LinkedList<>();  // BFS 로 품.
            if(!visited[cards[i]-1]){  // 해당 번호가 공개되었는지 여부 기록
                int cnt = 0;  // 현재 i번째에서 시작된 그룹의 개수
                queue.add(cards[i]-1); // 현재 번호의 인덱스를 큐에 넣음. 그리고 이를 시작으로 BFS 탐색
                visited[cards[i]-1] = true; // 번호가 공개되었음을 기록
                while(!queue.isEmpty()){ // BFS 탐색 시작
                    int now = queue.poll(); // 현재 탐색하는 번호
                    cnt++; // 그룹 개수 +1
                    int next = cards[now]-1; // 다음에 열 박스의 인덱스
                    if(visited[next]) continue; // 공개됬으면 통과
                    queue.add(next); // 공개 안됐으면 BFS 탐색열에 넣음
                    visited[next]=true; // 어차피 열 것이니까 번호가 공개되었음을 기록. while 문 처음에서 now 를 기록해도 될듯?
                }
                result.add(cnt); // 해당 번호의 그룹 개수

            }

        }
        for(int s : result)
            System.out.println(s);
        Collections.sort(result,Comparator.reverseOrder()); // 높은 순으로 정렬해서 첫번째, 두번째 곱하기
        int answer = 0;
        if(result.size()!=1)
            answer = result.get(0)*result.get(1);
        return answer;
    }
}