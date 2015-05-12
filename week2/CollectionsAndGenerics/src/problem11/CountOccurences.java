package problem11;

import java.util.LinkedHashMap;
import java.util.Map;

public class CountOccurences {

    public Map<String, Integer> countOccurences(String text) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        String[] array = text.split(" ");

        for (String s : array) {
            if (map.containsKey(s)) {
                Integer i = map.get(s);
                i++;
                map.put(s, i);
            } else {
                map.put(s, new Integer(1));
            }
        }

        return map;
    }

}
