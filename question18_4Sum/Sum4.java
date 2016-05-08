package zhang.algorithm.leetcode.question18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {
	/**
	 * 暂时未成功！
	 * @param nums
	 * @param target
	 * @return
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if(nums.length<4){
			return lists;
		}
		
		int head1 = 0;
		int head2 = 1;
		int tail1 = nums.length-1;
		int tail2 = nums.length-2;
		Arrays.sort(nums);
		
		while(head1<head2 && head2<tail2 && tail2<tail1){
			int sum4 = nums[head1]+nums[head2]+nums[tail2]+nums[tail1];
			if(sum4 == target){
				//add
				List<Integer> list = new ArrayList<Integer>();
				list.add(nums[head1]);
				list.add(nums[head2]);
				list.add(nums[tail2]);
				list.add(nums[tail1]);
				lists.add(list);
				
				head2++;
				tail2--;
				while(head2<tail2 && nums[head2]==nums[head2-1]){
					head2++;
				}
				while(head2<tail2 && nums[tail2]==nums[tail2+1]){
					tail2--;
				}
				if(head2>=tail2){
					head2--;
					tail2++;
					head1++;
					tail1--;
				}
			}else if(sum4 > target){
				tail2--;
				if((tail2>head2 && nums[head1]+nums[head2]+nums[tail2]+nums[tail1]<target) || tail2<=head2){
					tail1--;
					tail2 = tail1-1;
				}
			}else if(sum4 < target){
				head2++;
				if((head2<tail2 && nums[head1]+nums[head2]+nums[tail2]+nums[tail1]>target) || head2>=tail2){
					head1++;
					head2 = head1+1;
				}
			}
		}
			
        return lists;
    }
	
	/**
	 * 利用3sum的方法，只不过当使用到四个数之和时，3Sum的方法循环n次 <br/>
	 * 时间复杂度为O(n^3) <br/>
	 * 60ms <br/>
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public List<List<Integer>> fourSum2(int[] nums, int target) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if(nums.length<4){
			return lists;
		}
		Arrays.sort(nums);
		for(int i=0; i<nums.length; i++){
			if(i!=0 && nums[i]==nums[i-1]){
				continue;
			}
			for(int j=i+1; j<nums.length; j++){
				if(j!=i+1 && nums[j]==nums[j-1]){
					continue;
				}
				
				int exceptedSum = target-nums[i]-nums[j];
				int head = j+1;
				int tail = nums.length-1;
				while(head<tail){
					if(nums[head]+nums[tail]==exceptedSum){
						//add
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[head]);
						list.add(nums[tail]);
						lists.add(list);
						
						head++;
						tail--;
						while(head<tail && nums[head]==nums[head-1]){
							head++;
						}
						while(tail>head && nums[tail]==nums[tail+1]){
							tail--;
						}
					}else if(nums[head]+nums[tail]>exceptedSum){
						tail--;
					}else if(nums[head]+nums[tail]<exceptedSum){
						head++;
					}
				}
				
			}
		}
		
		return lists;
	}
	
	public static void main(String[] args){
		Sum4 test = new Sum4();
		int[] nums = {0,0,0,0,0,0};
		System.out.println(test.fourSum2(nums, 0));
	}
}
