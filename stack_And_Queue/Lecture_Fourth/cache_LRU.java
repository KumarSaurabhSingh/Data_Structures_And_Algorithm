import java.util.HashMap;
import java.util.Map;

class Node{

    int key;
    int value;
    Node next;
    Node back;

    public Node(int key, Node next, Node back){
        this.key = key;
        this.value = value;
        this.next = next;
        this.back = back;
    }

    public  Node(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.back = null;
    }
} //Created a Doubly Linked Linked



//Time Complexity - O(N)
//Space Complexity - O(1)


public class cache_LRU {

    //Creating a head and tail
    static Node head = new Node(0, 0), tail = new Node(0, 0);
    static Map<Integer, Node> map = new HashMap<>();
    static int capacity;


    //Class Constructor
    public cache_LRU(int capacity){
        this.capacity = capacity;
        map.clear();
        head.next = tail;
        tail.back = head;
    }


    //Deleting a Node
    static void delete(Node node){
        map.remove(node.key);
        node.back.next = node.next; //Prev Node next -> Next Node
        node.next.back = node.back; //Next Node back -> Prev Node
    }

    //Get a Node from the data structure
    static int get(int key){

        if(map.containsKey(key)){
            Node temp = map.get(key);
            delete(temp);
            insert(temp);
            return temp.value;
        }
        else{
            return -1;
        }
    }

    //Insert a Node in the Data Structure
    static void insert(Node node){
        map.put(node.key, node);
        node.next = head.next;
        node.next.back = node;
        head.next = node;
        node.back = head;
    }


    //Put a Node in the data structure
    static void put(int key, int value){

        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            delete(node);
            insert(node);
        }
        else{
            if(map.size() == capacity){
                Node node  = tail.back;
                delete(node);
                map.remove(node.key);
            }

            Node node = new Node(key, value);
            insert(node);
            map.put(node.key, node);
        }
    }
}
