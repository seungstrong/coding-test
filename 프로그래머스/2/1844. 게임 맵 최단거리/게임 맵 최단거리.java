// 1. 현재 위치를 큐에서 꺼냄
// 2. 북/동/남/서 4방향 확인
// 3. 갈 수 있는 곳 + 아직 방문 안 한 곳 발견
// 4. 그 위치를 방문처리
// 5. 큐에 전부 넣음
// 6. 다시 큐 맨 앞 위치를 꺼내서 반복
import java.util.*;

class Solution {
    
    // 북->동->남->서
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        
        //1. 시작
        queue.offer(new int[]{0,0});
        visited[0][0] = true;
        distance[0][0] = 1;
        
        //2. 큐가 빌 때 까지 탐색
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            int r = cur[0];
            int c = cur[1];
            
            // 주변 탐색
            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                // 맵 밖
                if(nr<0 || nr>= n || nc<0 || nc >=m){
                    continue;
                }
                
                // 벽 or 이미 탐색
                if(maps[nr][nc] == 0 || visited[nr][nc]){
                    continue;
                }
                   
                visited[nr][nc] = true;
                distance[nr][nc] = distance[r][c] + 1;
                queue.offer(new int[]{nr,nc});
                
            }
            
        }
        
        answer = distance[n-1][m-1];
        
        // 목적지 도달 x 
        if(distance[n-1][m-1] == 0)
            answer = -1;
        
        return answer;
    }
}