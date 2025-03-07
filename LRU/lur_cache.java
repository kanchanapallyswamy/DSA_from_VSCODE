import java.util.*;
class CDLLNode{
    int key,value;
    CDLLNode next,prev;
    CDLLNode(int k,int v){
        key=k;
        value=v;
    }
}
class CDLL{
    CDLLNode head;
    public CDLL(){
        head=null;
    }
    public CDLLNode inserAtBegin(int key,int value){
        CDLLNode nn=new CDLLNode(key,value);
        nn.prev=nn;
        nn.next=nn;
        if(head==null){
            head=nn;
            return head;
        }
        CDLLNode last=head.prev;
        nn.prev=last;
        last.next=nn;
        nn.next=head;
        head.prev=nn;
        head=nn;
        return head;
    }
    public void printLL(){
        CDLLNode c=head;
        if(head==null)return ;
        while(true){
            System.out.println(c.key+" "+c.value);
            c=c.next;
            if(c==head)break;
        }
    }
    public int deleteLastNode(){
        if(head==null ){
            head=null;
            return -1;
        }
        CDLLNode last=head.prev;
        if(head==last){
            head=null;
            return last.key;
        }
        CDLLNode last_scnd=head.prev.prev;
        last_scnd.next=head;
        head.prev=last_scnd;
        return last.key;
    }
    public void moveAtFront(CDLLNode nodeToMove){
        if(nodeToMove==head)return ;
        CDLLNode prev=nodeToMove.prev;
        CDLLNode next=nodeToMove.next;
        prev.next=next;
        next.prev=prev;
        CDLLNode last=head.prev;
        last.next=nodeToMove;
        nodeToMove.prev=last;
        nodeToMove.next=head;
        head.prev=nodeToMove;
        head=nodeToMove;
    }

}
class LRU{
    int capacity;
    int size;
    CDLL list;
    Map<Integer, CDLLNode> mp;
    public LRU(int capacity){
        this.capacity=capacity;
        this.size=0;
        this.list=new CDLL();
       this.mp=new HashMap<>();
    }
    public int get(int key){
        if(!mp.containsKey(key))return -1;
        CDLLNode node=mp.get(key);
        int data=node.value;
        list.moveAtFront(node);
        return data;
    }
    public void put(int key , int value){
        if(mp.containsKey(key)){ // update the value for existing key
            CDLLNode node=mp.get(key);
            node.value=value;
            list.moveAtFront(node);

        }
        else{ // add a new key-value pair

            if(size < capacity){ 
                var nn=list.inserAtBegin(key, value);
                mp.put(key, nn);
                size++;
            }
            else{   //delete and insert at front

                int k=list.deleteLastNode();
                mp.remove(k);
                var nn=list.inserAtBegin(key, value);
                mp.put(key, nn);
            }
    }

}
}
public class lur_cache {
    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1)); // returns 1
        lru.put(3, 3); // evicts key 2
        System.out.println(lru.get(2)); // returns -1 (not found)
        lru.put(4, 4); // evicts key 1
        System.out.println(lru.get(1)); // returns -1 (not found)
        System.out.println(lru.get(3)); // returns 3
        System.out.println(lru.get(4)); // returns 4

        
       

    }
}
