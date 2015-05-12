package problem10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class ReadableHashMap<K, V> {

    private HashMap<K, V> hash = new HashMap<>();

    @SuppressWarnings("unchecked")
    public ReadableHashMap(int n) {
        for (int i = 0; i < n; i++) {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            K key = (K) sc.nextLine();
            V value = (V) sc.nextLine();
            hash.put(key, value);
        }

    }

    public String printHashMap() {

        StringBuilder res = new StringBuilder();

        Iterator<Entry<K, V>> iter = hash.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<K, V> entry = iter.next();
            res.append("key->");
            res.append(entry.getKey());
            res.append(':').append("value->");
            res.append(entry.getValue());

            if (iter.hasNext()) {
                res.append(',').append(' ');
            }
        }
        return res.toString();
    }
}
