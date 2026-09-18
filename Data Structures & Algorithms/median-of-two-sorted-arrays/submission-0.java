class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] shorter;
        int[] longer;
        if(nums1.length > nums2.length){
            shorter = nums2;
            longer = nums1;
        }else {
            shorter = nums1;
            longer = nums2;
        }
        //binary search on element count of the smaller arr that are from the half of elements less than median
        int l = 0;
        int r = shorter.length;
        int halfTotalLen = (nums1.length + nums2.length) / 2;
        while(true){
            int count = l + (r - l) / 2;
            int countFromLonger = halfTotalLen - count;
            if(count != 0 && countFromLonger != longer.length 
            && shorter[count -1] > longer[countFromLonger]){
                r = count - 1;
            }else if(count != shorter.length && countFromLonger != 0
            && shorter[count] < longer[countFromLonger - 1]){
                l = count + 1;
            }else {
                int shortLeft = (count > 0) ? shorter[count - 1] : Integer.MIN_VALUE;
                int longLeft  = (countFromLonger > 0) ? 
                longer[countFromLonger - 1] : Integer.MIN_VALUE;
                
                int shortRight = (count < shorter.length) 
                ? shorter[count] : Integer.MAX_VALUE;
                int longRight  = (countFromLonger < longer.length) 
                ? longer[countFromLonger] : Integer.MAX_VALUE;

                int maxLeft = Math.max(shortLeft, longLeft);
                int minRight = Math.min(shortRight, longRight);
                if ((shorter.length + longer.length) % 2 == 0) {
                    return (maxLeft + minRight) / 2.0;
                } else {
                    return minRight; 
                }
            }
        }
    }
}
