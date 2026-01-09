import java.util.HashMap;

class LRUCache {

    private class LinkedList{
        int[] val;
        LinkedList next;
        LinkedList prev;
        public LinkedList(int[] val){
           this.val = val;
           this.next = null;
           this.prev = null;
        }
      
    }

    HashMap<Integer,LinkedList> map;
    int size; 
    LinkedList head = null;
    LinkedList tail = null;
    
    public LRUCache(int capacity) {
        this.size = capacity;
        this.map = new HashMap<>(); 
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        LinkedList temp = map.get(key);
        int val = temp.val[1];
        if(temp == head){
            return val;
        }
        else{
            update(temp,temp.val[0],temp.val[1]);
            return val;
        }
    }

    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            LinkedList temp = map.get(key);
            if(temp==head){
                temp.val[1] = value;
                map.put(key,temp);
                return;
            }
            else{
                update(temp,key,value);
            }
        }
        else{
            if(map.size() == this.size) {
                map.remove(tail.val[0]);  // Remove LRU from map
                tail = tail.prev;
                if(tail != null) tail.next = null;
                if(this.size == 1)head = tail;
            }
            insertAtHead(key,value);
        }
    }
    private void update(LinkedList node,int k,int v){
        
        LinkedList p = node.prev;
        // System.out.println(p.val[0]);
        if(node.next!=null){
            p.next = node.next;
            p.next.prev = p;
        }
        else p.next = null;
        if(node == tail)tail = p;
        
        node.next = null;
        node.prev = null;

        insertAtHead(k,v);
    }
    private void insertAtHead(int k,int v){
      
        if(head==null){
            head = new LinkedList(new int[]{k,v});
            tail = head; 
        }
       
        else{
            LinkedList newH = new LinkedList(new int[]{k,v});
            head.prev = newH;
            newH.next = head;
            head = newH;
        }
        
        map.put(k,head);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

