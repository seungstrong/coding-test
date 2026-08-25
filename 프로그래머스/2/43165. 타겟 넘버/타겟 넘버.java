import java.util.*;

class Solution {
    public int dfs(int[] numbers, int target, int index, int sum){
        // index가 numbers 끝까지 가면 return
        if(index == numbers.length){
            if(target == sum){
                return 1;
            }
            
            return 0;
        }
        
        int plus = dfs(numbers, target, index+1, sum+numbers[index]);
        int minus = dfs(numbers, target, index+1, sum-numbers[index]);
                        
        return plus+minus;
    }
        
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, 0, 0);
        return answer;
    }
}

// 1. DFS 구조
// index = 현재 처리할 숫자의 위치
// index가 끝까지 가면 종료
// -> sum == target이면 성공한 경우 1개 → return 1
// -> sum != target이면 성공한 경우 0개 → return 0