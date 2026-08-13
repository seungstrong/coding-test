import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];        
        ArrayList<Integer> sortedArray = new ArrayList<>();
        int idx = 0;
        
        for(int[] command : commands){
            
            
            for(int i=command[0]-1; i<command[1]; i++){
                sortedArray.add(array[i]);
            }

            sortedArray.sort(Comparator.naturalOrder());

            
            answer[idx++] = sortedArray.get(command[2] - 1);
            
            sortedArray.clear();
            
        }
        
        return answer;
    }
}