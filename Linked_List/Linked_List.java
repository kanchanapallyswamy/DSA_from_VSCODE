
class ListNode {
    int data;
    ListNode next;
    
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

}
class Solution{

    static ListNode create(int a[]){
        if(a.length==0)return null;
        ListNode head=new ListNode(a[0]);
        ListNode temp=head;
        for(int i=1;i<a.length;i++){
            temp.next=new ListNode(a[i]);
            temp=temp.next;
        }
        return head;
    }   
static void print(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
        System.out.println();
    }
static ListNode reverse(ListNode head){
    if(head==null)return head;
    ListNode next=null,prev=null,c=head;
    while(c!=null){
        next=c.next;
        c.next=prev;
        prev=c;
        c=next;
    }

return prev;
    
}
static ListNode middle_LL(ListNode head){
    ListNode slow = head, fast = head;
    while(fast!=null && fast.next!=null && fast.next.next!=null){
        fast=fast.next.next;
        slow=slow.next;
    }
    if(fast.next==null)return slow;
    else return slow.next;
}

boolean has_Cycle(ListNode head){
    if(head==null)return false;
    ListNode slow=head , fast=head;
    while(fast!=null && fast.next!=null && fast.next.next!=null ){
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast)return true;
    }
    return false;
}
int get_Cycle(ListNode head){
    if(head==null)return 0;
    ListNode slow=head , fast=head;
    while(fast!=null && fast.next!=null && fast.next.next!=null ){
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast)break;
    }
    ListNode f=fast;
    slow=head;
    while(slow!=f){
        slow=slow.next;
        f=f.next;
        if(slow==f)break;
    }
    return slow.data;
}
}

public class Linked_List {
    static Solution s = new Solution();
        public static void main(String[] args) {
            ListNode head = null;
            int a[]={1,3,4,5,6,7,8,9,10,11};
            head=s.create(a);
            ListNode c=head;
            System.out.print("Linked_List: ");
            s.print(c);
           c=s.reverse(c);
           System.out.print("reverse: ");
           s.print(c);
           ListNode middle=s.middle_LL(c);
           System.out.println("Middle of LL : "+middle.data);
           System.out.println();
           ListNode head1=new ListNode(1);
           ListNode head2=new ListNode(2);
           ListNode head3=new ListNode(3);
           ListNode head4=new ListNode(4);
           ListNode head5=new ListNode(5);
           ListNode head6=new ListNode(6);
           ListNode head7=new ListNode(7);
           head1.next=head2;
           head2.next=head3;
           head3.next=head4;
           head4.next=head5;
           head5.next=head6;
           head6.next=head7;
           head7.next=head3;
            boolean found=s.has_Cycle(head1);
            if(found){
                System.out.println("Given Linked List has Cycle ");
                System.out.println("Starting node with Cycle :"+s.get_Cycle(head1));

              //   s.print(head1);
            }
            else System.out.println("Given Linked List has no Cycle");

        }
    }



