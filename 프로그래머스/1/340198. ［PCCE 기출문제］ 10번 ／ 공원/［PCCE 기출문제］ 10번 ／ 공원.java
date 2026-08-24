import java.util.*;
import java.io.*;

// 1. mats 오름차순 정렬
// 2. park 좌측 상단부터 탐색
// 3. 끝까지 비어 있으면 return

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        Integer[] matsDesc = new Integer[mats.length];
        
        for(int i=0; i<mats.length; i++){
            matsDesc[i] = mats[i];
        }
        Arrays.sort(matsDesc, Collections.reverseOrder());
        
        int rows = park.length;
        int cols = park[0].length;
        
        for(int mat : matsDesc){
            for(int i=0; i<=rows - mat; i++){
                for(int j=0; j<=cols - mat; j++){
                    Boolean isClear = true;
                        for(int k=i; k<i+mat; k++){
                            for(int l=j; l<j+mat; l++){
                                if(!park[k][l].equals("-1")){
                                    isClear = false;
                                }                                
                                if(!isClear) break;
                            }
                            if(!isClear) break;
                        }
                    if(isClear){
                        answer = mat;
                        return answer;
                    }

                }
            }
        }
        
        return answer;
    }
}

// 1. 정렬 내림차순 int -> Integer로 변환 후 Arrays.sort(mats, Collections.reverseOrder());
// 2. String 비교는 .equals() 사용
// 3. flag 변수 활용