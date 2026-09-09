class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] list1 = nums1;
        int[] list2 = nums2;
        if(list2.length < list1.length){
            int[] temp = list1;
            list1 = list2;
            list2 = temp;
        }
        int total = list1.length + list2.length;
        int half = (total + 1) / 2;
        int l = 0;
        int r = list1.length;
        while(l <= r){
            int m1 = (l + r) / 2;
            int m2 = half - m1;
            
            int l1 = m1 > 0 ? list1[m1 - 1] : Integer.MIN_VALUE;
            int r1 = m1 < list1.length ? list1[m1] : Integer.MAX_VALUE;
            int l2 = m2 > 0 ? list2[m2 - 1] : Integer.MIN_VALUE;
            int r2 = m2 < list2.length ? list2[m2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){
                if(total % 2 != 0){
                    return Math.max(l1, l2);
                }
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if(l1 > r2){
                r = m1 - 1;
            } else{
                l = m1 + 1;
            }
        }
        return -1;
    }
}
