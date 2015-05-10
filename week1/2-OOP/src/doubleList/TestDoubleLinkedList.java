package doubleList;

public class TestDoubleLinkedList {
    
    public static void main(String[] args) {
        
        DoubleLinkedListImpl dll = new DoubleLinkedListImpl(5);
        
        dll.addElem(88);
        
        System.out.println("Head " + dll.getHead());
        System.out.println("Tail " + dll.getTail());
        
        int head = 0;
        dll.remove(head);
        
        System.out.println(dll);
        
    }
}
