class Solution {
    public int solution(int[][] signals) {
        int answer = -1;
        
        // 1. 각 신호등의 주기 구하기
        int n = signals.length;
        int[] cycles = new int[n];
        
        for(int i=0; i<n; i++){
            
            for(int j=0; j<3; j++){
                cycles[i] += signals[i][j];
            }
        }
        
        // 2. 생각해야할 구간 - 최소공배수 구하기
        int cycleLCM = cycles[0];
        for(int cycle : cycles){
            cycleLCM = getLCM(cycleLCM, cycle);
        }          

        // 3. 주기 내에서 처음으로 "Y" 인 지점 반환
        for(int time=0; time<cycleLCM; time++){
            boolean allYellow = true;
            
            for(int i=0; i<n; i++){ // 신호등 개수
                int green = signals[i][0];
                int yellow = signals[i][1];
                int red = signals[i][2];
                boolean isYellow = false;
                
                int position = time % cycles[i];
                
                if(green<=position && position<green+yellow ){
                    // 현재 신호가 노란불이면
                    isYellow = true;
                }
                
                if(!isYellow){
                    allYellow = false;
                    break;
                }
            }
            
            if(allYellow){
                answer = time+1;
                break;
            }
            
        }
                
        return answer;
    }
    
    static int getGCD(int a, int b){
            
            if(a<b){
                int temp = b;
                b = a;
                a = temp;
            }
            
            while(a % b != 0){
                int n = a % b;
                a = b;
                b = n;
            }
            
            return b;
        };
    
    static int getLCM(int a, int b){
            if(a<b){
                int temp = b;
                b = a;
                a = temp;
            }
            
            return (a / getGCD(a,b)) * b;
        };
}