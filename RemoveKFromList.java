/*
 Given a singly linked list of integers l and an integer k,
 remove all elements from list l that have a value equal to k.

 Note: Try to solve this task in O(n) time using O(1) additional space,
 where n is the number of elements in the list,
 Example :
 For list = [3, 1, 2, 3, 4, 5] and k = 3, the output should be
 removeKFromList(list, k) = [1, 2, 4, 5];

 For List = [1, 2, 3, 4, 5, 6, 7] and k = 10, the output should be
 removeKFromList(list, k) = [1, 2, 3, 4, 5, 6, 7].
*/
 public class RemoveKFromList {
  public static void main(String[] args) {
     Node list = new Node(3);
     list.next = new Node(1);
     list.next.next = new Node(3);
     list.next.next.next = new Node(3);
     list.next.next.next.next = new Node(4);
     list.next.next.next.next.next = new Node(5);
     list.next.next.next.next.next.next = new Node(3);

  /*  Node list = new Node(1);
    list.next = new Node(2);
    list.next.next = new Node(3);
    list.next.next.next = new Node(4);
    list.next.next.next.next = new Node(5);
    list.next.next.next.next.next = new Node(6);
    list.next.next.next.next.next.next = new Node(7); */

    System.out.print("Original List    = ");
    print(list);

    int k = 3;
    System.out.print("After Removing " + k + " = ");
    Node removedList = removeKFromList(list, k);
    print(removedList);
  }

  /* 1. Remove 'k' if its in the beginning of the list and update list pointer.
     2. Check for 'k' in the middle or end and remove it.
     3. while (temp != null && temp.next != null)
  */
  private static Node removeKFromList(Node list, int k){
    if(list == null) return null;

    Node temp = list;

    while(temp != null) {  // remove 'k' if its in the biginning of the list.
      if(temp.data == k){
         temp = temp.next;
         list = list.next; // update the original list pointer
       } else {
          break; // break the loop if k is not in the beginning.
        }
     }
     temp = list;

     while(temp != null && temp.next != null) {
       if(temp.next.data == k){ // remove if 'k' in the middle of the list
         temp.next = temp.next.next;
       } else {  // note else is very important.
         temp = temp.next;
       }
     }
     return list;
   }


  private static void print(Node head){
    while(head != null){
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println();
  }

  private static class Node {
    private int data;
    private Node next;
    private Node(int value){
      this.data = value;
    }
  }
 }
