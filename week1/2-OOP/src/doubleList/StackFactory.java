package doubleList;

import stack.MyStack;

public class StackFactory {

    public MyStack factoryMethod() {
    
        MyStack stack = new MyStack() {
        private DoubleLinkedListImpl list;
        
        public void push(int elem) {
            list.addElem(elem);
        }
        
        public void pop (int elem) {
            elem = list.get(list.size() - 1);
            list.remove(list.size() - 1);
        }
        
        public int length() {
            return list.size();
        }
        
        public boolean isEmpty() {
            return (list.size() == 0);
        }
        
        public int peek() {
            return list.get(list.size() - 1);
        }
    };
    return stack;
    }
}
