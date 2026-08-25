import java.util.*;
// 1. strings에서 인덱스 n값을 기준으로 정렬
// 2. 인덱스 n 값이 같은 경우 사전순으로 처리

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        Arrays.sort(strings, (a,b)->{
            char charA = a.charAt(n);
            char charB = b.charAt(n);
            
            if(charA==charB){
                return a.compareTo(b); // 사전순 정렬
            }
            
            return charA-charB; // 오름차순
        });
        answer = strings;        
        
        return answer;
    }
}