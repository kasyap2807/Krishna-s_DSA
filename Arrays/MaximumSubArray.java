// 53. Maximum Subarray

// Given an integer array nums, find the 
// subarray
//  with the largest sum, and return its sum.

 

// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// Example 2:

// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.
// Example 3:

// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

// Constraints:

// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
 

// Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.


// My Code

class Solution {
    public int maxSubArray(int[] nums) {
        int array[] = new int[10];
        int sum = 0;
        int bestsum = nums[0];
        if(nums.length>1)
        {
            for(int h = 0 ; h < nums.length ; h++){
            for(int i = h ; i < nums.length ; i++){
            for(int k = h ; k <= i ; k++){
                sum = sum+nums[k];
            }
            if(sum>bestsum){
                bestsum = sum;
            }
            sum = 0;
        }
        }
        }
        else{
            bestsum = nums[0];
        }
        return bestsum;
    }
}

// lost 200/210

// Updated code with recursion

class Solution2 {
    public int maxSubArray(int[] nums) {
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    private int maxSubArrayHelper(int[] nums, int left, int right) {
        // Base case: when the subarray has one element
        if (left == right) {
            return nums[left];
        }

        // Find the middle of the current subarray
        int mid = left + (right - left) / 2;

        // Recursively calculate the maximum subarray sum for the left and right halves
        int leftMax = maxSubArrayHelper(nums, left, mid);
        int rightMax = maxSubArrayHelper(nums, mid + 1, right);

        // Calculate the maximum sum that crosses the middle
        int crossMax = maxCrossingSum(nums, left, mid, right);

        // Return the maximum of the three values
        return Math.max(leftMax, Math.max(rightMax, crossMax));
    }

    // Helper function to find the maximum sum of the subarray that crosses the middle
    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        // Find the maximum sum on the left side of the mid point
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        // Find the maximum sum on the right side of the mid point
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        // Return the sum of the left and right part
        return leftSum + rightSum;
    }
}


