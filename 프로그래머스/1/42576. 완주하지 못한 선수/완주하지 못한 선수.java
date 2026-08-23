import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 1. 참가자별 등장 횟수를 해시맵에 저장
        HashMap<String, Integer> map = new HashMap<>();
        for(String player : participant)
        {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        
        // 2. 완주한 선수의 등장 횟수를 1씩 감소
        for(String player : completion)
        {
            map.put(player, map.get(player) - 1);
        }
        
        // 3. value 가 0이 아닌 원소(미완주자)를 찾는다.
        for(String key : map.keySet())
        {
            if(map.get(key) != 0)
                answer = key;
        }
        
        return answer;
    }
}