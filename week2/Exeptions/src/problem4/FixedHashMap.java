package problem4;

import java.util.HashMap;

public class FixedHashMap<K, V> extends HashMap<K, V> {

    private boolean flag = false;
    private HashMap<K, V> hash;

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    FixedHashMap(boolean flag) {
        hash = new HashMap<K, V>();
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean putElem(K key, V value) throws NullKeyValueException {
        if (flag && (key == null || value == null)) {
            throw new NullKeyValueException();
        }

        hash.put(key, value);
        return true;
    }

    public V getElem(K key) throws NullKeyValueException {
        if (flag && key == null) {
            throw new NullKeyValueException();
        }

        return hash.get(key);
    }

    public static void main(String[] args) {
        FixedHashMap<String, String> hash = new FixedHashMap<>(true);
        
        try {
            String k = null;
            String v = null;
            hash.putElem(k,v);
        } catch ( NullKeyValueException e) {
            System.out.println(e.getMessage());
        }
    }
}
