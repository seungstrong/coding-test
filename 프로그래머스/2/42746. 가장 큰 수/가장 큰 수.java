import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] stringNumbers = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            stringNumbers[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(stringNumbers, (a,b)->(b+a).compareTo(a+b));
        // 3 30 vs 30 3
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<numbers.length; i++){
            sb.append(stringNumbers[i]);
            //answer += stringNumbers[i];
            //System.out.print(stringNumbers[i]+" ");
        }
        
        answer = sb.toString();
        
        if(answer.charAt(0) == '0'){
            answer = "0";
        }
        
        
        
        return answer;
    }
}

/*
a.compareTo(b)
음수 -> a를 앞으로
0 -> 같음
양수 -> a를 뒤로
*/