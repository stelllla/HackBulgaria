package pair;

public final class Pair {
    
    private int p1,p2;
    
    public Pair(int p1,int p2) {
        this.p1 = p1;
        this.p2 =p2;
    }

    public int getP1() {
        return p1;
    }

    public int getP2() {
        return p2;
    }


    @Override
    public String toString() {
        return "Pair [p1=" + p1 + ", p2=" + p2 + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pair other = (Pair) obj;
        if (p1 != other.p1)
            return false;
        if (p2 != other.p2)
            return false;
        return true;
    }
    
}
