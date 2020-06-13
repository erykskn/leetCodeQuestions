package com.ery.algorithms;

import java.util.HashMap;
import java.util.Map;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        boolean result = false;
        Map<ListNode, ListNode> nodeMap = new HashMap<>();

        while ( head != null && head.next != null){
            ListNode listNode = nodeMap.get(head);
            if (listNode == null){
                nodeMap.put(head, head);
            }else{
                result = true;
                break;
            }
            head = head.next;
        }


        return result;

    }
}
