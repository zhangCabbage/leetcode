package zhang.algorithm.leetcode.question38_count_and_say;

public class CountAndSay {
	/**
	 * 本来我不想使用string类型，以节省时间，但是使用long型看能否通过，但是出错了！<br/>
	 * java.lang.NumberFormatException: For input string: "11781113111221131221" <br/>
	 * @param n
	 * @return
	 */
	public String countAndSay(int n) {
		long cur = 0;
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<n; i++){
			sb = new StringBuffer();
			
			long highest = cur;
			int bit = 0;
			
			while(highest > 9){
				highest = highest/10;
				bit++;
			}
			
			while(bit >= 0){
				int count = 1;
				bit--;
				while(bit>=0 && (cur/(int)Math.pow(10, bit))%10==highest){
					count++;
					bit--;
				}
				
				sb.append(count);
				if(highest != 0){
					sb.append(highest);
				}
				if(bit >= 0){
					highest = (cur/(int)Math.pow(10, bit))%10;
				}
			}
			cur = Long.parseLong(sb.toString());
		}
        return sb.toString();
    }
	
	public String countAndSay2(int n) {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<n; i++){
			int len = sb.length();
			if(len == 0){
				StringBuffer temp = new StringBuffer();
				temp.append(1);
				sb = temp;
			}else{
				int cur = 0;
				int sameNext = cur+1;
				StringBuffer temp = new StringBuffer();
				while(cur<len){
					while(sameNext<len && sb.charAt(cur)==sb.charAt(sameNext)){
						sameNext++;
					}
					temp.append(sameNext-cur);
					temp.append(sb.charAt(cur));
					cur = sameNext;
				}
				sb = temp;
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args){
		CountAndSay test = new CountAndSay();
//		System.out.println(test.countAndSay(5));
		System.out.println(test.countAndSay2(40));
	}
}
