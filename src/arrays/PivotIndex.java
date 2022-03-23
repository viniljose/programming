package arrays;

public class PivotIndex {
    public static void main(String[] args) {
        PivotIndex pivotIndex =new PivotIndex();
        int[] data1 = new int[]{1,7,3,6,5,6};
        System.out.println(pivotIndex.pivotIndex(data1));

        int[] data2 = new int[]{2,1,-1};
        System.out.println(pivotIndex.pivotIndex(data2));
    }
    public int pivotIndex(int[] nums) {
        int sum=0,leftSum=0;
        for(int i:nums)
            sum += i;
        for(int i=0;i<nums.length;i++){
            if(leftSum==(sum-nums[i]-leftSum))
                return i;
            leftSum+= nums[i];
        }
        return -1;
    }
}
