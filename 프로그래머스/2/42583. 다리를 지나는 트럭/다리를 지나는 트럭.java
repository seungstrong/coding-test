import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        /*
        1. 다리 길이 bridge_length
        2. 최대 무게 weigth
        3. 대기 트럭 truck_weights
        */
        int answer = 0;
        
        int time = 0;
        int currentWeight = 0; // 현재 다리 위 무게
        Queue<Integer> waitingTrucks = new LinkedList<>();
        for(int truck: truck_weights){
            waitingTrucks.offer(truck);
        }
        
        Queue<Integer> bridge = new LinkedList<>();
        for(int i=0; i<bridge_length; i++){
            bridge.offer(0);
        }
        
        for(;waitingTrucks.size()!=0 || currentWeight>0;){
            
            // 0. 다리 poll (기본값 0)
            // 1. 다리 올라갈 수 있으면 대기에서 빼서 offer
            // 2. 올라가 있는 트럭은 poll
            
            currentWeight -= bridge.poll();
                       
            if( (!waitingTrucks.isEmpty()) && (currentWeight + waitingTrucks.peek() <= weight)){
                    // 무게 ㅇㅋ
                    currentWeight += waitingTrucks.peek();
                    bridge.offer(waitingTrucks.poll());
                }else{
                bridge.offer(0);
            }
            
            time ++;
                
        }
        
        answer = time;
        
        
        return answer;
    }
}