package chapter3.day01;

public class Solution extends Object{
    public static void main(String[] args) {
        // 建立一个 head
        Node head = new Node(5);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.toPrint();

        // mergeSort
        Solution s = new Solution();
//        s.mergeSort(head).toPrint();
        System.out.println(""+123);
        String so = ""+134;

    }

    public Node mergeSort(Node head){
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        Node minHead = findMiddle(head);
        return merge(mergeSort(head), mergeSort(minHead));

    }

    private Node merge(Node p1, Node p2){
        Node dummy = new Node(-1);
        Node p = dummy;
        while (p1!=null && p2!=null){
            if (p1.value < p2.value){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1!=null){
            p.next = p1;
        }
        if (p2!=null){
            p.next = p2;
        }
        return dummy.next;
    }

    private Node findMiddle(Node head){
        Node fast = head;
        Node slow = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node minHead = slow.next;
        slow.next = null;
        return minHead;
    }

    static class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }

        void toPrint(){
            Node p = this;
            while (p!=null){
                System.out.print(p.value + " ");
                 p = p.next;
            }
        }
    }

}
