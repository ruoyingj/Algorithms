
public class stackUsingLinkedList {

    public class LinkedListNode{
        int val;
        LinkedListNode next;
        public LinkedListNode(int val){
            this.val = val;
        }
    }
    public class LinkedList{
        private LinkedListNode first = null;
        public void insertNode(int val){
            LinkedListNode node = new LinkedListNode(val);
            node.next = first;
            first = node;
        }
        public LinkedListNode deleteFirst(){
            LinkedListNode next = first.next;
            LinkedListNode node = first;
            first = next;
            return node;
        }
        public  boolean isEmpty(){
            return first == null;
        }

    }


    public class Stack{
        LinkedList stack = new LinkedList();
        public void push(int data){
            stack.insertNode(data);
        }
        public int pop(){
            if(!stack.isEmpty()){
                LinkedListNode tail = stack.deleteFirst()
                return tail.val;
            }else {
                return -1;
            }

        }
    }
}
