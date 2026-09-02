import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        
        int idx = 1;
        for(String privacy : privacies){
            //String date = privacy.substring(0,10);
            String date = privacy.split(" ")[0];
            String year = date.substring(0,4);
            String month = date.substring(5,7);
            String day = date.substring(8,10);
            String typePrivacy = privacy.split(" ")[1];
            
            int privacyDate = ( Integer.parseInt(year) * 12 + Integer.parseInt(month) ) * 28 + Integer.parseInt(day); // 개인정보 수집 일자
            int current = ( Integer.parseInt(today.substring(0,4)) * 12 + Integer.parseInt(today.substring(5,7)) ) * 28 + Integer.parseInt(today.substring(8,10));
            // 오늘
            
            for(String term : terms){
                String typeTerm = term.split(" ")[0];
                if(typePrivacy.equals(typeTerm)){
                    // term.split(" ")[1] 을 privacyDate 더한 값과 privacy.split(" ")[0] 과 비교
                    int expiration = privacyDate + Integer.parseInt(term.split(" ")[1]) * 28;
                    
                    if(expiration <= current){
                        //파기
                        list.add(idx);
                    }
                    
                    idx++;
                    
                    // 기간 만료되었으면 파기 list에 add
                    break;
                }
            }
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}