package CoreJAVA.Test;

import java.util.*;
public class Palindrome {
    public static void main(String[] args) {
        // System.out.println(PalindromeOrNot("madam"));
        // List<Integer> saample = Arrays.asList(12,11,15);
        // System.out.println(secondLargest(saample));
        int[] numbers = {1,0,0,1,1,1,1,0};

        System.out.println(">>> " + lengthOfTheMaxConsequtive2(numbers));

    }

    public static boolean PalindromeOrNot(String sample){
        int left = 0;
        int right = sample.length()-1;

        while(left < right){
            if(sample.charAt(left) != sample.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static int secondLargest(List<Integer> sample){
        return sample.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
    }

    public static int lengthOfTheMaxConsequtive(int[] nums){
	if(nums.length == 0){
		return 0;
	}
	int max_count = Integer.MIN_VALUE;
	int length = nums.length;
	for(int i = 0; i < length;i++){
		int count = 1;
		for(int j = i+1; j < length; j++){
			if(nums[i] == nums[j]){
				count++;
				max_count = Math.max(count, max_count);
			}else{
                i = j;
			break;
            }
		}
		
	}

	return max_count;

}

public static int lengthOfTheMaxConsequtive2(int[] nums){

	int l = 0;
	int r = 1;
	int max_count = Integer.MIN_VALUE;

	while(r < nums.length){
		if(nums[r] == nums[l]){
		max_count = Math.max((r - l + 1), max_count);
   	}else{
		l = r;
	}
	r++;
} 
	return max_count;
}

}





