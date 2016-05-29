package zhang.algorithm.leetcode.question55_Jump_Game;

public class JumpGame {
	/**
	 * 这题的关键是理解好题意，每次选择能到达最远的那个继续前进<br/>
	 * <br/>
	 * 这么简单的一道题，这代码竟然错了三次，我写代码逻辑太混乱，代码太复杂！！<br/>
	 * 
	 * 72 / 72 test cases passed.<br/>
	 * Status: Accepted<br/>
	 * Runtime: 3 ms 击败27%<br/>
	 * 
	 * @param nums
	 * @return
	 */
    public boolean canJump(int[] nums) {
    	int cur = 0;
    	int maxIndex = 0;
    	
    	if(nums.length <= 1){
    		return true;
    	}
    	
    	while(nums[cur=maxIndex]!=0 && cur<nums.length){
    		if(cur+1+nums[cur] >=nums.length){
    			return true;
    		}
    		for(int i=1; i<=nums[cur]; i++){
    			maxIndex = (nums[cur+i]+cur+i)>(nums[maxIndex]+maxIndex)?cur+i:maxIndex;
    		}
    		if(maxIndex == cur){
    			maxIndex = cur+nums[cur];
    		}
    	}
    	
        return false;
    }
    
    /**
     * 这个解法的思路很好，而且代码相当简介清晰！！<br/>
     * <br/>
     * 借鉴别人优秀代码<br/>
     * <br/>
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
    	int n = nums.length;
    	
        if(n==0) return false;
        if(n==1) return true;  //already reach the end by itself. 

        // 1. start from the end, work you way backward
        // 2. the initial target Index is the last element, search the one(say index i) that reaches the target
        // 3. then update the target Index as i, repeat step 2.
        
        int tarIndex = n-1;
        for(int i=n-2; i>=0; i--){
        	int gap = tarIndex-i;
        	if(gap<=nums[i]) tarIndex = i;
        }
        
        return tarIndex==0;
    }
	
	public static void main(String[] args){
		JumpGame test = new JumpGame();
		int[] nums = {1,1,2,2,0,1,1};
		System.out.println(test.canJump(nums));
		System.out.println(test.canJump2(nums));
	}
}
