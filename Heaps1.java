//Problem 1: (https://leetcode.com/problems/kth-largest-element-in-an-array/)
// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: We will use min heap to solve this problem. We will add all the elements to the heap and if the size of heap is greater than k, we will remove the top element.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}

// Problem 2: (https://leetcode.com/problems/merge-k-sorted-lists/)
// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: It initializes a priority queue to store the head nodes of all
// lists, prioritized by their values. It repeatedly extracts the smallest node
// from the queue, appends it to the result, and adds the next node from the
// extracted node's list back to the queue if it exists.

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode li : lists) {
            if (li != null) {
                pq.add(li);
            }
        }
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if (min.next != null) {
                pq.add(min.next);
            }
        }
        return result.next;
    }
}