package linked_lists;

import java.util.HashSet;
import java.util.Stack;

public class SLL {


    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    /*
        Puts the given node to the end

        Time complexity O(n) - traverse through the whole list
        Space complexity O(1) - we don't use any extra memory space
     */

    public Node append(Node head,int data){
        Node node = new Node(data);
        if(head==null)
            return node;
        Node tmp = head;
        while(tmp.next!=null)
            tmp=tmp.next;
        tmp.next = node;
        return head;

    }
    /*
        Puts the node at the beginning

        Time complexity O(1) - always add's at the beginning of the list
        Space complexity O(1) - we don't create any data structures
     */
    public Node add(Node head,int data){
        Node node = new Node(data);
        if(head ==null)
            return node;
        node.next = head;
        head = node;
        return head;
    }




    /*
       Deletes the node with the given key

       Time complexity O(n) - length of the linked list, worst case it is the last node
       Space complexity O(1) - we don't use any extra data structures
    */
    public Node deleteValue(Node head,int data){
        if(head==null)
            return null;
        Node tmp = head;
        if(tmp.data==data)
            return head.next;
        while(tmp.next!=null){
            if(tmp.next.data==data){
                tmp.next = tmp.next.next;
                return head;
            }
            tmp = tmp.next;
        }
        return head;
    }
    private int listSize(Node head){
        Node tmp = head;
        int counter = 0;
        while(tmp!=null){
            counter++;
            tmp=tmp.next;
        }
        return counter;
    }

    /*
       Time complexity O(n) - we do everything in one traversal
       Space complexity O(n) - Data structure that stores our duplicate nodes
    */
    public void deleteDuplicates(Node head){
        HashSet<Integer> duplicates = new HashSet<>();
        Node prev = null;
        Node tmp = head;

        while(tmp !=null){
            if(duplicates.contains(tmp.data)){
                prev.next = tmp.next;

            }
            else{
                duplicates.add(tmp.data);
                prev = tmp;
            }
            tmp = tmp.next;
        }
    }

    /*
        Returns the k-th element from the tail of the linked list

        Time complexity O(n) - traversing the list
        Space complexity O(1) - no extra space
     */
    public int kthToLastElement(Node head,int pos){
        if(head==null)
            return -1;
        int listSize = listSize(head);

        if(pos>listSize)
            return -1;

        int counter = 0;
        Node tmp = head;
        while(tmp!=null){
            if(listSize-counter == pos){
                return tmp.data;
            }
            counter++;
            tmp=tmp.next;
        }
        return -1;

    }
    /*
        Time complexity O(n) - traversing the list
        Space complexity O(1) - no extra space
     */
    public void deleteMiddleNode(Node head){
        Node previos=null;
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            previos = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        previos.next = slow.next;
    }

    /*
        Time complexity O(n) - traversing the list
        Space complexity O(n) - creating two new list size of the original
     */

    public Node partition(Node head,int element){
        Node headSmaller = null;
        Node headBigger = null;
        SLL list = new SLL();


        Node tmp = head;
        while(tmp!=null){
            if(tmp.data<element){
                headSmaller = list.add(headSmaller,tmp.data);
            }
            else{
                headBigger = list.add(headBigger,tmp.data);
            }
            tmp = tmp.next;
        }
        if(headSmaller==null)
            return headBigger;
        if(headBigger==null)
            return headSmaller;
        tmp = headSmaller;
        while(tmp.next!=null)
            tmp=tmp.next;
        tmp.next = headBigger;

        return headSmaller;
    }


    private int reverNumber(int sum){
        int newNum = 0;

        while(sum>0){
            newNum = newNum*10+sum%10;
            sum = sum/10;
        }
        return newNum;
    }
    /*
        Time complexity O(n) - traversing the list
        Space complexity O(1) - no extra space
     */

    public Node sumList(Node head1,Node head2){
        int sum1 = 0;
        int sum2 = 0;

        Node tmp = head1;
        while(tmp!=null){
            sum1 = sum1*10+tmp.data;
            tmp = tmp.next;
        }
        tmp = head2;
        while(tmp!=null){
            sum2 = sum2*10+tmp.data;
            tmp=tmp.next;
        }

        sum1 = reverNumber(sum1);
        sum2 = reverNumber(sum2);
        sum1 = sum1+sum2;

        Node newHead = null;
        while(sum1>0){
            newHead = append(newHead,sum1%10);
            sum1 = sum1/10;
        }
        return newHead;


    }
    /*
        Time complexity O(n) - traversing the list
        Space complexity O(1) - no extra space
     */
    public Node reverseList(Node head){
        Node pprev=null;
        Node prev = null;
        Node cur = head;
        while(cur!=null){
            pprev = prev;
            prev = cur;
            cur = cur.next;
            prev.next = pprev;
        }
        return prev;
    }

    /*
        Time complexity O(n) - traversing the list
        Space complexity O(n) - to store rhe first half of the list
     */
    public boolean isPalindrome(Node head){
        Stack<Integer>stack = new Stack<>();

        Node slow =head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            stack.add(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null) {
            slow = slow.next;
            //stack.pop();
        }
        while(slow!=null){
            if(slow.data!=stack.pop())
                return false;
            slow = slow.next;
        }
        return true;

    }
    /*
        Time complexity O(n) - traversing the list
        Space complexity O(1) - no extra space
     */
    public Node loopCycleBeginning(Node head){
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        if(fast==null || fast.next==null)
            return null;
        slow = head;
        while(slow!=fast){
            slow=slow.next;
            fast = fast.next;
        }
        return slow;
    }


    public void printNodes(Node head){
        Node tmp = head;
        while(tmp!=null){
            System.out.println(tmp.data);
            tmp=tmp.next;
        }

    }


    public static void main(String[] args){
        SLL list = new SLL();
        Node head =null;
        head = list.append(head,12);
        head = list.append(head,1);
        head = list.append(head,5);
        head = list.append(head,5);
        head = list.append(head,1);
        head = list.append(head,12);
    //    head = list.reverseList(head);

     //   head = list.deleteValue(head,12);
        //list.deleteDuplicates(head);


        System.out.println(list.isPalindrome(head));


        //Node newHead = list.sumList(head1,head2);
        //list.printNodes(newHead);
    //    head = list.partition(head,5);
      //  list.printNodes(head);


    }
}
