package test;

import linkedlist.ListNode;
import tree.TreeNode;

import java.util.*;

public class Test1 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    //1
    //23
    //4567

    public void inOrderRecu(tree.TreeNode root) {
        //Left Root Right
        //4251637
        if (root != null) {
            inOrderRecu(root.left);
            System.out.println(root.val);
            inOrderRecu(root.right);
        }
    }

    public void inOrder(tree.TreeNode root) {
        tree.TreeNode curr = root;
        Stack<tree.TreeNode> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.println(curr.val);
            curr = curr.right;
        }
    }

    public void level(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        queue.add(null);
        ArrayList result = new ArrayList<>();
        ArrayList level = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp != null) {
                level.add(tmp.val);
                if (tmp.left != null)
                    queue.add(tmp.left);
                if (tmp.right != null)
                    queue.add(tmp.right);
            } else {
                queue.poll();
                result.addAll(level);
                level.clear();
                if (!queue.isEmpty())
                    queue.add(null);
            }
        }
    }

    boolean pathSum(TreeNode root, int pathSum) {
        if (root == null)
            return false;
        pathSum = pathSum - root.val;
        if (root.left == null && root.right == null)
            return pathSum == 0;
        return pathSum(root.left, pathSum) || pathSum(root.right, pathSum);
    }

    public boolean isValidBST(TreeNode root) {
        return helperValid(root, null, null);
    }

    private boolean helperValid(TreeNode root, Integer low, Integer high) {
        if (root == null) return true;
        if ((low != null && root.val < low) || (high != null && root.val > high))
            return false;
        return
                helperValid(root.left, low, root.val) && helperValid(root.right, root.val, high);
    }

    //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int m1 = m - 1, n1 = n - 1;
        for (int p = m + n - 1; p >= 0; p--) {
            if (n1 < 0)
                break;
            if (m1 > 0 && nums1[m1] >= nums2[n1]) {
                nums1[p] = nums1[m1];
                m1--;
            } else {
                nums1[p] = nums2[n1];
                n1--;
            }
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode head1 = new ListNode(-1);
        head1.next = head;
        ListNode prev = head1;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;
            prev = first;
            head = first.next;
        }
        return head1.next;
    }

    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0)
            return 0;
        if (intervals.length == 1)
            return 1;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int rooms = 1;
        boolean  canAccomodate = false;
        for (int i = 1; i < intervals.length; i++) {
            int[] a = intervals[i - 1];
            int[] b = intervals[i];
            if (a[0] < b[0] && a[1] > b[0]) {
                rooms++;
                if(canAccomodate)
                    rooms++;
                canAccomodate = false;
            }
            else {canAccomodate= true;}
        }
        if(canAccomodate)
            rooms++;
        return rooms;
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->a-b);
        for (int i = 0;  i<nums.length; i++) {
            minHeap.add(nums[i]);
            if(minHeap.size()>k)
                minHeap.remove();
        }
        return minHeap.peek();
    }
    public int maxProfit(int[] prices) {

        int len = prices.length;
        int lowest=0;
        int maxProfit=0;
        for (int i = 1; i < len; i++) {
            if(prices[lowest]<prices[i]){
                int profit = prices[i] - prices[lowest];
                maxProfit = Math.max(maxProfit,profit);
            } else {
                lowest=i;
            }
        }
        return maxProfit;
    }

    int diameter =0 ;
    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode curr){
        if(curr==null)
            return 0;
        int leftLength = dfs(curr.left);
        int rightLength = dfs(curr.right);
        diameter = Math.max(diameter,leftLength+rightLength);
        return Math.max(leftLength,rightLength)+1;
    }

}
