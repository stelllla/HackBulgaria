package pair;

public class TestPair {
    public static void main(String[] args) {
        
        Pair one = new Pair (2,1);
        Pair two = new Pair (1,2);
        
        boolean eq = one.equals(two);
        System.out.println(eq);
        System.out.println(one);
    }

}
