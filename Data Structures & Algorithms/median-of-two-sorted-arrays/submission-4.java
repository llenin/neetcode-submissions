class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        if(B.length < A.length){
            int[] temp = A;
            A = B;
            B = temp;
        }
        int total = A.length + B.length;
        int half = (total + 1) / 2;
        int l = 0;
        int r = A.length;
        while(l <= r){
            int m1 = (l + r) / 2;
            int m2 = half - m1;

            int l1 = m1 > 0 ? A[m1 - 1] : Integer.MIN_VALUE;
            int r1 = m1 < A.length ? A[m1] : Integer.MAX_VALUE;
            int l2 = m2 > 0 ? B[m2 - 1] : Integer.MIN_VALUE;
            int r2 = m2 < B.length ? B[m2] : Integer.MAX_VALUE;

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
