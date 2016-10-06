# Question
---

Given an array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

# Thought
---

题目意思： 给定一个 int 数组，全部的数都出现了两次，只有一个数只出现一次，找到这个数。

思路： 由于最好不要创建额外的空间，那么只能在原数组中做。而且需要接近线性的时间，所以个人感觉首先是要先排序，比如说快排的时间复杂度为 O(nlogn)，再遍历查找即可 O(n)。

# Solution
---

```
public class Solution {
    public int singleNumber(int[] nums) {
        
        if(nums.length == 1) return nums[0];
        
        sort(nums,0,nums.length - 1);
        
        return doFindSingleNumber(nums);
    }
    
    public int doFindSingleNumber(final int nums[]){
        for(int i = 0; i < nums.length - 1; i = i + 2){
            if(nums[i] != nums[i + 1]){
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
    
    public void sort(int nums[],
                     final int START,
                     final int END){
        int i = START;
        int j = END;
        int flag = nums[START];
        
        while(i < j){
            while( (i < j) && (nums[j] >= flag) ){
                j--;
            };
            nums[i] = nums[j];
            while( (i < j) && (nums[i] <= flag) ){
                i++;
            };
            nums[j] = nums[i];
        }
        nums[i] = flag;
        
        if( (i - START) > 1 ) sort(nums,START,i - 1);
        if( (END - i) > 1 ) sort(nums, i + 1,END);
    }
}
```